package org.example;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class WavPlayer {
    private static Clip clip; // Делаем clip полем класса, чтобы иметь доступ к нему из других методов

    public static void startPlayMusic(String path) {
        try {
            // Если клип уже существует и играет, останавливаем его
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopMusic() {
        if (clip != null) {
            clip.stop(); // Останавливаем воспроизведение
            clip.setMicrosecondPosition(0); // Перематываем в начало
        }
    }

    // Дополнительные методы управления
    public static void pauseMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop(); // В Clip нет отдельного метода pause, используем stop
        }
    }

    public static void resumeMusic() {
        if (clip != null && !clip.isRunning()) {
            clip.start(); // Продолжаем с того же места
        }
    }

    public static void close() {
        if (clip != null) {
            clip.close(); // Освобождаем ресурсы
        }
    }
}