package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.example.CardType.STRAIGHT_FLUSH;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JudgeTest {
    private static Judge judge;

    @BeforeAll
    public static void setUp() {
        judge = new Judge();
    }

    @Test
    void should_return_Straight_flush_when_judge_type_given_3H4H5H6H7H() {
        //given
        String cardS = "3H 4H 5H 6H 7H";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(STRAIGHT_FLUSH, cardType);
    }
}
