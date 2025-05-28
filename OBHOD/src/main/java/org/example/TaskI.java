package org.example;

public class TaskI implements Runnable{
    @Override
    public void run(){
        int vertex = 0;
        try {
            while (true) {
                for (int i = 0; i < 11; i++) {
                    if (Graph.MATRIX[vertex][i] != 0 && Graph.readAndWriteI(i)) {
                        Thread.sleep(Graph.MATRIX[vertex][i] * Graph.SPEED);
                    }
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
