package com.capgemini.pokerHand;

import java.util.ArrayList;
import java.util.List;

public class Player {
	/*private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	private Card card5;*/
	private List<Card> cards;
	private List<Hand> hands;
	private List<Integer> rankValues;

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
		hands = new ArrayList<Hand>();
		rankValues = new ArrayList<Integer>();
		setHand();
	}
	
	public boolean isWinner(Player otherPlayer) {
		int index = 0, index2 = 0;
		for (Hand h : this.hands){
			if (h.isGreater(otherPlayer.hands.get(index))) {
				return true;
			}
			else if(otherPlayer.hands.get(index).isGreater(h)){
				return false;
			}
			else {
				
				if(h == Hand.TWO_PAIRS || h == Hand.FULL){
					if(this.rankValues.get(index2) > otherPlayer.rankValues.get(index2)){
						return true;
					}
					else if(this.rankValues.get(index2) < otherPlayer.rankValues.get(index2)){
						return false;
					}
					index2++;
				}
				if(this.rankValues.get(index2) > otherPlayer.rankValues.get(index2)){
					return true;
				}
				else if(this.rankValues.get(index2) < otherPlayer.rankValues.get(index2)){
					return false;
				}
				else {
					index++;
					index2++;
				}
			}
		}
		System.err.println("Remis!");
		return false;
	}
	
	private void setHand(){
		int index = 0;
		boolean stillHaveSomething = true;
		cards.sort(new CardComparator());
		while(stillHaveSomething){
			if (cards.size() == 5)
				isThereRoyalFlush();
			if (cards.size() == 5)
				isThereStraightFlush();
			if (cards.size() >= 4)
				isThere4();
			if (cards.size() == 5)
				isThereFull();
			if (cards.size() == 5)
				isThereFlush();
			if (cards.size() == 5)
				isThereStraight();
			if (cards.size() >= 3)
				isThere3();
			if (cards.size() >= 4)
				isThere2Pairs();
			if (cards.size() >= 2)
				isTherePair();
			if (!cards.isEmpty())
			stillHaveSomething = isThereHighCard(index);
			if (cards.isEmpty()) break;
		}
	}

	private boolean isThereHighCard(int index) {
		if(!cards.isEmpty()){
			hands.add(Hand.HIGH_CARD);
			rankValues.add(cards.get(cards.size() - 1).getRank());
			cards.remove(cards.size() - 1);
			return true;
		}
		else return false;
	}

	private void isTherePair() {
		for(int i = 0; i < cards.size() - 1; i++){
			if(cards.get(i).getRank() == cards.get(i + 1).getRank()){
				hands.add(Hand.ONE_PAIR);
				rankValues.add(cards.get(i).getRank());
				cards.remove(i + 1);
				cards.remove(i);
				break;
			}
		}
	}

	private void isThere2Pairs() {
		boolean flag = false;
		int index1 = -1;
		int index2 = -1;
		for(int i = 0; i < cards.size() - 3; i++){
			if(cards.get(i).getRank() == cards.get(i + 1).getRank()){
				index1 = i;
				for(int j = i + 2; j < cards.size() - 1; j++){
					if(cards.get(j).getRank() == cards.get(j + 1).getRank()){
						index2 = j;
						flag = true;
						break;
					}
				}
				break;
			}
		}
		if(flag){
			hands.add(Hand.TWO_PAIRS);
			rankValues.add(Math.max(cards.get(index1).getRank(), cards.get(index2).getRank()));
			rankValues.add(Math.min(cards.get(index1).getRank(), cards.get(index2).getRank()));
			cards.remove(index2 + 1);
			cards.remove(index2);
			cards.remove(index1 + 1);
			cards.remove(index1);
		}
	}

	private void isThere3() {
		for(int i = 0; i < cards.size() - 2 ; i++){
			if(cards.get(i).getRank() == cards.get(i + 1).getRank() && 
					cards.get(i + 1).getRank() == cards.get(i + 2).getRank()){
				hands.add(Hand.THREE);
				rankValues.add(cards.get(i).getRank());
				cards.remove(i + 2);
				cards.remove(i + 1);
				cards.remove(i);
				break;
			}
		}
	}

	private void isThereStraight() {
		if (cards.get(0).getRank() + 1 == cards.get(1).getRank() &&
				cards.get(1).getRank() + 1 == cards.get(2).getRank() &&
						cards.get(2).getRank() + 1 == cards.get(3).getRank() &&
								cards.get(3).getRank() + 1 == cards.get(4).getRank()){
			hands.add(Hand.THREE);
			rankValues.add(cards.get(cards.size() - 1).getRank());
			cards.clear();
		}
	}

	private void isThereFlush() {
		boolean flag = true;
		for(Card c : cards){
			if (c.getSuit() != cards.get(0).getSuit()){
				flag = false;
			}
		}
		if (flag){
			hands.add(Hand.FLUSH);
			rankValues.add(cards.get(cards.size() - 1).getRank());
			cards.clear();
		}
	}

	private void isThereFull() {
		int index1 = -1, index2 = -1;
		boolean flag1 = false, flag2 = false;
		for(int i = 0; i < cards.size() - 2; i++){
			if(cards.get(i).getRank() == cards.get(i + 1).getRank() && 
					cards.get(i + 1).getRank() == cards.get(i + 2).getRank()){
				index1 = i;		
				break;
			}
		}
		for(int i = 0; i < cards.size() - 1; i++){
			if(i != index1 && i != index1 + 1 && i != index1 + 2)
			if(cards.get(i).getRank() == cards.get(i + 1).getRank()){
				index2 = i;
				break;
			}
		}
		if (flag1 && flag2){
			rankValues.add(cards.get(index1).getRank());
			rankValues.add(cards.get(index2).getRank());
			if(index2 > index1){
				cards.remove(index2 + 1);
				cards.remove(index2);
				cards.remove(index1 + 2);
				cards.remove(index1 + 1);
				cards.remove(index1);
			}
			else{
				cards.remove(index1 + 2);
				cards.remove(index1 + 1);
				cards.remove(index1);
				cards.remove(index2 + 1);
				cards.remove(index2);
			}
		}
	}

	private void isThere4() {
		for(int i = 0; i < cards.size() - 3; i++){
			if(cards.get(i).getRank() == cards.get(i + 1).getRank() && 
					cards.get(i + 1).getRank() == cards.get(i + 2).getRank() && 
							cards.get(i + 2).getRank() == cards.get(i + 3).getRank()){
				hands.add(Hand.FOUR);
				rankValues.add(cards.get(i).getRank());
				cards.remove(i + 3);
				cards.remove(i + 2);
				cards.remove(i + 1);
				cards.remove(i);
				break;
			}
		}
	}

	private void isThereStraightFlush() {
		boolean flag = false;
		if (cards.get(0).getRank() + 1 == cards.get(1).getRank() &&
				cards.get(1).getRank() + 1 == cards.get(2).getRank() &&
						cards.get(2).getRank() + 1 == cards.get(3).getRank() &&
								cards.get(3).getRank() + 1 == cards.get(4).getRank()){
			flag = true;
			for(Card c : cards){
				if (c.getSuit() != cards.get(0).getSuit()){
					flag = false;
				}
			}
			if (flag){
				hands.add(Hand.STRAIGHT_FLUSH);
				rankValues.add(cards.get(cards.size() - 1).getRank());
				cards.clear();
			}
		}
		
	}

	private void isThereRoyalFlush() {
		boolean flag = false;
		if(cards.get(0).getRank() == Card.T){
			if (cards.get(0).getRank() +1 == cards.get(1).getRank() &&
					cards.get(1).getRank() + 1 == cards.get(2).getRank() &&
							cards.get(2).getRank() + 1 == cards.get(3).getRank() &&
									cards.get(3).getRank() + 1 == cards.get(4).getRank()){
				flag = true;
				for(Card c : cards){
					if (c.getSuit() != cards.get(0).getSuit()){
						flag = false;
					}
				}
			}
		}
		if (flag){
			hands.add(Hand.ROYAL_FLUSH);
			rankValues.add(cards.get(cards.size() - 1).getRank());
			cards.clear();
		}
	}
}