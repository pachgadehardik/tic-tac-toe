package com.hardik.tictactoe;

import java.util.Scanner;


public class TicTacToeGame {

	static char player1Input;
	static char player2Input;
	static char board[];
	
	// Creates a Board
	public static char[] createBoard() {
		 board = new char[10];
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}
	
	//displays Board
	public static void showBoard() {
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----------");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----------");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	// Input the Character
	public static void printLettersAssigned() {
		System.out.println("PLayer 1 is : " + player1Input);
		System.out.println("Computer is : " + player2Input);

	}

	// Determine Player's option
	public static void determinePlayerOption() {

		System.out.println("Enter the Player 1 Letter: ");
		Scanner scanner = new Scanner(System.in);
		player1Input = scanner.next().charAt(0);

		player2Input = player1Input == 'X' ? 'O' : 'X';
		printLettersAssigned();
		scanner.close();
	}
	

	public static void main(String args[]) {
		System.out.println("Welcome to Tic Tac toe game!!");
		//Determine Player Letter
		determinePlayerOption();
		// creating a board 
		createBoard();
		//Displaying Board
		showBoard();
		

	}
}
