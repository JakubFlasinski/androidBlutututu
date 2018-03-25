package com.example.android.common.chess;

public abstract class Movement {

	public static void up(Board board, Colour turn, int x, int y) {
		int a = x + 1;
		int b = y;
		boolean checkDone = false;

		while (!checkDone) {
			if (Movement.fieldExistsCheck(a, b)) {
				checkDone = board.getBoard()[a][b].fieldCheck(turn);
			} else {
				checkDone = true;
			}
			a++;
		}
	}

	public static void down(Board board, Colour turn, int x, int y) {
		int a = x - 1;
		int b = y;
		boolean checkDone = false;

		while (!checkDone) {
			if (Movement.fieldExistsCheck(a, b)) {
				checkDone = board.getBoard()[a][b].fieldCheck(turn);
			} else {
				checkDone = true;
			}
			a--;
		}
	}

	public static void left(Board board, Colour turn, int x, int y) {
		int a = x;
		int b = y - 1;
		boolean checkDone = false;

		while (!checkDone) {
			if (Movement.fieldExistsCheck(a, b)) {
				checkDone = board.getBoard()[a][b].fieldCheck(turn);
			} else {
				checkDone = true;
			}
			b--;
		}
	}

	public static void right(Board board, Colour turn, int x, int y) {
		int a = x;
		int b = y + 1;
		boolean checkDone = false;

		while (!checkDone) {
			if (Movement.fieldExistsCheck(a, b)) {
				checkDone = board.getBoard()[a][b].fieldCheck(turn);
			} else {
				checkDone = true;
			}
			b++;
		}
	}

	public static void upRight(Board board, Colour turn, int x, int y) {
		int a = x + 1;
		int b = y + 1;
		boolean checkDone = false;

		while (!checkDone) {
			if (Movement.fieldExistsCheck(a, b)) {
				checkDone = board.getBoard()[a][b].fieldCheck(turn);
			} else {
				checkDone = true;
			}
			a++;
			b++;
		}
	}

	public static void downRight(Board board, Colour turn, int x, int y) {
		int a = x - 1;
		int b = y + 1;
		boolean checkDone = false;

		while (!checkDone) {
			if (Movement.fieldExistsCheck(a, b)) {
				checkDone = board.getBoard()[a][b].fieldCheck(turn);
			} else {
				checkDone = true;
			}
			a--;
			b++;
		}
	}

	public static void upLeft(Board board, Colour turn, int x, int y) {
		int a = x + 1;
		int b = y - 1;
		boolean checkDone = false;

		while (!checkDone) {
			if (Movement.fieldExistsCheck(a, b)) {
				checkDone = board.getBoard()[a][b].fieldCheck(turn);
			} else {
				checkDone = true;
			}
			a++;
			b--;
		}
	}

	public static void downLeft(Board board, Colour turn, int x, int y) {
		int a = x - 1;
		int b = y - 1;
		boolean checkDone = false;

		while (!checkDone) {
			if (Movement.fieldExistsCheck(a, b)) {
				checkDone = board.getBoard()[a][b].fieldCheck(turn);
			} else {
				checkDone = true;
			}
			a--;
			b--;
		}
	}

	public static void kingMovement(Board board, Colour turn, int x, int y) {
		if (Movement.fieldExistsCheck(x + 1, y))
			board.getBoard()[x + 1][y].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x - 1, y))
			board.getBoard()[x - 1][y].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x, y + 1))
			board.getBoard()[x][y + 1].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x, y - 1))
			board.getBoard()[x][y - 1].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x + 1, y + 1))
			board.getBoard()[x + 1][y + 1].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x + 1, y - 1))
			board.getBoard()[x + 1][y - 1].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x - 1, y + 1))
			board.getBoard()[x - 1][y + 1].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x - 1, y + 1))
			board.getBoard()[x - 1][y - 1].fieldCheck(turn);
	}

	public static void pawnMovement(Board board, Colour turn, int x, int y) {
		if (turn == Colour.White) {
			if (Movement.fieldExistsCheck(x + 1, y) && board.getBoard()[x + 1][y].getPiece() == null) {
				board.getBoard()[x + 1][y].setHighlighted(true);
				if (x == 1 && board.getBoard()[x + 2][y].getPiece() == null) {
					board.getBoard()[x + 2][y].setHighlighted(true);
				}
			}
			if (Movement.fieldExistsCheck(x + 1, y + 1) && board.getBoard()[x + 1][y + 1].getPiece() != null) {
				if (board.getBoard()[x + 1][y + 1].getPiece().getColour() != turn)
					board.getBoard()[x + 1][y + 1].setHighlighted(true);
			}
			if (Movement.fieldExistsCheck(x + 1, y - 1) && board.getBoard()[x + 1][y - 1].getPiece() != null) {
				if (board.getBoard()[x + 1][y - 1].getPiece().getColour() != turn)
					board.getBoard()[x + 1][y - 1].setHighlighted(true);
			}
		} else {
			if (Movement.fieldExistsCheck(x - 1, y) && board.getBoard()[x - 1][y].getPiece() == null) {
				board.getBoard()[x - 1][y].setHighlighted(true);
				if (x == 6 && board.getBoard()[x - 2][y].getPiece() == null) {
					board.getBoard()[x - 2][y].setHighlighted(true);
				}
			}
			if (Movement.fieldExistsCheck(x - 1, y + 1) && board.getBoard()[x - 1][y + 1].getPiece() != null) {
				if (board.getBoard()[x - 1][y + 1].getPiece().getColour() != turn)
					board.getBoard()[x - 1][y + 1].setHighlighted(true);
			}
			if (Movement.fieldExistsCheck(x - 1, y - 1) && board.getBoard()[x - 1][y - 1].getPiece() != null) {
				if (board.getBoard()[x - 1][y - 1].getPiece().getColour() != turn)
					board.getBoard()[x - 1][y - 1].setHighlighted(true);
			}
		}
	}

	public static void knightMovement(Board board, Colour turn, int x, int y) {
		if (Movement.fieldExistsCheck(x + 2, y + 1))
			board.getBoard()[x + 2][y + 1].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x + 2, y - 1))
			board.getBoard()[x + 2][y - 1].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x - 2, y + 1))
			board.getBoard()[x - 2][y + 1].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x - 2, y - 1))
			board.getBoard()[x - 2][y - 1].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x + 1, y + 2))
			board.getBoard()[x + 1][y + 2].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x + 1, y - 2))
			board.getBoard()[x + 1][y - 2].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x - 1, y + 2))
			board.getBoard()[x - 1][y + 2].fieldCheck(turn);
		if (Movement.fieldExistsCheck(x - 1, y - 2))
			board.getBoard()[x - 1][y - 2].fieldCheck(turn);
	}

	private static boolean fieldExistsCheck(int x, int y) {
		boolean exists = false;
		if (x >= 0 && x < 8 && y >= 0 && y < 8) {
			exists = true;
		}
		return exists;
	}
}
