package com.capgemini.pokerHand;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {
	
	public int compare(Card card1, Card card2) {
		return Integer.compare(card1.getRank(), card2.getRank());
	}
}