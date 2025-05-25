package org.example;
import java.util.function.Consumer;

public class Integral implements Consumer<Double>{

    private static int N;
    private volatile double integral = 0;

    public synchronized void accept(Double d) {
        integral += d;
    }

    public static void main(String[] args) throws InterruptedException {
        Integral integral = new Integral();
        int countProc = Runtime.getRuntime().availableProcessors();
        N = 10000 / countProc;
        double h = (double) (3 - 1) /  countProc;
        Thread[] threads = new Thread[countProc];
        for(int i = 0; i < countProc; i++) {
            threads[i] = new Thread(new PartSumCalculate(1 + h*i, 1+ h*(i + 1), integral));
            threads[i].start();
        }

        for(int i = 0; i < countProc; i++) {
            threads[i].join();
        }

        System.out.println(integral.integral);
    }

    public static double function(double x) {
        return Math.exp(-x * x/2) *Math.sin(x);
    }

    public static double partSum(double a, double b, int N) {
        double h = (b - a)/N;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += h * (function(a + h*i) + function(a + h*(i + 1)))/2;
        }
        return sum;
    }

    static class PartSumCalculate implements Runnable {
        private double a;
        private double b;
        private Consumer<Double> consumer;

        public PartSumCalculate(double a, double b, Consumer<Double> consumer) {
            this.a = a;
            this.b = b;
            this. consumer = consumer;
        }

        public void run() {
            double result = partSum(a, b ,N);
            consumer.accept(result);
        }
    }
}
