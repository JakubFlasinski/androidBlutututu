package com.example.android.common.chess;

public class Knight extends Piece{

	public Knight(Colour colour) {
		super(colour);
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
		Movement.knightMovement(board, turn, x, y);
	}

}
