package com.capgemini.pokerHand;

import java.util.Arrays;
import java.util.List;

public enum Hand {
	HIGH_CARD, ONE_PAIR, TWO_PAIRS, THREE, STRAIGHT, FLUSH, FULL, FOUR, STRAIGHT_FLUSH, ROYAL_FLUSH;

	public boolean isGreater(Hand otherHand) {
		int score1;
		int score2;
		List<Hand> dependencies = Arrays.asList(Hand.values());
		score1 = dependencies.indexOf(this);
		score2 = dependencies.indexOf(otherHand);
		return score1 > score2;
	}
}