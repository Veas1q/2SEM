package org.example;

import java.util.function.Consumer;

public class Integral implements Consumer<Double> {
    private static int N;
    private volatile double integral = 0;

    public synchronized void accept(Double d) {
        integral += d;
    }

    public static void main(String[] args) throws InterruptedException {
        // Однопоточный расчет
        long start1 = System.nanoTime();
        double resultSingle = partSum(1, 3, 100000);
        long timeSingle = System.nanoTime() - start1;

        System.out.println("Однопоточный результат: " + resultSingle);
        System.out.println("Время выполнения: " + timeSingle + " нс");

        // Многопоточный расчет
        long start2 = System.nanoTime();
        Integral integral = new Integral();
        int cores = Runtime.getRuntime().availableProcessors();
        N = 10000 / cores;
        double h = 2.0 / cores;

        Thread[] threads = new Thread[cores];
        for(int i = 0; i < cores; i++) {
            double a = 1 + h * i;
            double b = 1 + h * (i + 1);
            threads[i] = new Thread(new PartSumCalculate(a, b, integral));
            threads[i].start();
        }

        for(Thread t : threads) {
            t.join();
        }

        long timeMulti = System.nanoTime() - start2;
        System.out.println("Многопоточный результат: " + integral.integral);
        System.out.println("Время выполнения: " + timeMulti + " нс");
    }

    public static double function(double x) {
        return Math.exp(-x * x/2) * Math.sin(x);
    }

    public static double partSum(double a, double b, int N) {
        double h = (b - a)/N;
        double sum = 0;
        for(int i = 0; i < N; i++) {
            double x1 = a + h * i;
            double x2 = a + h * (i + 1);
            sum += h * (function(x1) + function(x2))/2;
        }
        return sum;
    }

    static class PartSumCalculate implements Runnable {
        private final double a, b;
        private final Consumer<Double> consumer;

        public PartSumCalculate(double a, double b, Consumer<Double> consumer) {
            this.a = a;
            this.b = b;
            this.consumer = consumer;
        }

        public void run() {
            consumer.accept(partSum(a, b, N));
        }
    }
}