package hardik.tic_tac_toe.Services;

public class TicTacToeService {

	public char[] createBoard() {
		char[] board = new char[10];
		for(int i = 1;i<=board.length;i++) {
			board[i] = ' ';
		}
		return board;
	}
	public void displayBoard(char[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" ");
		}
	}
}
