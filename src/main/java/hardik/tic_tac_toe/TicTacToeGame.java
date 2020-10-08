package hardik.tic_tac_toe;

import java.util.Scanner;

import hardik.tic_tac_toe.Services.TicTacToeService;

public class TicTacToeGame {

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

	public static char inputTheLetter() {

		System.out.println("Enter the Input: ");
		Scanner inputOption = new Scanner(System.in);
		char input = inputOption.next().charAt(0);
		return input;
	}

	public static void determinePlayerOption(char input) {
		switch (input) {
		case 'X':
			System.out.println("Player 1 is having X");
			System.out.println("Computer is having O");
			break;
		case 'O':
			System.out.println("Player 1 is having O");
			System.out.println("Computer is having X");
			break;
		default:
			System.out.println("Invalid Input !!");
			break;
		}
	}

	public static void main(String args[]) {
		System.out.println("Welcome to Tic Tac toe game!!");
		// creating a board
		displayBoard(createBoard());
		char player1Input = inputTheLetter();
		determinePlayerOption(player1Input);

	}
}
