package com.hardik.tictactoe;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class TicTacToeService {

	static final int HEAD = 1; // for player 1
	static final int TAILS = 0; // for computer

	static char player1Input;
	static char player2Input;
	static char board[];
	static int corner_index[] = { 1, 3, 7, 9 };
	static int edge_index[] = { 2, 4, 6, 8 };

	static char winner;
	static Scanner scanner = new Scanner(System.in);

	/**
	 * Creates a Board
	 */
	public char[] createBoard() {
		board = new char[10];
		for (int i = 1; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	/**
	 * displays Board
	 */
	public void showBoard() {
		System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
		System.out.println("----------");
		System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
		System.out.println("----------");
		System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
	}

	public void printLettersAssigned() {
		System.out.println("PLayer 1 is : " + player1Input);
		System.out.println("Computer is : " + player2Input);

	}

	/**
	 * Determining Players Letter
	 */
	public void determinePlayerOption(int result) {
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
	public int checkIndex_MakeMove(char winner) {

		int index = scanner.nextInt();
		if (index < 10 && index > 0) {
			if (board[index] == ' ') {
				board[index] = winner;
				checkWinner();
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
	public void toss() {
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

	/**
	 * to check whether someone has Won
	 */
	public boolean checkWinner() {
		for (int winnerCase = 0; winnerCase < 8; winnerCase++) {
			String concatThreeValues = "";
			switch (winnerCase) {
			case 0:
				concatThreeValues = "" + board[1] + board[2] + board[3];
				break;
			case 1:
				concatThreeValues = "" + board[4] + board[5] + board[6];
				break;
			case 2:
				concatThreeValues = "" + board[7] + board[8] + board[9];
				break;
			case 3:
				concatThreeValues = "" + board[1] + board[4] + board[7];
				break;
			case 4:
				concatThreeValues = "" + board[2] + board[5] + board[8];
				break;
			case 5:
				concatThreeValues = "" + board[3] + board[6] + board[9];
				break;
			case 6:
				concatThreeValues = "" + board[1] + board[5] + board[9];
				break;
			case 7:
				concatThreeValues = "" + board[3] + board[5] + board[7];
				break;
			}
			if (concatThreeValues.equals("XXX")) {
				System.out.println("Player with X wins");
				return true;
			} else if (concatThreeValues.equals("OOO")) {
				System.out.println("Player with O wins");
				return true;
			}
		}
		return false;
	}


	private boolean checkForCorners_MoveNext() {
		OptionalInt corner = Arrays.stream(corner_index).filter(e -> board[e] == ' ').findFirst();
		if (corner.isPresent()) {
			board[corner.getAsInt()] = player2Input;
			return true;
		} else
			return false;
	}

	private boolean checkForCenter_MoveNext() {
		if (board[5] == ' ') {
			board[5] = player2Input;
			return true;
		}
		return false;

	}

	private boolean checkForAvailableEdges_MoveNext() {
		OptionalInt edge = Arrays.stream(edge_index).filter(e -> board[e] == ' ').findFirst();
		if (edge.isPresent()) {
			board[edge.getAsInt()] = player2Input;
			return true;
		}
		return false;
	}

	/**
	 * Function to automate Computers Logic
	 */
	public void playComputerWithHuman(char player2Input) {
		if (checkWhetherWinningToBlock(player2Input)) {
			return;
		}
		if(checkWhetherWinningToBlock(player1Input)) {
			return;
		}
		if (checkForCorners_MoveNext()) {
			return;
		}
		if (checkForCenter_MoveNext()) {
			return;
		}
		if (checkForAvailableEdges_MoveNext()) {
			return;
		}

	}

	public int checkCombination(String concatThreeValues, char winner) {
		if (concatThreeValues.equals(winner + " " + winner))
			return 2;
		if (concatThreeValues.equals(winner + winner + " "))
			return 3;
		if (concatThreeValues.equals(" " + winner + winner))
			return 1;


		return 0;
	}

	/**
	 * Checking Whether opponent is going to win
	 */
	private boolean checkWhetherWinningToBlock(char winner) {
		boolean actionPerformed = false;
		for (int winnerCase = 0; winnerCase < 8; winnerCase++) {
			String concatThreeValues = "";
			switch (winnerCase) {
			case 0:
				concatThreeValues = "" + board[1] + board[2] + board[3];
				System.out.println(concatThreeValues);
				int blockPlay = checkCombination(concatThreeValues, winner);
				if (blockPlay != 0) {
					board[blockPlay] = winner;
					actionPerformed = true;
				}
				break;
			case 1:
				concatThreeValues = "" + board[4] + board[5] + board[6];
				int blockPlay1 = checkCombination(concatThreeValues, winner);
				if (blockPlay1 != 0) {
					board[3 + blockPlay1] = winner;
					actionPerformed = true;
				}
				break;
			case 2:
				concatThreeValues = "" + board[7] + board[8] + board[9];
				int blockPlay2 = checkCombination(concatThreeValues, winner);
				if (blockPlay2 != 0) {
					board[6 + blockPlay2] = winner;
					actionPerformed = true;
				}
				break;
			case 3:
				concatThreeValues = "" + board[1] + board[4] + board[7];
				int blockPlay3 = checkCombination(concatThreeValues, winner);
				if (blockPlay3 == 1) {
					board[1] = winner;
					actionPerformed = true;
				}
				if (blockPlay3 == 2) {
					board[4] = winner;
					actionPerformed = true;
				}
				if (blockPlay3 == 3) {
					board[7] = winner;
					actionPerformed = true;
				}

				break;
			case 4:
				concatThreeValues = "" + board[2] + board[5] + board[8] + "";
				int blockPlay4 = checkCombination(concatThreeValues, winner);
				if (blockPlay4 == 1) {
					board[2] = player2Input;
					actionPerformed = true;
				}
				if (blockPlay4 == 2) {
					board[5] = player2Input;
					actionPerformed = true;
				}
				if (blockPlay4 == 3) {
					board[8] = player2Input;
					actionPerformed = true;
				}
				break;
			case 5:
				concatThreeValues = "" + board[3] + board[6] + board[9];
				int blockPlay5 = checkCombination(concatThreeValues, winner);
				if (blockPlay5 == 1) {
					board[3] = player2Input;
					actionPerformed = true;
				}
				if (blockPlay5 == 2) {
					board[6] = player2Input;
					actionPerformed = true;
				}
				if (blockPlay5 == 3) {
					board[9] = player2Input;
					actionPerformed = true;
				}
				break;
			case 6:
				concatThreeValues = "" + board[1] + board[5] + board[9];
				int blockPlay6 = checkCombination(concatThreeValues, winner);
				if (blockPlay6 == 1) {
					board[1] = player2Input;
					actionPerformed = true;
				}
				if (blockPlay6 == 2) {
					board[5] = player2Input;
					actionPerformed = true;
				}
				if (blockPlay6 == 3) {
					board[9] = player2Input;
					actionPerformed = true;
				}
				break;
			case 7:
				concatThreeValues = "" + board[3] + board[5] + board[7];
				int blockPlay7 = checkCombination(concatThreeValues, winner);
				if (blockPlay7 == 1) {
					board[3] = player2Input;
					actionPerformed = true;
				}
				if (blockPlay7 == 2) {
					board[5] = player2Input;
					actionPerformed = true;
				}
				if (blockPlay7 == 3) {
					board[7] = player2Input;
					actionPerformed = true;
				}
				break;
			}

		}
		return actionPerformed;
	}

	/**
	 * Starting the Game
	 */
	public void startGame() {
		int count = 0;

		while (count < 9) {
			if (winner == player1Input) { // Player 1 has Won and will start first
				checkIndex_MakeMove(player1Input);
				if (checkWinner() == true)
					break;
				showBoard();
				playComputerWithHuman(player2Input);
				if (checkWinner() == true)
					break;
				showBoard();
			} else {
				// Computer has won and will start first
				playComputerWithHuman(player2Input);
				if (checkWinner() == true)
					break;
				showBoard();
				checkIndex_MakeMove(player1Input);
				if (checkWinner() == true)
					break;
				showBoard();
			}
			count++;
		}
	}
		
	
}
