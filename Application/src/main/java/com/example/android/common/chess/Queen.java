package com.example.android.common.chess;

import com.example.android.bluetoothchat.R;

public class Queen extends Piece{
	
	public Queen(Colour colour) {
		super(colour);
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
		Movement.up(board, turn, x, y);
		Movement.down(board, turn, x, y);
		Movement.left(board, turn, x, y);
		Movement.right(board, turn, x, y);
		Movement.upRight(board, turn, x, y);
		Movement.upLeft(board, turn, x, y);
		Movement.downRight(board, turn, x, y);
		Movement.downLeft(board, turn, x, y);
	}

	private String type = "queen";

	public int getDrawableId() {
		return getColour() == Colour.Black ? R.drawable.queen_black : R.drawable.queen_white;
	}

}
