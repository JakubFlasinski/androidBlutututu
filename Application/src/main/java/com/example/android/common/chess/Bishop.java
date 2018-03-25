package com.example.android.common.chess;

import com.example.android.bluetoothchat.R;

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

	private String type = "bishop";
	public int getDrawableId() {
		return getColour() == Colour.Black ? R.drawable.bishop_black : R.drawable.bishop_white;
	}
}
