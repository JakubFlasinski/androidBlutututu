package com.example.android.common.chess;

public class Piece {

	private String type = "piece";
	private Integer drawableId = 0;
	
	private Colour colour;
	
	public Piece(Colour colour) {
		this.colour=colour;
	}
	
	public Colour getColour() {
		return this.colour;
	}
	
	public void movementCheck(Board board, Colour turn, int x, int y) {
	}

	public String getType() {
		return type;
	}
	public int getDrawableId() {
		return drawableId;
	}
}
