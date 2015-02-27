package com.capgemini.pokerHand;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		InputStream file = null;
		try {
			file = new FileInputStream("C:/Users/rsyrek/Documents/GitHub/PokerHand/pokerHand/p054_poker.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		List<Card> cards1 = new ArrayList<Card>();
		List<Card> cards2 = new ArrayList<Card>();
		Player p1;
		Player p2;
		Referee ref;
		Card card = null;
		int counter = 0;
		System.err.println("Start");
		for(int j = 0; j < 1000; j++){
			cards1.clear();
			cards2.clear();
			for(int i = 0; i < 5; i++){
				cards1.add(cardReader(file, card, j));
			}
			for(int i = 0; i < 5; i++){
				cards2.add(cardReader(file, card, j));
			}
			p1 = new Player(cards1);
			p2 = new Player(cards2);
			ref = new Referee(p1, p2);
			if(ref.isFirstPlayerWinner()) counter++;
		}
		System.out.println("Wynik: " + counter);
	}

	public static Card cardReader(InputStream file, Card card, int j) {
		try {
			card = new Card(readRank((char)file.read(), j), readSuit((char)file.read()));
			file.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return card;
	}

	private static int readSuit(char c) {
		switch(c){
		case 'D':
			return Card.D;
		case 'C':
			return Card.C;
		case 'H':
			return Card.H;
		case 'S':
			return Card.S;
		default:
			return 0;
		}
	}

	private static int readRank(char c, int j) {
		switch(c){
		case 'T':
			return Card.T;
		case 'J':
			return Card.J;
		case 'Q':
			return Card.Q;
		case 'K':
			return Card.K;
		case 'A':
			return Card.A;
		default:
			return Integer.parseInt("" + c);
		}
	}
}