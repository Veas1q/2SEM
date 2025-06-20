package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Track> playlist;

    public Playlist() {
        playlist = new ArrayList<>();
    }

    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("PlayList.pst"))) {
            oos.writeObject(playlist);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("PlayList.pst"))) {
            playlist = (List<Track>) ois.readObject();
        } catch (FileNotFoundException e) {
            playlist = new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Track track) {
        playlist.add(track);
    }

    public void showAll() {
        for (Track t : playlist) {
            System.out.println(t.getNumber() + ": " + t.getName() + " " + t.getAuthor());
        }
    }

    public void findByName(String name) {
        String searchName = name.toUpperCase();
        for (Track t : playlist) {
            if (t.getName().toUpperCase().contains(searchName)) {
                System.out.println(t.getNumber() + ": " + t.getName() + " " + t.getAuthor());
            }
        }
    }

    public void findByAuthor(String author) {
        String searchAuthor = author.toUpperCase();
        for (Track t : playlist) {
            if (t.getAuthor().toUpperCase().contains(searchAuthor)) {
                System.out.println(t.getNumber() + ": " + t.getName() + " " + t.getAuthor());
            }
        }
    }

    public Track getByNumber(int number) {
        for (Track t : playlist) {
            if (t.getNumber().equals(number)) {
                return t;
            }
        }
        return null;
    }

    public int size() {
        return playlist.size();
    }

    public void playMusic(int number) {
        Track t = getByNumber(number);
        if (t != null) {
            WavPlayer.startPlayMusic(t.getPath());
        } else {
            System.out.println("Трек с номером " + number + " не найден.");
        }
    }
}