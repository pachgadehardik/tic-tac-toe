package com.hardik.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	
	static final int HEAD=1; //for player 1
	static final int TAILS=0; //for computer
	
	static char player1Input;
	static char player2Input;
	static char board[];
	static char winner;
	static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Creates a Board
	 */
	public static char[] createBoard() {
		board = new char[10];
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	/**
	 * displays Board
	 */
	public static void showBoard() {
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----------");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----------");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	public static void printLettersAssigned() {
		System.out.println("PLayer 1 is : " + player1Input);
		System.out.println("Computer is : " + player2Input);

	}

	/**
	 * Determining Players Letter
	 */
	public static void determinePlayerOption(int result) {
		if (result == HEAD) {
			System.out.println("Enter the Player 1 Letter: ");
			player1Input = scanner.next().charAt(0);
			player2Input = player1Input == 'X' ? 'O' : 'X';
			winner = player1Input;
		} else {
			System.out.println("Enter the Computer Letter: ");
			player2Input = scanner.next().charAt(0);
			player1Input = player2Input == 'X' ? 'O' : 'X';
			winner = player2Input;
		}
		printLettersAssigned();
	}

	/**
	 * to check and validate the given index
	 */
	public static int checkIndex_MakeMove(char winner) {
		int index = scanner.nextInt();
		if (index < 10 && index > 0) {
			if (board[index] == ' ') {
				System.out.println("Given Position is Empty");
				board[index] = winner;
				checkWinner();
				showBoard();
				return index;
			}
			System.out.println("Given Position is not Empty");
		}
		System.out.println("Given Position is not Valid");
		return -1;

	}
	
	/**
	 * To determine 1st player
	 */
	public static void toss() {
		int result = (int) Math.round(Math.random());
		if (result == HEAD) {
			System.out.println("Player 1 wins the toss");
			// Determine Player Letter
			determinePlayerOption(HEAD);
		} else {
			System.out.println("Computer won the Toss");
			determinePlayerOption(TAILS);
		}
	}
	
	public static boolean checkWinner() {
		for (int winnerCase = 0; winnerCase < 8; winnerCase++) {
			String concatThreeValues = null;
			switch (winnerCase) {
			case 0:
				concatThreeValues += board[1] + board[2] + board[3];
				break;
			case 1:
				concatThreeValues += board[4] + board[5] + board[6];
				break;
			case 2:
				concatThreeValues += board[7] + board[8] + board[9];
				break;
			case 3:
				concatThreeValues += board[1] + board[4] + board[7];
				break;
			case 4:
				concatThreeValues += board[2] + board[5] + board[8];
				break;
			case 5:
				concatThreeValues += board[3] + board[6] + board[9];
				break;
			case 6:
				concatThreeValues += board[1] + board[5] + board[9];
				break;
			case 7:
				concatThreeValues += board[3] + board[5] + board[7];
				break;
			}
			if (concatThreeValues.equalsIgnoreCase("XXX")) {
				System.out.println("Player with X wins");
				return true;
			} else if (concatThreeValues.equalsIgnoreCase("OOO")) {
				System.out.println("Player with O wins");
				return true;
			} 
		}
		return false;
	}
	
	public static void startGame() {
		int count = 0;
		while(count++ < 9) {
			if(winner == player1Input) {
				checkIndex_MakeMove(player1Input);
				if(checkWinner() == true) break;
				showBoard();
				checkIndex_MakeMove(player2Input);
				if(checkWinner() ==true) break;
				showBoard();
			}
			else {
				checkIndex_MakeMove(player2Input);
				if(checkWinner() == true) break;
				showBoard();
				checkIndex_MakeMove(player1Input);
				if(checkWinner() ==true) break;
				showBoard();
			}
			
		}
	}
	
	/*
	 * Main Method
	 */
	public static void main(String args[]) {
		
		System.out.println("Welcome to Tic Tac toe game!!");
		
		//Determine the turn by doing Toss
		toss();
		// creating a board
		createBoard();
		
		System.out.println("Start the game!!");
		startGame();
		// Displaying Board
		showBoard();
		// checking the index is free or not and valid and making the move
		
//		checkIndex_MakeMove();
		showBoard();
		scanner.close();
		
	}
}
