package com.example;

public enum CardType {
    STRAIGHT_FLUSH(9),
    Four_OF_A_KIND(8),
    FULL_HOUSE(7);
    private final int weight;

    CardType(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
