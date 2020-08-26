package com.example;

import java.util.Arrays;

public class Judge {
    public CardType judgeType(String cards) {
        String[] cardsArray = cards.split(" ");
        Arrays.sort(cardsArray);
        if (isFourOfAKind(cardsArray)) return CardType.Four_OF_A_KIND;
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
