package com.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class PokerHands {
    private final Generator generator;
    private final Judge judge;

    public PokerHands() {
        generator = new Generator();
        judge = new Judge();
    }

    public String play(String white, String black) {
        String[] whiteCards = sortCards(white);
        String[] blackCards = sortCards(black);
        return getResult(whiteCards, blackCards);
    }

    private String getCardResult(String[] cards, CardType cardType) {
        return generator.generateResult(cards, cardType);
    }

    private String getResult(String[] whiteCards, String[] blackCards) {
        String winner;
        String cardResult;
        CardType whiteCardType = judge.judgeType(whiteCards);
        CardType blackCardType = judge.judgeType(blackCards);
        if(judge.isTie(whiteCards,blackCards))return "Tie.";
        if (whiteCardType.getWeight() > blackCardType.getWeight()) {
            winner = "white wins.";
            cardResult = getCardResult(whiteCards, whiteCardType);
        } else if (whiteCardType.getWeight() <blackCardType.getWeight()){
            winner = "black wins.";
            cardResult = getCardResult(blackCards, blackCardType);
        } else {
            if (judge.judgeFaceWithSameType(whiteCards, blackCards, whiteCardType) > 0){
                winner = "white wins.";
                cardResult = getCardResult(whiteCards, whiteCardType);
            } else{
                winner = "black wins.";
                cardResult = getCardResult(blackCards,blackCardType);
            }
        }
        return String.format("%s - with %s", winner,cardResult);
    }

    private String[] sortCards(String cardString) {
        Map<Character, Integer> pointMap = new PointMapper().getMap();
        String[] cards = cardString.split(" ");
        Arrays.sort(cards, Comparator.comparing(s -> pointMap.get(s.charAt(0))));
        return cards;
    }
}
