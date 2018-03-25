package com.example.android.common.chess;

public abstract class Movement {

	public static void up(Board board, Colour turn, int x, int y) {
		int a = x + 1;
		int b = y;
		boolean checkDone = false;

		while (!checkDone) {
			checkDone=board.getBoard()[a][b].fieldCheck(turn);
			a++;
		}
	}

	public static void down(Board board, Colour turn, int x, int y) {
		int a = x - 1;
		int b = y;
		boolean checkDone = false;

		while (!checkDone) {
			checkDone=board.getBoard()[a][b].fieldCheck(turn);
			a--;
		}
	}
	
	public static void left(Board board, Colour turn, int x, int y) {
		int a = x;
		int b = y - 1;
		boolean checkDone = false;

		while (!checkDone) {
			checkDone=board.getBoard()[a][b].fieldCheck(turn);
			b--;
		}
	}
	
	public static void right(Board board, Colour turn, int x, int y) {
		int a = x;
		int b = y + 1;
		boolean checkDone = false;

		while (!checkDone) {
			checkDone=board.getBoard()[a][b].fieldCheck(turn);
			b++;
		}
	}
	
	public static void upRight(Board board, Colour turn, int x, int y) {
		int a = x + 1;
		int b = y + 1;
		boolean checkDone = false;

		while (!checkDone) {
			checkDone=board.getBoard()[a][b].fieldCheck(turn);
			a++;
			b++;
		}
	}
	
	public static void downRight(Board board, Colour turn, int x, int y) {
		int a = x - 1;
		int b = y + 1;
		boolean checkDone = false;

		while (!checkDone) {
			checkDone=board.getBoard()[a][b].fieldCheck(turn);
			a--;
			b++;
		}
	}
	
	public static void upLeft(Board board, Colour turn, int x, int y) {
		int a = x + 1;
		int b = y - 1;
		boolean checkDone = false;

		while (!checkDone) {
			checkDone=board.getBoard()[a][b].fieldCheck(turn);
			a++;
			b--;
		}
	}
	
	public static void downLeft(Board board, Colour turn, int x, int y) {
		int a = x - 1;
		int b = y - 1;
		boolean checkDone = false;

		while (!checkDone) {
			checkDone=board.getBoard()[a][b].fieldCheck(turn);
			a++;
			b--;
		}
	}
	
	public static void kingMovement(Board board, Colour turn, int x, int y) {
		board.getBoard()[x+1][y].fieldCheck(turn);
		board.getBoard()[x-1][y].fieldCheck(turn);
		board.getBoard()[x][y+1].fieldCheck(turn);
		board.getBoard()[x][y-1].fieldCheck(turn);
		board.getBoard()[x+1][y+1].fieldCheck(turn);
		board.getBoard()[x+1][y-1].fieldCheck(turn);
		board.getBoard()[x-1][y+1].fieldCheck(turn);
		board.getBoard()[x-1][y-1].fieldCheck(turn);
	}
	
	public static void pawnMovement(Board board, Colour turn, int x, int y) {
		if(turn == Colour.White) {
			board.getBoard()[x+1][y].fieldCheck(turn);
			board.getBoard()[x+1][y+1].fieldCheck(turn);
			board.getBoard()[x+1][y-1].fieldCheck(turn);
			if(x==1) {
				board.getBoard()[x+2][y].fieldCheck(turn);
			}
		}
		else {
			board.getBoard()[x-1][y].fieldCheck(turn);
			board.getBoard()[x-1][y+1].fieldCheck(turn);
			board.getBoard()[x-1][y-1].fieldCheck(turn);
			if(x==6) {
				board.getBoard()[x-2][y].fieldCheck(turn);
			}
		}
	}
	
	public static void knightMovement(Board board, Colour turn, int x, int y) {
		board.getBoard()[x+2][y+1].fieldCheck(turn);
		board.getBoard()[x+2][y-1].fieldCheck(turn);
		board.getBoard()[x-2][y+1].fieldCheck(turn);
		board.getBoard()[x-2][y-1].fieldCheck(turn);
		board.getBoard()[x+1][y+2].fieldCheck(turn);
		board.getBoard()[x+1][y-2].fieldCheck(turn);
		board.getBoard()[x-1][y+2].fieldCheck(turn);
		board.getBoard()[x-1][y-2].fieldCheck(turn);
	}
	
}
