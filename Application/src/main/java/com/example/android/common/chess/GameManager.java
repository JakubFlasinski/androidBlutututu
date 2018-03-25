package com.example.android.common.chess;

public class GameManager {
	
	private Board board;
	private boolean selectionActive = false;
	private int selectedX;
	private int selectedY;
	private Colour turn;
	
	private static GameManager gameManager = null;
	
	public static GameManager getInstance() {
		if (gameManager == null)
			gameManager = new GameManager();
		return gameManager;
	}
	
	public GameManager() {
		this.board = new Board();
		this.turn = Colour.White;
	}
	
	public void onClick(Colour player, int x, int y) {
		if (!selectionActive) {
			if (board.getBoard()[x][y].getPiece().getColour() == turn) {
				board.getBoard()[x][y].getPiece().movementCheck(board,turn,x,y);
				selectionActive = true;
				selectedX=x;
				selectedY=y;
			}else if(board.getBoard()[x][y].isHighlighted()){
				board.getBoard()[x][y].setPiece(board.getBoard()[selectedX][selectedY].getPiece());
				board.getBoard()[selectedX][selectedY].empty();
				board.clearHighlights();
				selectionActive=false;
				turnPasses();
			}
		}
	}
	
	private void turnPasses() {
		if (turn==Colour.White) {
			turn=Colour.Black;
		}else {
			turn=Colour.White;
		}
	}

}
