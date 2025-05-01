package com.bl.opps3;

public class Card {
	String suit;
	String rank;
	int rankValue; // Used for sorting

	public Card(String rank, String suit, int rankValue) {
		this.rank = rank;
		this.suit = suit;
		this.rankValue = rankValue;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}
}

//creating cardNode class
class CardNode {
	Card card;
	CardNode next;

	public CardNode(Card card) {
		this.card = card;
		this.next = null;
	}
}

//creating cardQueue class
class CardQueue {
	CardNode front, rear;

	public void enqueue(Card card) {
		CardNode newNode = new CardNode(card);
		if (rear == null) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	public Card[] toArray() {
		int size = size();
		Card[] array = new Card[size];
		CardNode temp = front;
		int i = 0;
		while (temp != null) {
			array[i++] = temp.card;
			temp = temp.next;
		}
		return array;
	}

	public void sortByRank() {
		Card[] array = toArray();
		// Bubble sort based on rankValue
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j].rankValue > array[j + 1].rankValue) {
					Card temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

		// Rebuild queue with sorted cards
		front = rear = null;
		for (Card card : array) {
			enqueue(card);
		}
	}

	public void printQueue() {
		CardNode temp = front;
		while (temp != null) {
			System.out.println("  " + temp.card);
			temp = temp.next;
		}
	}

	public int size() {
		int count = 0;
		CardNode temp = front;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
}


