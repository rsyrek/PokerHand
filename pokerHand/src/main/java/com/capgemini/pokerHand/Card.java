package com.capgemini.pokerHand;

public class Card {
	private final int rank;
	private final int suit;

	// Kinds of suits
	public final static int D = 1;
	public final static int C = 2;
	public final static int H = 3;
	public final static int S = 4;

	// Kinds of ranks
	public final static int T = 10;
	public final static int J = 11;
	public final static int Q = 12;
	public final static int K = 13;
	public final static int A = 14;

	public Card(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}