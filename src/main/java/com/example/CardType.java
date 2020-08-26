package com.example;

public enum CardType {
    STRAIGHT_FLUSH(9);

    private final int weight;

    CardType(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
