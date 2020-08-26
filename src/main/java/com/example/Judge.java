package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Judge {
    public CardType judgeType(String cards) {
        String[] cardsArray = cards.split(" ");
        Arrays.sort(cardsArray);
        if (isFourOfAKind(cardsArray)) return CardType.Four_OF_A_KIND;
        if (isFullHouse(cardsArray)) return CardType.FULL_HOUSE;
        if (isFlush(cardsArray)) return CardType.FLUSH;
        char previousColor = cardsArray[0].charAt(1);
        char previousPoint = cardsArray[0].charAt(0);
        for (int i = 1; i < 5; i++) {
            if (cardsArray[i].charAt(0) != previousPoint + 1 || cardsArray[i].charAt(1) != previousColor) return null;
            else {
                previousPoint = cardsArray[i].charAt(0);
            }
        }
        return CardType.STRAIGHT_FLUSH;
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
