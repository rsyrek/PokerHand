package com.capgemini.pokerHand;

public class Referee {
	private Player playerFirst;
	private Player playerSecond;
	
	public Referee(Player first, Player second){
		playerFirst = first;
		playerSecond = second;
	}
	
	public boolean isFirstPlayerWinner() {
		int indexForHand = 0, indexForRank = 0;
		for (Hand h : playerFirst.getHands()){
			if (h.isGreater(playerSecond.getHands().get(indexForHand))) {
				return true;
			}
			else if(playerSecond.getHands().get(indexForHand).isGreater(h)){
				return false;
			}
			else {
				
				if(whenSecondHandIsImportant(h)){
					if(firstPlayerHasGreaterSameHand(playerFirst, playerSecond, indexForRank)){
						return true;
					}
					else if(secondPlayerHasGreaterSameHand(playerFirst, playerSecond, indexForRank)){
						return false;
					}
					indexForRank++;
				}
				if(firstPlayerHasGreaterSameHand(playerFirst, playerSecond, indexForRank)){
					return true;
				}
				else if(secondPlayerHasGreaterSameHand(playerFirst, playerSecond, indexForRank)){
					return false;
				}
				else {
					indexForHand++;
					indexForRank++;
				}
			}
		}
		System.err.println("Remis!" + playerFirst.getHands().toString() + playerFirst.getRankValues().toString());
		System.err.println(playerSecond.getHands().toString() + playerSecond.getRankValues().toString());
		return false;
	}

	public boolean secondPlayerHasGreaterSameHand(Player first, Player second, int index2) {
		return first.getRankValues().get(index2) < second.getRankValues().get(index2);
	}

	public boolean firstPlayerHasGreaterSameHand(Player first, Player second, int index2) {
		return first.getRankValues().get(index2) > second.getRankValues().get(index2);
	}

	public boolean whenSecondHandIsImportant(Hand hand) {
		return hand == Hand.TWO_PAIRS || hand == Hand.FULL;
	}
	
	
}
