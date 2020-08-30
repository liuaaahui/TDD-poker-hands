package com.example;

import java.util.*;

public class Judge {
    public CardType judgeType(String[] cards) {
        if (isStraight(cards) && isFlush(cards)) return CardType.STRAIGHT_FLUSH;
        if (isFourOfAKind(cards)) return CardType.Four_OF_A_KIND;
        if (isFullHouse(cards)) return CardType.FULL_HOUSE;
        if (isFlush(cards)) return CardType.FLUSH;
        if (isStraight(cards)) return CardType.STRAIGHT;
        if (isThreeOfAKind(cards)) return CardType.THREE_OF_A_KIND;
        if (isTwoPairs(cards)) return CardType.TWO_PAIRS;
        if (isPair(cards)) return CardType.PAIR;

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


    public int judgeFaceWithSameType(String[] whiteCards, String[] blackCards, CardType cardType) {
        Map<Character, Integer> pointMap = new PointMapper().getMap();
        if (isTie(whiteCards, blackCards)) return 0;
        if (cardType == CardType.STRAIGHT_FLUSH || cardType == CardType.STRAIGHT) {
            return pointMap.get(whiteCards[whiteCards.length - 1].charAt(0)).compareTo(pointMap.get(blackCards[blackCards.length - 1].charAt(0)));
        }
        if (cardType == CardType.Four_OF_A_KIND) {
            return pointMap.get(whiteCards[1].charAt(0)).compareTo(pointMap.get(blackCards[1].charAt(0)));
        }
        if (cardType == CardType.FULL_HOUSE || cardType == CardType.THREE_OF_A_KIND) {
            return pointMap.get(whiteCards[2].charAt(0)).compareTo(pointMap.get(blackCards[2].charAt(0)));
        }
        if (cardType == CardType.FLUSH || cardType == CardType.HIGH_CARD) {
            for (int index = 4; index >= 0; index--) {
                int result = pointMap.get(whiteCards[index].charAt(0)).compareTo(pointMap.get(blackCards[index].charAt(0)));
                if (result != 0) return result;
            }
        }
        if (cardType == CardType.TWO_PAIRS || cardType == CardType.PAIR) {
            return judgeFaceWhenExistPair(whiteCards, blackCards);
        }
        return 0;

    }

    private int judgeFaceWhenExistPair(String[] whiteCards, String[] blackCards) {
        Entry[] whiteEntry = cardEntrySort(whiteCards);
        Entry[] blackEntry = cardEntrySort(blackCards);
        for (int i = 0; i < whiteEntry.length; i++) {
            int result = whiteEntry[i].getPoints().compareTo(blackEntry[i].getPoints());
            if (result != 0) return result;
        }
        return 0;
    }

    private Entry[] cardEntrySort(String[] Cards) {
        Map<Character, Integer> pointMap = new PointMapper().getMap();
        Map<Character, Integer> whiteMap = new HashMap<>();
        for (String card : Cards) {
            Character point = card.charAt(0);
            whiteMap.merge(point, 1, Integer::sum);
        }
        Set<Map.Entry<Character, Integer>> whiteSet = whiteMap.entrySet();
        List<Entry> entryList = new ArrayList<>();
        for (Map.Entry<Character, Integer> characterIntegerEntry : whiteSet) {

            Entry entry = new Entry((characterIntegerEntry).getKey(), (characterIntegerEntry).getValue());
            entryList.add(entry);
        }
        Entry[] entries = entryList.toArray(new Entry[0]);
        Arrays.sort(entries, (a, b) -> {
            if (a.getNumber().compareTo(b.getNumber()) == 0) {
                return pointMap.get(a.getPoints()).compareTo(pointMap.get(b.getPoints()));
            }
            return a.getNumber().compareTo(b.getNumber());
        });
        return entries;
    }

    private boolean isTie(String[] whiteCards, String[] blackCards) {
        for (int cardIndex = 0; cardIndex < whiteCards.length; cardIndex++) {
            if (whiteCards[cardIndex].charAt(0) != blackCards[cardIndex].charAt(0))
                return false;
        }
        return true;
    }



    private class Entry {
        Character points;
        Integer number;

        public Entry(Character points, Integer number) {
            this.points = points;
            this.number = number;
        }

        public Character getPoints() {
            return points;
        }

        public void setPoints(Character points) {
            this.points = points;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }
    }

}
