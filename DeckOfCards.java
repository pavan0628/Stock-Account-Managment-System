package com.bl.opps3;

import java.util.Random;


public class DeckOfCards {
    static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
                             "Jack", "Queen", "King", "Ace"};
    static int[] rankValues = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    static Card[] deck = new Card[52];

    public static void main(String[] args) {
        initializeDeck();
        shuffleDeck();

        PlayerQueue playerQueue = new PlayerQueue();
        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new Player("Player " + (i + 1));
            playerQueue.enqueue(players[i]);
        }

        // Distribute 9 cards to each player
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (Player player : players) {
                player.addCard(deck[index++]);
            }
        }

        // Print players and their sorted cards
        playerQueue.printPlayers();
    }

    static void initializeDeck() {
        int index = 0;
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                deck[index++] = new Card(ranks[j], suits[i], rankValues[j]);
            }
        }
    }

    static void shuffleDeck() {
        Random rand = new Random();
        for (int i = 0; i < deck.length; i++) {
            int r = i + rand.nextInt(deck.length - i);
            Card temp = deck[i];
            deck[i] = deck[r];
            deck[r] = temp;
        }
    }
}


