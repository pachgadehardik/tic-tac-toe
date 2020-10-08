package hardik.tic_tac_toe;

import java.awt.DisplayMode;
import java.util.Scanner;

import hardik.tic_tac_toe.Services.TicTacToeService;

public class TicTacToeGame {

	
	public static void displayMenu() {
		System.out.println("1-Create a Board!!");
		System.out.println("0-exit");
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Tic Tac toe game!!");
		boolean flag = true;
		while(flag) {
			displayMenu();
			System.out.println("Enter the Option:");
			int op = sc.nextInt();
			TicTacToeService service = new TicTacToeService();
			switch(op) {
			case 1:
				//creating a board
				service.displayBoard(service.createBoard());
			}
		}
		
	}
	
}
