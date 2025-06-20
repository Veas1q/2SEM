package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rating implements Serializable {
    List<Game> games = new ArrayList<>();
}
