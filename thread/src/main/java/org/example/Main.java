package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread task1 = new MyTaskTread(1);
        Thread task2 = new MyTaskTread(2);
        Thread task3 = new MyTaskTread(3);
        Thread task4 = new MyTaskTread(4);
        Thread task5 = new MyTaskTread(5);
        Thread[] tasks = {task1, task2, task3, task4, task5};
        for (int i = 0; i < 5; i++) {
            tasks[i].start();
        }

    }
    //описать задачу
    static class MyTaskTread extends Thread{
        private int index;
        public MyTaskTread(int index){
            this.index = index;
        }
        //задача
        public void run() {
            System.out.println("Привет из параллельной реальности " + index);
        }
    }

}