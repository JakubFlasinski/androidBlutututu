package com.example.android.common.chess;

import com.example.android.bluetoothchat.R;

public class King extends Piece{

	public King(Colour colour) {
		super(colour);
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
		Movement.kingMovement(board, turn, x, y);
	}


	private String type = "king";
	public int getDrawableId() {
		return getColour() == Colour.Black ? R.drawable.king_black : R.drawable.king_white;
	}
}
