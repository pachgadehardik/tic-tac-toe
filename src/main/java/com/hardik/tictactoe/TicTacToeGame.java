package com.hardik.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	/*
	 * Main Method
	 */
	
	public static void display() {
		System.out.println("1-Continue");
		System.out.println("0-Exit");
		
	}
	
	public static void main(String args[]) {

		System.out.println("Welcome to Tic Tac toe game!!");
		int playerPref = 1;
		Scanner sc = new Scanner(System.in);
		while(playerPref!=0) {
			TicTacToeService newService = new TicTacToeService();
			// Determine the turn by doing Toss
			newService.toss();
			// creating a board
			newService.createBoard();
			System.out.println("Start the game!!");
			newService.startGame();
			// Displaying Board
			newService.showBoard();
			display();
			playerPref =sc.nextInt();
		}
		sc.close();
		
	}
}
