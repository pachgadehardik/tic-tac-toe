package hardik.tic_tac_toe.Services;

public class TicTacToeService {

	public Character[] createBoard() {
		
		Character arr[] = new Character[10];
		return arr;
	}
	
	
	public void displayBoard(Character[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+" ");
		}
	}
}
