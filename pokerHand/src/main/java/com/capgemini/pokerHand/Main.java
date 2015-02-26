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
		Card card = null;
		int counter = 0;
		System.err.println("Start");
		for(int j = 0; j < 1000; j++){
			cards1.clear();
			cards2.clear();
			for(int i = 0; i < 5; i++){
				try {
					card = new Card(readRank((char)file.read(), j), readSuit((char)file.read()));
					file.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				cards1.add(card);
			}
			for(int i = 0; i < 5; i++){
				try {
					card = new Card(readRank((char)file.read(), j), readSuit((char)file.read()));
					file.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				cards2.add(card);
			}
			p1 = new Player(cards1);
			p2 = new Player(cards2);
			if(p1.isWinner(p2)) counter++;
		}
		System.out.println("Wynik: " + counter);
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
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
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
			return (int) c;
		}
	}

}
