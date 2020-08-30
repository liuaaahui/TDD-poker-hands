package com.example;

import java.util.HashMap;
import java.util.Map;

public class ResultMapper {
    private final Map<Character,String> pointMap;
    public ResultMapper() {
        pointMap = pointMapInitial();
    }

    private Map<Character, String> pointMapInitial() {
        Map<Character, String> pointMap;
        pointMap = new HashMap<>();
        pointMap.put('A', "Ace");
        pointMap.put('K', "K");
        pointMap.put('Q', "Q");
        pointMap.put('J', "J");
        pointMap.put('T', "10");
        pointMap.put('9', "9");
        pointMap.put('8', "8");
        pointMap.put('7', "7");
        pointMap.put('6', "6");
        pointMap.put('5', "5");
        pointMap.put('4', "4");
        pointMap.put('3', "3");
        pointMap.put('2', "2");
        return pointMap;
    }

    public String getPointResult(String card) {
        return pointMap.get(card.charAt(0));
    }
}