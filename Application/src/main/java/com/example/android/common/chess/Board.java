package com.example.android.common.chess;

public class Board {

	public Field[][] board;

	public Board() {
		board = new Field[8][8];
		setUpBoard();
	}

	private void setUpBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i + j) % 2 == 0) {
					board[i][j] = new Field(Colour.Black);
				} else {
					board[i][j] = new Field(Colour.White);
				}
				if (i == 1) {
					board[i][j].setPiece(new Pawn(Colour.White));
				} else if (i == 6) {
					board[i][j].setPiece(new Pawn(Colour.Black));
				}
			}
		}
		board[0][0].setPiece(new Rook(Colour.White));
		board[0][1].setPiece(new Knight(Colour.White));
		board[0][2].setPiece(new Bishop(Colour.White));
		board[0][3].setPiece(new King(Colour.White));
		board[0][4].setPiece(new Queen(Colour.White));
		board[0][5].setPiece(new Bishop(Colour.White));
		board[0][6].setPiece(new Knight(Colour.White));
		board[0][7].setPiece(new Rook(Colour.White));
		board[0][0].setPiece(new Rook(Colour.Black));
		board[0][1].setPiece(new Knight(Colour.Black));
		board[0][2].setPiece(new Bishop(Colour.Black));
		board[0][3].setPiece(new King(Colour.Black));
		board[0][4].setPiece(new Queen(Colour.Black));
		board[0][5].setPiece(new Bishop(Colour.Black));
		board[0][6].setPiece(new Knight(Colour.Black));
		board[0][7].setPiece(new Rook(Colour.Black));
	}

//	public void click(Colour player, int x, int y) {
//		if (!selectionActive) {
//			if (board[x][y].getPiece().getColour() == player) {
//				board[x][y].getPiece().movementCheck();
//				selectionActive = true;
//			}else if(board[x][y].isHighlighted()){
//				board[x][y].setPiece(board[selectedX][selectedY].getPiece());
//				board[selectedX][selectedY].empty();
//			}
//		}
//	}
	
	public boolean checkCheck(Colour colour) {
		boolean isChecked = false;
		int[] position = this.findKing(colour);
		loop: for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(board[i][j].getPiece()!=null)
					if(board[i][j].getPiece().getColour()!=colour) {
						board[i][j].getPiece().movementCheck(this, colour, i, j);
						if(board[position[0]][position[1]].isHighlighted()) {
							isChecked=true;
							break loop;
						}
					}
				}
			}
		return isChecked;
	}

	public void clearHighlights() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.board[i][j].setHighlighted(false);
			}
		}
	}

	public Field[][] getBoard() {
		return board;
	}

	public void setBoard(Field[][] board) {
		this.board = board;
	}
	
	public int[] findKing(Colour colour) {
		int[] coords = new int[2];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(board[i][j].getPiece()!=null)
					if(board[i][j].getPiece().getColour()==colour)
						if(board[i][j].getPiece() instanceof King) {
							coords[0]=i;
							coords[1]=j;
						}
			}
		}
		return coords;
	}
}