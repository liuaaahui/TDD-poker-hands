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
    void should_return_with_high_card_Ace_when_generateResult_given_9HTCAD4H7H() {
        //given
        String[] cards = {"4H", "7H","9H","TC","AD"};
        //when
        String result = generator.generateResult(cards, CardType.HIGH_CARD);

        //then
        assertEquals("high card: Ace", result);
    }
}
