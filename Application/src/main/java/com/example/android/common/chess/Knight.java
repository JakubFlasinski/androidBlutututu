package com.example.android.common.chess;

import com.example.android.bluetoothchat.R;

public class Knight extends Piece{

	public Knight(Colour colour) {
		super(colour);
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
		Movement.knightMovement(board, turn, x, y);
	}

	private String type = "knight";
	public int getDrawableId() {
		return getColour() == Colour.Black ? R.drawable.knight_black : R.drawable.knight_white;
	}
}
