package org.example;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Raiting implements Serializable {
    List<Game> games = new ArrayList<>();
}
class Game implements Serializable {
    String playerName;
    Integer score;
    Date gameDate;
}