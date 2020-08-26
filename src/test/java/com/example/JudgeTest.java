package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.example.CardType.*;
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

    @Test
    void should_return_four_of_a_kind_when_judge_type_given_3H3S3C3D7H() {
        //given
        String cardS = "3D 7H 3H 3S 3C";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(Four_OF_A_KIND, cardType);
    }

    @Test
    void should_return_full_house_when_judge_type_given_3H3S3C7D7H() {
        //given
        String cardS = "3H 3S 3C 7D 7H";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(FULL_HOUSE, cardType);
    }

    @Test
    void should_return_flush_when_judge_type_given_3H4H5H7H9H() {
        //given
        String cardS = "3H 4H 5H 7H 9H";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(FLUSH, cardType);
    }
}
