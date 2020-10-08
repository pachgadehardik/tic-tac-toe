package hardik.tic_tac_toe;

import hardik.tic_tac_toe.Services.TicTacToeService;

public class TicTacToeGame {

	public static void main(String args[]) {
		System.out.println("Welcome to Tic Tac toe game!!");
		TicTacToeService service = new TicTacToeService();
		// creating a board
		service.displayBoard(service.createBoard());
	}
}
