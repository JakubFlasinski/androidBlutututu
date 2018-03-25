package com.example.android.common.chess;

public class Bishop extends Piece{

	public Bishop(Colour colour) {
		super(colour);
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
		Movement.upRight(board, turn, x, y);
		Movement.upLeft(board, turn, x, y);
		Movement.downRight(board, turn, x, y);
		Movement.downLeft(board, turn, x, y);
	}

}
