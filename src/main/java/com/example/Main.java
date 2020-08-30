package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("white cards: ");
            String white = scanner.nextLine();
            System.out.println("black cards: ");
            String black = scanner.nextLine();
            PokerHands pokerHands = new PokerHands();
            System.out.println(pokerHands.play(white, black));
            System.out.println("If continue:(Y/N)");
        } while (!scanner.nextLine().equals("N"));
    }
}
