package com.example.android.common.chess;

public class Rook extends Piece{

	public Rook(Colour colour) {
		super(colour);
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
		Movement.up(board, turn, x, y);
		Movement.down(board, turn, x, y);
		Movement.left(board, turn, x, y);
		Movement.right(board, turn, x, y);
	}

}
