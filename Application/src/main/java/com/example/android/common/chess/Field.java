package com.example.android.common.chess;

public class  Field {

	private Piece piece;
	private Colour colour;
	private boolean isHighlighted;

	public Field(Colour colour) {
		this.colour = colour;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public boolean isHighlighted() {
		return isHighlighted;
	}

	public void setHighlighted(boolean isHighlighted) {
		this.isHighlighted = isHighlighted;
	}
	
	public void empty() {
		this.piece = null;
	}
	
	public boolean fieldCheck(Colour turn) {
		boolean checkDone = false;
		if (this.getPiece() == null) {
			this.setHighlighted(true);
		} else if (this.getPiece().getColour() == turn) {
			checkDone=true;
		} else {
			this.setHighlighted(true);
			checkDone=true;
		}
		return checkDone;	
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

}