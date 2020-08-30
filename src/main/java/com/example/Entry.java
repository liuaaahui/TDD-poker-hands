package com.example;

import java.util.*;

public class Entry {
    private Character points;
    private Integer number;

    public Entry(Character points, Integer number) {
        this.points = points;
        this.number = number;
    }

    public Character getPoints() {
        return points;
    }


    public Integer getNumber() {
        return number;
    }

    public static Entry[] cardEntrySort(String[] Cards) {
        Map<Character, Integer> pointMap = new PointMapper().getMap();
        Map<Character, Integer> whiteMap = new HashMap<>();
        for (String card : Cards) {
            Character point = card.charAt(0);
            whiteMap.merge(point, 1, Integer::sum);
        }
        Set<Map.Entry<Character, Integer>> whiteSet = whiteMap.entrySet();
        List<Entry> entryList = new ArrayList<>();
        for (Map.Entry<Character, Integer> characterIntegerEntry : whiteSet) {

            Entry entry = new Entry((characterIntegerEntry).getKey(), (characterIntegerEntry).getValue());
            entryList.add(entry);
        }
        Entry[] entries = entryList.toArray(new Entry[0]);
        Arrays.sort(entries, (a, b) -> {
            if (a.getNumber().compareTo(b.getNumber()) == 0) {
                return pointMap.get(a.getPoints()).compareTo(pointMap.get(b.getPoints()));
            }
            return a.getNumber().compareTo(b.getNumber());
        });
        return entries;
    }
}
