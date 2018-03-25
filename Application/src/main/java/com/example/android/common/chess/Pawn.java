package com.example.android.common.chess;

import com.example.android.bluetoothchat.R;

public class Pawn extends Piece{

	public Pawn(Colour colour) {
		super(colour);
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
		Movement.pawnMovement(board, turn, x, y);
	}

	private String type = "pawn";
	public int getDrawableId() {
		return getColour() == Colour.Black ? R.drawable.pawn_black : R.drawable.pawn_white;
	}
}
