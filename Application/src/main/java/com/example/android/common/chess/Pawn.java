package com.example.android.common.chess;

public class Pawn extends Piece{

	public Pawn(Colour colour) {
		super(colour);
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
		Movement.pawnMovement(board, turn, x, y);
	}

}
