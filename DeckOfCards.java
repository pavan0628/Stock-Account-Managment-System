package com.bl.opps3;

import java.util.Random;

public class DeckOfCards {

    // Define suits and ranks
    static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", 
                             "Jack", "Queen", "King", "Ace"};

    // Create the deck of 52 cards
    static String[] deck = new String[52];

    public static void main(String[] args) {
        initializeDeck();
        shuffleDeck();
        String[][] players = distributeCards(4, 9); // 4 players, 9 cards each
        printPlayerCards(players);
    }

    // Initialize the deck with 52 cards
    static void initializeDeck() {
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }
    }

    // Shuffle the deck using Fisher-Yates shuffle
    static void shuffleDeck() {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            int r = i + random.nextInt(deck.length - i); // Random index from i to 51
            // Swap cards
            String temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }

    // Distribute cards to players using a 2D array
    static String[][] distributeCards(int numberOfPlayers, int cardsPerPlayer) {
        String[][] players = new String[numberOfPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[cardIndex++];
            }
        }
        return players;
    }

    // Print cards of each player
    static void printPlayerCards(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
            System.out.println();
        }
    }
}

