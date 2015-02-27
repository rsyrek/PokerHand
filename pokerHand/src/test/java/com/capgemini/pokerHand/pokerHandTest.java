package com.capgemini.pokerHand;
import java.util.ArrayList;
import java.util.List;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class pokerHandTest {
	List<Card> cards1 = new ArrayList<Card>();
	List<Card> cards2 = new ArrayList<Card>();
	Referee ref;
	Player p1;
	Player p2;
	
	@Test
	public void shouldReturnFalseWhenHand1FromProjectEuler() {
		Card c1 = new Card(5, Card.H);
		Card c2 = new Card(5, Card.C);
		Card c3 = new Card(6, Card.S);
		Card c4 = new Card(7, Card.S);
		Card c5 = new Card(Card.K, Card.D);	
		cards1.add(c1);
		cards1.add(c2);
		cards1.add(c3);
		cards1.add(c4);
		cards1.add(c5);
		p1 = new Player(cards1);
		Card c6 = new Card(2, Card.C);
		Card c7 = new Card(3, Card.S);
		Card c8 = new Card(8, Card.S);
		Card c9 = new Card(8, Card.D);
		Card c10 = new Card(Card.T, Card.D);
		cards2.add(c6);
		cards2.add(c7);
		cards2.add(c8);
		cards2.add(c9);
		cards2.add(c10);
		p2 = new Player(cards2);
		ref = new Referee(p1, p2);
		Assertions.assertThat(ref.isFirstPlayerWinner()).isEqualTo(false);
	}

	@Test
	public void shouldReturnTrueWhenHand2FromProjectEuler() {
		Card c1 = new Card(5, Card.D);
		Card c2 = new Card(8, Card.C);
		Card c3 = new Card(9, Card.S);
		Card c4 = new Card(Card.J, Card.S);
		Card c5 = new Card(Card.A, Card.C);
		cards1.add(c1);
		cards1.add(c2);
		cards1.add(c3);
		cards1.add(c4);
		cards1.add(c5);
		p1 = new Player(cards1);
		Card c6 = new Card(2, Card.C);
		Card c7 = new Card(5, Card.C);
		Card c8 = new Card(7, Card.D);
		Card c9 = new Card(8, Card.S);
		Card c10 = new Card(Card.Q, Card.H);
		cards2.add(c6);
		cards2.add(c7);
		cards2.add(c8);
		cards2.add(c9);
		cards2.add(c10);
		p2 = new Player(cards2);
		ref = new Referee(p1, p2);
		Assertions.assertThat(ref.isFirstPlayerWinner()).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnFalseWhenHand3FromProjectEuler() {
		Card c1 = new Card(2, Card.D);
		Card c2 = new Card(9, Card.C);
		Card c3 = new Card(Card.A, Card.S);
		Card c4 = new Card(Card.A, Card.H);
		Card c5 = new Card(Card.A, Card.C);
		cards1.add(c1);
		cards1.add(c2);
		cards1.add(c3);
		cards1.add(c4);
		cards1.add(c5);
		p1 = new Player(cards1);
		Card c6 = new Card(3, Card.D);
		Card c7 = new Card(6, Card.D);
		Card c8 = new Card(7, Card.D);
		Card c9 = new Card(Card.T, Card.D);
		Card c10 = new Card(Card.Q, Card.D);
		cards2.add(c6);
		cards2.add(c7);
		cards2.add(c8);
		cards2.add(c9);
		cards2.add(c10);
		p2 = new Player(cards2);
		ref = new Referee(p1, p2);
		Assertions.assertThat(ref.isFirstPlayerWinner()).isEqualTo(false);
	}

	@Test
	public void shouldReturnTrueWhenHand4FromProjectEuler() {
		Card c1 = new Card(4, Card.D);
		Card c2 = new Card(6, Card.S);
		Card c3 = new Card(9, Card.H);
		Card c4 = new Card(Card.Q, Card.H);
		Card c5 = new Card(Card.Q, Card.C);
		cards1.add(c1);
		cards1.add(c2);
		cards1.add(c3);
		cards1.add(c4);
		cards1.add(c5);
		p1 = new Player(cards1);
		Card c6 = new Card(3, Card.D);
		Card c7 = new Card(6, Card.D);
		Card c8 = new Card(7, Card.H);
		Card c9 = new Card(Card.Q, Card.D);
		Card c10 = new Card(Card.Q, Card.S);
		cards2.add(c6);
		cards2.add(c7);
		cards2.add(c8);
		cards2.add(c9);
		cards2.add(c10);
		p2 = new Player(cards2);
		ref = new Referee(p1, p2);
		Assertions.assertThat(ref.isFirstPlayerWinner()).isEqualTo(true);
	}
	
	@Test
	public void shouldReturnTrueWhenHand5FromProjectEuler() {
		Card c1 = new Card(2, Card.H);
		Card c2 = new Card(2, Card.D);
		Card c3 = new Card(4, Card.C);
		Card c4 = new Card(4, Card.D);
		Card c5 = new Card(4, Card.S);
		cards1.add(c1);
		cards1.add(c2);
		cards1.add(c3);
		cards1.add(c4);
		cards1.add(c5);
		p1 = new Player(cards1);
		Card c6 = new Card(3, Card.C);
		Card c7 = new Card(3, Card.D);
		Card c8 = new Card(3, Card.S);
		Card c9 = new Card(9, Card.S);
		Card c10 = new Card(9, Card.D);
		cards2.add(c6);
		cards2.add(c7);
		cards2.add(c8);
		cards2.add(c9);
		cards2.add(c10);
		p2 = new Player(cards2);
		ref = new Referee(p1, p2);
		Assertions.assertThat(ref.isFirstPlayerWinner()).isEqualTo(true);
	}
}
