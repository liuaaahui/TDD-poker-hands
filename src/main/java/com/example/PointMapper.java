package com.example;

import java.util.HashMap;
import java.util.Map;

public class PointMapper {
    private final Map<Character, Integer> map;

    public PointMapper() {
        map = new HashMap<>();
        map.put('A', 14);
        map.put('K', 13);
        map.put('Q', 12);
        map.put('J', 11);
        map.put('T', 10);
        map.put('9', 9);
        map.put('8', 8);
        map.put('7', 7);
        map.put('6', 6);
        map.put('5', 5);
        map.put('4', 4);
        map.put('3', 3);
        map.put('2', 2);
    }

    public Map<Character, Integer> getMap() {
        return map;
    }
}
