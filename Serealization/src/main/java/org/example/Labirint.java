package org.example;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Labirint implements Serializable {
    private static final char WALL = '1';
    private static final char PATH = '0';
    private static final char TRACK = '#';
    private static final char PLAYER = '@';
    private static final char START = '@';

    private final char[][] labirint = {
            {WALL, WALL, WALL, PATH, WALL, WALL, WALL},
            {WALL, PATH, PATH, PATH, WALL, PATH, WALL},
            {WALL, PATH, WALL, WALL, PATH, WALL, WALL},
            {WALL, PATH, PATH, PATH, PATH, PATH, WALL},
            {WALL, PATH, WALL, PATH, WALL, PATH, WALL},
            {WALL, PATH, PATH, WALL, WALL, PATH, WALL},
            {WALL, WALL, WALL, WALL, WALL, PATH, WALL}
    };

    private final char[][] playerView;
    private int posPlayerI;
    private int posPlayerJ;
    private final int exitPosI = 6;
    private final int exitPosJ = 5;
    private int count = 0;

    public int getPosPlayerI() {
        return posPlayerI;
    }

    public int getPosPlayerJ() {
        return posPlayerJ;
    }

    public int getExitPosI() {
        return exitPosI;
    }

    public int getExitPosJ() {
        return exitPosJ;
    }

    public Labirint(){
        posPlayerI = 0;
        posPlayerJ = 3;

        playerView = new char[labirint.length][labirint.length];
        for (int i = 0; i < labirint.length; ++i){
            for (int j = 0; j < labirint.length; ++j){
                playerView[i][j] = labirint[i][j] == WALL ? WALL : ' ';
            }
        }

        playerView[posPlayerI][posPlayerJ] = START;
        playerView[exitPosI][exitPosJ] = PATH;

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Labirint labirint = null;

        System.out.println("Выберите действие: ");
        System.out.println("1. Новая игра");
        System.out.println("2. Загрузить игру");
        System.out.println("3. Выход");

        String strNameFile = "";

        int choice = scanner.nextInt();
        scanner.nextLine();
        while (labirint == null) {
            if (choice == 1) {
                labirint = new Labirint();
                break;
            } else if (choice == 2) {
                System.out.println("Введите имя файла: ");
                strNameFile = scanner.nextLine();
                if (strNameFile.equals("ESC")){
                    System.out.println("Выход");
                    System.exit(0);
                }
                try {
                    FileInputStream fis = new FileInputStream(strNameFile);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    labirint = (Labirint) ois.readObject();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println("неправильное имя файла");
                }
            }
            else if (choice == 3){
                System.out.println("Выход");
                break;
            }
        }
        String str = "";
        while ((labirint.getExitPosI() != labirint.getPosPlayerI() || labirint.getExitPosJ() != labirint.getPosPlayerJ()) && !str.equals("ESC")) {
            labirint.play();
            str = scanner.nextLine();
            if (str.equals("ESC")){
                System.out.println("Введите имя файла для сохранения");
                strNameFile = scanner.nextLine();
                try (FileOutputStream fos = new FileOutputStream(strNameFile);
                     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(labirint);
                    fos.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (!str.equals("")) {
                char c = str.charAt(0);
                labirint.movePlayer(c);
                labirint.play();
            }
        }

    }




    public  void play(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите команду (W - вверх, S - вниз, D - вправо, A - влево)");
        System.out.println("Вы сейчас здесь - @");
        printField();


    }


    public boolean movePlayer(char direction){
        int newI = posPlayerI;
        int newJ = posPlayerJ;

        switch (direction) {
            case 'W': newI--; break;
            case 'S': newI++; break;
            case 'A': newJ--; break;
            case 'D': newJ++; break;
            default: return false;
        }

        if (newI < 0 || newI >= labirint.length || newJ < 0 || newJ >= labirint[0].length){
            return false;
        }

        if (labirint[newI][newJ] != PATH){
            return false;
        }

        playerView[posPlayerI][posPlayerJ] = TRACK;
        posPlayerI = newI;
        posPlayerJ = newJ;
        playerView[posPlayerI][posPlayerJ] = PLAYER;
        count++;

        return true;
    }

    public void printField() {
        for (char[] row : playerView){
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }




}