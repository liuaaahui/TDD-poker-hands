package com.example;

import java.util.*;

public class Judge {
    public CardType judgeType(String cards) {
        String[] cardsArray = cards.split(" ");
        Arrays.sort(cardsArray);
        if (isStraight(cardsArray) && isFlush(cardsArray)) return CardType.STRAIGHT_FLUSH;
        if (isFourOfAKind(cardsArray)) return CardType.Four_OF_A_KIND;
        if (isFullHouse(cardsArray)) return CardType.FULL_HOUSE;
        if (isFlush(cardsArray)) return CardType.FLUSH;
        if (isStraight(cardsArray)) return CardType.STRAIGHT;
        if (isThreeOfAKind(cardsArray)) return CardType.THREE_OF_A_KIND;
        if (isTwoPairs(cardsArray)) return CardType.TWO_PAIRS;
        return null;
    }

    private boolean isTwoPairs(String[] cardsArray) {
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
        return counter[1] == 1 && counter[2] == 2;

    }

    private boolean isThreeOfAKind(String[] cardsArray) {
        Map<Character, Integer> map = new HashMap<>();
        for (String card : cardsArray) {
            Character point = card.charAt(0);
            map.merge(point, 1, Integer::sum);
        }
        return map.size() == 3 &&
                map.get(cardsArray[2].charAt(0)) == 3;
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
        Map<Character, Integer> map = new HashMap<>();
        for (String card : cardsArray) {
            Character point = card.charAt(0);
            map.merge(point, 1, Integer::sum);

        }
        return map.size() == 2 && (
                (map.get(cardsArray[0].charAt(0)) == 2 && map.get(cardsArray[4].charAt(0)) == 3)
                        || (map.get(cardsArray[0].charAt(0)) == 3 && map.get(cardsArray[4].charAt(0)) == 2));

    }

    private boolean isFourOfAKind(String[] cardsArray) {
        int flag = 0;
        char previousPoint = cardsArray[1].charAt(0);
        for (int i = 0; i < 5; i++) {
            if (cardsArray[i].charAt(0) == previousPoint) {
                flag++;
            }
        }
        return flag == 4;
    }


}
