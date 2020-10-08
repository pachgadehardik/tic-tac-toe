package com.hardik.tictactoe;

import java.util.Scanner;


public class TicTacToeGame {

	static char player1Input;
	static char player2Input;

	// Creates a Board
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static void displayBoard(char[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " ");
		}
	}

	// Input the Character
	public static void printLettersAssigned() {
		System.out.println("PLayer 1 is : " + player1Input);
		System.out.println("Computer is : " + player2Input);

	}

	// Determine Player's option
	public static void determinePlayerOption() {

		System.out.println("Enter the Input: ");
		Scanner scanner = new Scanner(System.in);
		player1Input = scanner.next().charAt(0);

		player2Input = player1Input == 'X' ? 'O' : 'X';
		printLettersAssigned();
		scanner.close();
	}

	public static void main(String args[]) {
		System.out.println("Welcome to Tic Tac toe game!!");
		// creating a board
		displayBoard(createBoard());
		player1Input = 'X';
		player2Input = 'O';
		determinePlayerOption();

	}
}
