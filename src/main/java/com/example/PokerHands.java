package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class PokerHands {
    public PokerHands() {

    }

    public String play(String white, String black) {

        return null;
    }
    private String[] sortCards(String cardString) {
        Map<Character, Integer> pointMap = new PointMapper().getMap();
        String[] cards = cardString.split(" ");
        Arrays.sort(cards, Comparator.comparing(s -> pointMap.get(s.charAt(0))));
        return cards;
    }
}
