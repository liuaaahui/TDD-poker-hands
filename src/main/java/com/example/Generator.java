package com.example;

public class Generator {

    public String generateResult(String[] cards,CardType cardType) {
        ResultMapper resultMapper=new ResultMapper();
        if(cardType==CardType.HIGH_CARD){
            return String.format("%s: %s",
                    resultMapper.getCardTypeResult(cardType),
                    resultMapper.getPointResult(cards[cards.length-1]));
        }
        else return null;
    }

}
