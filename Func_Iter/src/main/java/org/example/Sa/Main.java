package org.example.Sa;

public class Main {
    public static void main(String[] args) {
//        // Создаем экземпляры цветов
        Flower rose = new Flower("Красная роза");
        Flower aster = new Flower("Синяя астра");
        Flower chamomile = new Flower("Белая ромашка");

        System.out.println("Маршрут первого садовника:");
        Garden garden1 = new Garden(rose, aster, chamomile,1);
        // Вариант 1: Использование for-each
        for (Flower flower : garden1) {
            System.out.println("Поливаем: " + flower);
        }

        System.out.println("\nМаршрут второго садовника:");
        Garden garden2 = new Garden(rose, aster, chamomile, 2);
        for (Flower flower : garden2){
            System.out.println("Поливаем: " + flower);

        }
    }
}