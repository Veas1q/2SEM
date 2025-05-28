package org.example;

public class Graph {
    public static final int SPEED = 1000;
    public static final int[][] MATRIX  = {
            {0,5,11,7,0,0,0,0,0,0,0}, // из вершины 1
            {5,0,0,4,0,3,7,0,0,0,0},
            {11,0,0,0,8,0,0,0,0,0,0},
            {7,4,0,0,5,0,0,9,0,0,0},
            {0,0,8,5,0,0,0,6,0,7,0},
            {0,3,0,0,0,0,0,12,8,0,0},
            {0,7,0,0,0,0,0,0,11,0,0},
            {0,0,0,9,6,12,0,0,0,0,9},
            {0,0,0,0,0,8,11,0,0,0,2},
            {0,0,0,0,7,0,0,0,0,0,3},
            {0,0,0,0,0,0,0,9,2,3,0}
    };
    private static boolean[] commandI = new boolean[11];
    private static boolean[] commandII = new boolean[11];

    public static synchronized boolean getCommandI(int n) {
        return commandI[n];
    }

    public static synchronized void setCommandI(int n) {
        commandI[n] = true;
    }

    public static synchronized boolean getCommandII(int n) {
        return commandII[n];
    }

    public static synchronized void setCommandII(int n) {
        commandII[n] = true;
    }
    public static synchronized boolean readAndWriteI(int n){
        if(!commandI[n]) {
            commandI[n] = true;
            return true;
        }
        return false;
    }

}
