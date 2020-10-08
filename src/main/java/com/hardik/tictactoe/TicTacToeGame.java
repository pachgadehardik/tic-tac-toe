package com.hardik.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	static char player1Input;
	static char player2Input;
	static char board[];

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
	public static void determinePlayerOption() {
		System.out.println("Enter the Player 1 Letter: ");
		Scanner scanner = new Scanner(System.in);
		player1Input = scanner.next().charAt(0);
		player2Input = player1Input == 'X' ? 'O' : 'X';
		printLettersAssigned();
	}

	/**
	 * to check and validate the given index
	 */
	public static int checkIndex(int index) {
		if (index < 10 && index > 0) {
			if (board[index] == ' ') {
				System.out.println("Given Position is Empty");
				return index;
			}
			System.out.println("Given Position is not Empty");
		}
		System.out.println("Given Position is not Valid");
		return -1;

	}

	/*
	 * Main Method
	 */
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac toe game!!");
		// Determine Player Letter
		determinePlayerOption();
		// creating a board
		createBoard();
		// Displaying Board
		showBoard();
		// checking the index is free or not and valid
		int index = scanner.nextInt();
		int validIndex = checkIndex(index);
		if (validIndex != -1)
			System.out.println("Index :" + validIndex + " is Valid");
		scanner.close();

	}
}
