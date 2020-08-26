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
        String cardS = "3D JH 3H 3S 3C";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(Four_OF_A_KIND, cardType);
    }

    @Test
    void should_return_full_house_when_judge_type_given_3H3S3C7D7H() {
        //given
        String cardS = "3H 3S 3C KD KH";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(FULL_HOUSE, cardType);
    }

    @Test
    void should_return_flush_when_judge_type_given_3H4H5H7H9H() {
        //given
        String cardS = "3H 4H 5H QH 9H";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(FLUSH, cardType);
    }

    @Test
    void should_return_straight_when_judge_type_given_3H4D5H6H7H() {
        //given
        String cardS = "3H 4D 5H 6H 7H";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(STRAIGHT, cardType);
    }

    @Test
    void should_return_three_of_a_kind_when_judge_type_given_3H4D5H6H7H() {
        //given
        String cardS = "3H 3D 3S AH 7H";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(THREE_OF_A_KIND, cardType);
    }

    @Test
    void should_return_two_pairs_when_judge_type_given_3H3D5S9C5D() {
        //given
        String cardS = "3H 3D 5S AC 5D";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(TWO_PAIRS, cardType);
    }

    @Test
    void should_return_pair_when_judge_type_given_3H3D5S9CKD() {
        //given
        String cardS = "3H 3D 5S 9C KD";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(PAIR, cardType);
    }

    @Test
    void should_return_high_card_when_judge_type_given_3H4D5S9CKD() {
        //given
        String cardS = "3H 4D 5S 9C KD";

        //when
        CardType cardType = judge.judgeType(cardS);

        //then
        assertEquals(HIGH_CARD, cardType);
    }

    @Test
    void should_return_0_when_judge_face_given_2H3D5S9CKD_and_2D3H5C9SKH() {
        //given
        String white = "2H 3D 5S 9C KD";
        String black = "2D 3H 5C 9S KH";

        //when
        int result = judge.judgeFaceWithSameType(white, black, HIGH_CARD);

        //then
        assertEquals(0, result);
    }

    @Test
    void should_return_1_when_judge_face_given_ADKDQDJDTD_and_ASKSQSJSTS() {
        //given
        String white = "AD KD QD JD TD";
        String black = "9S KS QS JS TS";

        //when
        int result = judge.judgeFaceWithSameType(white, black, STRAIGHT_FLUSH);

        //then
        assertEquals(1, result);
    }

    @Test
    void should_return_1_when_judge_face_given_9C9D9H9STD_and_4C4D4H4SAS() {
        //given
        String white = "9C 9D 9H 9S TD";
        String black = "4C 4D 4H 4S AS";

        //when
        int result = judge.judgeFaceWithSameType(white, black, Four_OF_A_KIND);

        //then
        assertEquals(1, result);
    }

    @Test
    void should_return_1_when_judge_face_given_9C9D9HTSTD_and_4C4D4HQSQS() {
        //given
        String white = "9C 9D 9H TS TD";
        String black = "4C 4D 4H QS QS";

        //when
        int result = judge.judgeFaceWithSameType(white, black, FULL_HOUSE);

        //then
        assertEquals(1, result);
    }

    @Test
    void should_return_1_when_judge_face_given_TD8S9C6H7D_and_3H4D5H7H6D() {
        //given
        String white = "TD 8S 9C 6H 7D";
        String black = "3H 4D 5H 7H 6D";

        //when
        int result = judge.judgeFaceWithSameType(white, black, STRAIGHT);

        //then
        assertEquals(1, result);
    }

    @Test
    void should_return_1_when_judge_face_given_3H5H6H9HTH_and_4C6C7C8C9C() {
        //given
        String white = "3H 5H 6H 9H TH";
        String black = "4C 6C 7C 8C 9C";

        //when
        int result = judge.judgeFaceWithSameType(white, black, FLUSH);

        //then
        assertEquals(1, result);
    }

    @Test
    void should_return_1_when_judge_face_given_9H9C9D3H4H_and_4H4C4D8C9S() {
        //given
        String white = "9H 9C 9D 3H 4S";
        String black = "4H 4C 4D 8C 9S";

        //when
        int result = judge.judgeFaceWithSameType(white, black, THREE_OF_A_KIND);

        //then
        assertEquals(1, result);
    }
}
