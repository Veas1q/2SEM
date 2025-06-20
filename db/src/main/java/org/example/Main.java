package org.example;

import org.example.db.DBUtils;

import java.util.List;
import java.util.Scanner;

public class Main {
    static {
        printMenu();
    }
    public static void main(String[] args) {
    }
    private static void printMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Система управления студентами ===");
            System.out.println("1. Добавить студента");
            System.out.println("2. Найти студента по ID");
            System.out.println("3. Обновить данные студента");
            System.out.println("4. Удалить студента");
            System.out.println("5. Показать всех студентов");
            System.out.println("6. Экспорт в HTML");
            System.out.println("0. Выход");
            System.out.print("Выберите действие: ");

            int command;
            try {
                command = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера
            } catch (RuntimeException e) {
                System.out.println("Ошибка: введите число от 0 до 6!");
                scanner.nextLine(); // Очистка неверного ввода
                continue;
            }

            switch (command) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    findStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    showAllStudents();
                    break;
                case 6:
                    DBUtils.saveHtmlFile();
                    break;
                case 0:
                    exitProgram();
                    return;
                default:
                    System.out.println("Неверная команда! Введите число от 0 до 7.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.println("\n[Добавление студента]");
        Student student = new Student();

        System.out.print("Введите ID: ");
        student.setId(scanner.nextInt());
        scanner.nextLine(); // Очистка буфера

        System.out.print("Введите имя: ");
        student.setName(scanner.nextLine());

        System.out.print("Введите фамилию: ");
        student.setLastName(scanner.nextLine());

        System.out.print("Введите отчество: ");
        student.setFatherName(scanner.nextLine());

        System.out.print("Введите группу: ");
        student.setGroup(scanner.nextLine());

        DBUtils.appendObject(student);
        System.out.println("Студент успешно добавлен!");
    }

    private static void findStudent(Scanner scanner) {
        System.out.print("\nВведите ID студента: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        Student student = DBUtils.getStudent(id);
        if (student != null) {
            System.out.println("\nНайден студент:");
            System.out.println("ID: " + student.getId());
            System.out.println("ФИО: " + student.getLastName() + " " + student.getName() + " " + student.getFatherName());
            System.out.println("Группа: " + student.getGroup());
        } else {
            System.out.println("Студент с ID " + id + " не найден");
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.println("\n[Обновление данных студента]");
        System.out.print("Введите ID студента: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        Student existing = DBUtils.getStudent(id);
        if (existing == null) {
            System.out.println("Студент с ID " + id + " не найден!");
            return;
        }

        System.out.println("\nТекущие данные:");
        System.out.println(existing);

        Student updated = new Student();
        updated.setId(id);

        System.out.print("Введите новое имя [" + existing.getName() + "]: ");
        updated.setName(scanner.nextLine());

        System.out.print("Введите новую фамилию [" + existing.getLastName() + "]: ");
        updated.setLastName(scanner.nextLine());

        System.out.print("Введите новое отчество [" + existing.getFatherName() + "]: ");
        updated.setFatherName(scanner.nextLine());

        System.out.print("Введите новую группу [" + existing.getGroup() + "]: ");
        updated.setGroup(scanner.nextLine());

        DBUtils.updateStudent(updated);
        System.out.println("Данные студента обновлены!");
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.println("\n[Удаление студента]");
        System.out.print("Введите ID студента: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера
        if (DBUtils.getStudent(id) == null) {
            System.out.println("Студент с ID " + id + " не найден!");
            return;
        }

        DBUtils.deleteStudent(id);
        System.out.println("Студент с ID " + id + " успешно удалён!");
    }

    private static void showAllStudents() {
        System.out.println("\n[Список всех студентов]");

        try {
            List<Student> students = DBUtils.readAll();

            if (students == null || students.isEmpty()) {
                System.out.println("В базе нет студентов");
                return;
            }

            // Простой вывод каждого студента
            for (Student student : students) {
                System.out.println(
                        "ID: " + student.getId() + ", " +
                                "ФИО: " + student.getLastName() + " " +
                                student.getName() + " " +
                                student.getFatherName() + ", " +
                                "Группа: " + student.getGroup()
                );
            }

            System.out.println("\nВсего студентов: " + students.size());

        } catch (RuntimeException e) {
            System.err.println("Ошибка при чтении данных: " + e.getMessage());
        }
    }
//    private static void exportToHtml() {
//        System.out.println("\n[Экспорт в HTML]");
//        try {
//            DBUtils.exportToHtml();
//            System.out.println("Экспорт успешно завершён. Файл: students.html");
//        } catch (Exception e) {
//            System.out.println("Ошибка при экспорте: " + e.getMessage());
//        }
//    }

    private static void exitProgram() {
        System.out.println("Сохранение данных...");
        DBUtils.saveIndex();
        System.out.println("Программа завершена.");
        System.exit(0);
    }

}
