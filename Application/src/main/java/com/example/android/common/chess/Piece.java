package com.example.android.common.chess;

public class Piece {
	
	private Colour colour;
	
	public Piece(Colour colour) {
		this.colour=colour;
	}
	
	public Colour getColour() {
		return this.colour;
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
	}
}
