package com.example.android.common.chess;

public class King extends Piece{

	public King(Colour colour) {
		super(colour);
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
		Movement.kingMovement(board, turn, x, y);
	}

}
