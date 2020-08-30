package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratorTest {
    private static Generator generator;

    @BeforeAll
    public static void setUp() {
        generator = new Generator();
    }

    @Test
    void should_return_high_card_Ace_when_generateResult_given_4H7H9HTCAD() {
        //given
        String[] cards = {"4H", "7H","9H","TC","AD"};
        //when
        String result = generator.generateResult(cards, CardType.HIGH_CARD);

        //then
        assertEquals("high card: Ace", result);
    }
    @Test
    void should_return_pair_of_8_when_generateResult_given_4H8H8D9CTD() {
        //given
        String[] cards = {"4H", "8H","8D","9C","TD"};
        //when
        String result = generator.generateResult(cards, CardType.PAIR);

        //then
        assertEquals("Pair of 8", result);
    }

    @Test
    void should_return_two_pairs_5_and_8_when_generateResult_given_5H5D8H8D9C() {
        //given
        String[] cards = {"5H","5D","8H","8D","9C"};
        //when
        String result = generator.generateResult(cards, CardType.TWO_PAIRS);

        //then
        assertEquals("two pairs 8 and 5", result);
    }

    @Test
    void should_return_three_of_a_kind_8_when_generateResult_given_8H8D8H9DTC() {
        //given
        String[] cards = {"8H","8D","8H","9D","TC"};
        //when
        String result = generator.generateResult(cards, CardType.THREE_OF_A_KIND);

        //then
        assertEquals("three of a kind: 8", result);
    }

    @Test
    void should_return_straight_8_when_generateResult_given_4H5D6H7D8D() {
        //given
        String[] cards = {"4H","5D","6H","7D","8D"};
        //when
        String result = generator.generateResult(cards, CardType.STRAIGHT);

        //then
        assertEquals("straight: 8", result);
    }

    @Test
    void should_return_flush_9_when_generateResult_given_2H4H5H8H9H() {
        //given
        String[] cards = {"2H","4H","5H","8H","9H"};
        //when
        String result = generator.generateResult(cards, CardType.FLUSH);

        //then
        assertEquals("flush: 9", result);
    }

    @Test
    void should_return_full_house_4_over_8_when_generateResult_given_4C4H4S8H8C() {
        //given
        String[] cards = {"4C","4H","4S","8H","8C"};
        //when
        String result = generator.generateResult(cards, CardType.FULL_HOUSE);

        //then
        assertEquals("full house: 4 over 8", result);
    }
}
