package com.example;

import java.util.*;

public class Judge {
    public CardType judgeType(String cards) {
        String[] cardsArray = sortCards(cards);

        if (isStraight(cardsArray) && isFlush(cardsArray)) return CardType.STRAIGHT_FLUSH;
        if (isFourOfAKind(cardsArray)) return CardType.Four_OF_A_KIND;
        if (isFullHouse(cardsArray)) return CardType.FULL_HOUSE;
        if (isFlush(cardsArray)) return CardType.FLUSH;
        if (isStraight(cardsArray)) return CardType.STRAIGHT;
        if (isThreeOfAKind(cardsArray)) return CardType.THREE_OF_A_KIND;
        if (isTwoPairs(cardsArray)) return CardType.TWO_PAIRS;
        if (isPair(cardsArray)) return CardType.PAIR;

        return CardType.HIGH_CARD;
    }

    private boolean isPair(String[] cardsArray) {
        int[] counter = getCounter(cardsArray);
        return counter[1] == 3 && counter[2] == 1;
    }

    private boolean isTwoPairs(String[] cardsArray) {
        int[] counter = getCounter(cardsArray);
        return counter[1] == 1 && counter[2] == 2;

    }

    private boolean isThreeOfAKind(String[] cardsArray) {
        int[] counter = getCounter(cardsArray);
        return counter[1] == 2 && counter[3] == 1;
    }

    private boolean isStraight(String[] cardsArray) {
        char previousPoint = cardsArray[0].charAt(0);
        for (int i = 1; i < 5; i++) {
            if (previousPoint + 1 != cardsArray[i].charAt(0)) return false;
            previousPoint++;
        }
        return true;
    }

    private boolean isFlush(String[] cardsArray) {
        Map<Character, Integer> map = new HashMap<>();
        for (String card : cardsArray) {
            Character point = card.charAt(1);
            map.merge(point, 1, Integer::sum);

        }
        return map.size() == 1 &&
                map.get(cardsArray[0].charAt(1)) == 5;
    }

    private boolean isFullHouse(String[] cardsArray) {
        int[] counter = getCounter(cardsArray);
        return counter[3] == 1 && counter[2] == 1;

    }

    private int[] getCounter(String[] cardsArray) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (String card : cardsArray) {
            Character point = card.charAt(0);
            map.merge(point, 1, Integer::sum);
            set.add(card.charAt(0));
        }
        int[] counter = new int[5];
        for (Character point : set) {
            counter[map.get(point)]++;
        }
        return counter;
    }

    private boolean isFourOfAKind(String[] cardsArray) {
        int[] counter = getCounter(cardsArray);
        return counter[4] == 1 && counter[1] == 1;
    }


    public int judgeFaceWithSameType(String white, String black, CardType cardType) {
        Map<Character, Integer> pointMap = new PointMapper().getMap();
        String[] whiteCards = sortCards(white);
        String[] blackCards = sortCards(black);
        if (isTie(whiteCards, blackCards)) return 0;
        if (cardType == CardType.STRAIGHT_FLUSH) {
            return pointMap.get(whiteCards[whiteCards.length - 1].charAt(0)).compareTo(pointMap.get(blackCards[blackCards.length - 1].charAt(0)));
        }
        if (cardType == CardType.Four_OF_A_KIND) {
            return pointMap.get(whiteCards[1].charAt(0)).compareTo(pointMap.get(blackCards[1].charAt(0)));
        }
        if (cardType == CardType.FULL_HOUSE) {
            return pointMap.get(whiteCards[2].charAt(0)).compareTo(pointMap.get(blackCards[2].charAt(0)));
        }
        if (cardType == CardType.FLUSH) {
            for (int index = 4; index >= 0; index--) {
                int result = pointMap.get(whiteCards[index].charAt(0)).compareTo(pointMap.get(blackCards[index].charAt(0)));
                if (result != 0) return result;
            }

        }
        return 0;

    }

    private boolean isTie(String[] whiteCards, String[] blackCards) {
        for (int cardIndex = 0; cardIndex < whiteCards.length; cardIndex++) {
            if (whiteCards[cardIndex].charAt(0) != blackCards[cardIndex].charAt(0))
                return false;
        }
        return true;
    }

    private String[] sortCards(String cardString) {
        Map<Character, Integer> pointMap = new PointMapper().getMap();
        String[] cards = cardString.split(" ");
        Arrays.sort(cards, Comparator.comparing(s -> pointMap.get(s.charAt(0))));
        return cards;
    }

}
