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
}
