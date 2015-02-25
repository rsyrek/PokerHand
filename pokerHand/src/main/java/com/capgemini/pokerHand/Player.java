package com.capgemini.pokerHand;

import java.util.List;

public class Player {
	/*private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	private Card card5;*/
	private List<Card> cards;
	private List<Hand> hands;
	private int[] rankValues;

	/*public Player(Card card1, Card card2, Card card3, Card card4, Card card5) {
		this.card1 = card1;
		this.card2 = card2;
		this.card3 = card3;
		this.card4 = card4;
		this.card5 = card5;
		setHand();
	}*/

	public Player(List<Card> cards){
		this.cards = cards;
		setHand();
	}
	
	public boolean isWinner(Player otherPlayer) {
		int index = 0;
		for (Hand h : this.hands){
			if (h.isGreater(otherPlayer.hands.get(index))) {
				return true;
			}
			else if(otherPlayer.hands.get(index).isGreater(h)){
				return false;
			}
			else {
				if(this.rankValues[index] > otherPlayer.rankValues[index]){
					return true;
				}
				else if(this.rankValues[index] < otherPlayer.rankValues[index]){
					return false;
				}
				else index++;
			}
		}
		System.err.println("Remis!");
		return false;
	}
	
	private void setHand(){
		boolean stillHaveSomething = true;
		cards.sort(new CardComparator());
		while(stillHaveSomething){
			
		}
	}
}