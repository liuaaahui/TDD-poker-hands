package com.example;

import java.util.HashMap;
import java.util.Map;

public class ResultMapper {
    private final Map<Character,String> pointMap;
    private final Map<CardType,String> cardTypeMap;
    public ResultMapper() {
        pointMap = pointMapInitial();
        cardTypeMap=cardTypeMapperInitial();
    }

    private Map<CardType,String> cardTypeMapperInitial() {
        Map<CardType, String>  cardTypeMap;
        cardTypeMap = new HashMap<>();
        cardTypeMap.put(CardType.HIGH_CARD,"high card");
        return cardTypeMap;
    }

    private Map<Character, String> pointMapInitial() {
        Map<Character, String> pointMap;
        pointMap = new HashMap<>();
        pointMap.put('A', "Ace");
        pointMap.put('K', "k");
        pointMap.put('Q', "Q");
        pointMap.put('J', "J");
        pointMap.put('T', "10");
        pointMap.put('9', "9");
        pointMap.put('8', "8");
        pointMap.put('7', "7");
        pointMap.put('6', "6");
        pointMap.put('5', "5");
        pointMap.put('4', "4");
        pointMap.put('3', "3");
        pointMap.put('2', "2");
        return pointMap;
    }

    public String getPointResult(String card) {
        return pointMap.get(card.charAt(0));
    }
    public  String getCardTypeResult(CardType cardType){return cardTypeMap.get(cardType);}
}