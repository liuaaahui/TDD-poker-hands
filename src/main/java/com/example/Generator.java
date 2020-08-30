package com.example;

import static com.example.Entry.cardEntrySort;

public class Generator {
    private final ResultMapper resultMapper;

    public Generator() {
        resultMapper = new ResultMapper();
    }

    public String generateResult(String[] cards, CardType cardType) {
        switch (cardType) {
            case HIGH_CARD:
                return getHighCardResult(cards);
            case PAIR:
                return getPairResult(cards);
            case TWO_PAIRS:
                return getTwoPairsResult(cards);
            case THREE_OF_A_KIND:
                return getThreeOfAKindResult(cards);
            case STRAIGHT:
                return getStraightResult(cards);

            default:
                throw new IllegalStateException("Unexpected value: " + cardType);
        }

    }

    private String getStraightResult(String[] cards) {
        return String.format("straight: %s",resultMapper.getPointResult(cards[4]));
    }

    private String getThreeOfAKindResult(String[] cards) {
        return String.format("three of a kind: %s",
                resultMapper.getPointResult(cards[2]));
    }

    private String getTwoPairsResult(String[] cards) {
        Entry[] entries = cardEntrySort(cards);
        return String.format("two pairs %s and %s",
                resultMapper.getPointResult(String.valueOf(entries[entries.length - 1].getPoints())),
                resultMapper.getPointResult(String.valueOf(entries[entries.length - 2].getPoints())));
    }

    private String getPairResult(String[] cards) {
        Entry[] entries = cardEntrySort(cards);
        return String.format("Pair of %s",
                resultMapper.getPointResult(String.valueOf(entries[entries.length - 1].getPoints())));
    }

    private String getHighCardResult(String[] cards) {
        return String.format("high card: %s",
                resultMapper.getPointResult(cards[cards.length - 1]));
    }

}
