package com.hardik.tictactoe;

public class TicTacToeGame {
	/*
	 * Main Method
	 */
	public static void main(String args[]) {

		System.out.println("Welcome to Tic Tac toe game!!");
		// Determine the turn by doing Toss
		TicTacToeService.toss();
		// creating a board
		TicTacToeService.createBoard();
		System.out.println("Start the game!!");
		TicTacToeService.startGame();
		// Displaying Board
		TicTacToeService.showBoard();
		// checking the index is free or not and valid and making the move
		

	}
}
