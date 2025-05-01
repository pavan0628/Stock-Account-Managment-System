package com.bl.opps3;

public class Player {
    String name;
    CardQueue cardQueue;

    public Player(String name) {
        this.name = name;
        this.cardQueue = new CardQueue();
    }

    public void addCard(Card card) {
        cardQueue.enqueue(card);
    }

    public void sortCards() {
        cardQueue.sortByRank();
    }

    public void showCards() {
        System.out.println(name + "'s Cards:");
        cardQueue.printQueue();
    }
}

//creating PlayerNode class
class PlayerNode {
    Player player;
    PlayerNode next;

    public PlayerNode(Player player) {
        this.player = player;
        this.next = null;
    }
}

//creating Player queue class
class PlayerQueue {
    PlayerNode front, rear;

    public void enqueue(Player player) {
        PlayerNode newNode = new PlayerNode(player);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void printPlayers() {
        PlayerNode temp = front;
        while (temp != null) {
            temp.player.sortCards();
            temp.player.showCards();
            System.out.println();
            temp = temp.next;
        }
    }
}

