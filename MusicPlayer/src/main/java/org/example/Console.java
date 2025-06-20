package org.example;

import java.util.Scanner;

public class Console {
    private Playlist playlist;
    private Scanner scanner;
    private int currentTrackNumber = 0;

    public Console() {
        this.playlist = new Playlist();
        this.scanner = new Scanner(System.in);
        playlist.load();
    }

    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    showAllTracks();
                    break;
                case "2":
                    findTrackByName();
                    break;
                case "3":
                    findTrackByAuthor();
                    break;
                case "4":
                    playTrackByNumber();
                    break;
                case "5":
                    stopPlayback();
                    break;
                case "6":
                    playNextTrack();
                    break;
                case "7":
                    playPreviousTrack();
                    break;
                case "8":
                    addNewTrack();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте еще раз.");
            }
        }

        playlist.save();
        WavPlayer.close();
        scanner.close();
        System.out.println("Программа завершена.");
    }

    private void printMenu() {
        System.out.println("\n=== Меню плеера ===");
        System.out.println("1. Показать все треки");
        System.out.println("2. Найти трек по названию");
        System.out.println("3. Найти трек по автору");
        System.out.println("4. Проиграть трек по номеру");
        System.out.println("5. Остановить проигрывание");
        System.out.println("6. Следующий трек");
        System.out.println("7. Предыдущий трек");
        System.out.println("8. Добавить трек");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private void showAllTracks() {
        System.out.println("\n=== Все треки ===");
        playlist.showAll();
    }

    private void findTrackByName() {
        System.out.print("\nВведите название трека: ");
        String name = scanner.nextLine();
        System.out.println("Найденные треки:");
        playlist.findByName(name);
    }

    private void findTrackByAuthor() {
        System.out.print("\nВведите имя автора: ");
        String author = scanner.nextLine();
        System.out.println("Найденные треки:");
        playlist.findByAuthor(author);
    }

    private void playTrackByNumber() {
        System.out.print("\nВведите номер трека: ");
        try {
            int number = Integer.parseInt(scanner.nextLine());
            currentTrackNumber = number;
            playlist.playMusic(number);
        } catch (Exception e) {
            System.out.println("Ошибка: неверный номер трека.");
        }
    }

    private void stopPlayback() {
        WavPlayer.stopMusic();
        System.out.println("Воспроизведение остановлено.");
    }
    private void playNextTrack() {
        if (currentTrackNumber < playlist.size()) {
            currentTrackNumber++;
            Track nextTrack = playlist.getByNumber(currentTrackNumber);
            if (nextTrack != null) {
                playlist.playMusic(currentTrackNumber);
            } else {
                System.out.println("Трек с номером " + currentTrackNumber + " не найден.");
                currentTrackNumber--; // Возвращаем предыдущий номер
            }
        } else {
            System.out.println("Это последний трек в плейлисте.");
        }
    }

    private void playPreviousTrack() {
        if (currentTrackNumber > 1) {
            currentTrackNumber--;
            Track prevTrack = playlist.getByNumber(currentTrackNumber);
            if (prevTrack != null) {
                playlist.playMusic(currentTrackNumber);
            } else {
                System.out.println("Трек с номером " + currentTrackNumber + " не найден.");
                currentTrackNumber++; // Возвращаем следующий номер
            }
        } else {
            System.out.println("Это первый трек в плейлисте.");
        }
    }

    private void addNewTrack() {
        try {
            System.out.println("\nДобавление нового трека:");
            System.out.print("Номер: ");
            int number = Integer.parseInt(scanner.nextLine());

            System.out.print("Название: ");
            String name = scanner.nextLine();

            System.out.print("Автор: ");
            String author = scanner.nextLine();

            System.out.print("Путь к файлу: ");
            String path = scanner.nextLine();

            playlist.add(new Track(number, name, author, path));
            System.out.println("Трек успешно добавлен.");
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении трека: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Console().start();
    }
}
