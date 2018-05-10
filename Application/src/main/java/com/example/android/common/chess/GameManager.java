package com.example.android.common.chess;

public class GameManager {

	private Board board;
	private boolean selectionActive = false;
	private int selectedX = -1;
	private int selectedY = -1;
	private Colour turn;
	private Colour myColour = Colour.White;
	private String movement = null;
	private boolean gameOver = false;

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

	public void onClick(int x, int y) {
		if (amIWhite() && isMyTurn()){
			x = 7 - x;
			y = 7 - y;
		}
		if (x == selectedX && y == selectedY) {
			System.out.println("same");
			selectedY = -1;
			selectedX = -1;
			board.clearHighlights();
			return;
		}
		if (isCorrectPieceSelected(board.getBoard()[x][y]) && selectedX == -1) {
			board.clearHighlights();
			board.getBoard()[x][y].getPiece().movementCheck(board, turn, x, y);
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board.getBoard()[i][j].isHighlighted()) {
						Board temp = board.clone();
						temp.movePiece(x, y, i, j);
						board.getBoard()[i][j].setHighlighted(!temp.checkCheck(turn));
					}
				}
			}
			selectedX = x;
			selectedY = y;
		} else if (board.getBoard()[x][y].isHighlighted()) {
			board.getBoard()[x][y].setPiece(board.getBoard()[selectedX][selectedY].getPiece());
			board.getBoard()[selectedX][selectedY].empty();
			board.clearHighlights();
			setMovement(x, y);
			turnPasses();
		} else if(isCorrectPieceSelected(board.getBoard()[x][y])&&selectedX!=-1){
			board.clearHighlights();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board.getBoard()[i][j].isHighlighted()) {
						Board temp = board.clone();
						temp.movePiece(x, y, i, j);
						board.getBoard()[i][j].setHighlighted(!temp.checkCheck(turn));
					}
				}
			}
			selectedX = x;
			selectedY = y;
			System.out.println(selectedX);
			System.out.println(selectedY);
		}
	}

	public Field[][] getBoard() {
		return amIWhite() ? board.getReversedBoard() : board.getBoard();
		//return board.getBoard();
	}

	public void setMyColour(Colour colour) {
		myColour = colour;
	}

	public boolean amIWhite() {
		return myColour == Colour.White;
	}

	public boolean isMyTurn() { return myColour == turn; }

	public String getMovement() { return movement; }

	public void nullifyLastSavedMovement() { movement = null; }

	private boolean isCorrectPieceSelected(Field field) {
		return field.getPiece() != null && field.getPiece().getColour() == turn;
	}

	private void setMovement(int x, int y) {
		movement = String.format("%d,%dTO%d,%d", selectedX, selectedY, x, y);
	}

	private void turnPasses() {
		selectedX = -1;
		selectedY = -1;
		if (turn==Colour.White) {
			turn=Colour.Black;
		}else {
			turn=Colour.White;
		}
		if (board.checkCheck(turn))
			if (board.mateCheck(turn))
				gameOver = true;
	}
}
