package com.capgemini.pokerHand;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Card> cards1 = new ArrayList<Card>();
		List<Card> cards2 = new ArrayList<Card>();
		Player p1 = null;
		Player p2 = null ;
		Referee ref = null;
		int counter = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(Main.class.getClassLoader().getResource("p054_poker.txt").getFile()))) {
			String line = br.readLine();
			
			System.err.println("Start");
			while(line !=null) {
				String[] cards = line.split(" ");
				for(int i = 0; i < 5; i++){
					cards1.add(cardReader(cards[i]));
				}
				for(int i = 5; i < 10; i++){
					cards2.add(cardReader(cards[i]));
				}
				p1 = new Player(cards1);
				p2 = new Player(cards2);
				ref = new Referee(p1, p2);
				if(ref.isFirstPlayerWinner()) {
					counter++;
				}
				line = br.readLine();
				
			}
			System.out.println("Wynik: " + counter);
		}
		
	}

	private static Card cardReader(String cardString) {
		return new Card(readRank(cardString.charAt(0)), readSuit(cardString.charAt(1)));
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

	private static int readRank(char c) {
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