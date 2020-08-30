package com.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokerHandsTest {
    private static PokerHands pokerHands;

    @BeforeAll
    public static void setUp() {
        pokerHands = new PokerHands();
    }

    @Test
    void should_return_white_wins_with_high_card_Ace_when_judge_face_given_9HTCAD4H7H_and_KHQC2D8C9S() {
        //given
        String white = "9H TC AD 4H 7H";
        String black = "KH QC 2D 8C 9S";

        //when
        String result = pokerHands.play(white, black);

        //then
        assertEquals("white wins. - with high card: Ace", result);
    }

    @Test
    void should_return_black_wins_with_high_card_Ace_when_judge_face_given_and_KHQC2D8C9S_9HTCAD4H7H() {
        //given
        String black = "9H TC AD 4H 7H";
        String white = "KH QC 2D 8C 9S";

        //when
        String result = pokerHands.play(white, black);

        //then
        assertEquals("black wins. - with high card: Ace", result);
    }

    @Test
    void should_return_tie_when_judge_face_given_and_KHQC2D8C9S_KSQd2S8D9H() {
        //given
        String black = "9H TC AD 4H 7H";
        String white = "KS Qd 2S 8D 9H";

        //when
        String result = pokerHands.play(white, black);

        //then
        assertEquals("tie", result);
    }
}
