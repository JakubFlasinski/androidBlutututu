package com.example.android.common.chess;

public class GameManager {

	private Board board;
	private boolean selectionActive = false;
	private int selectedX = -1;
	private int selectedY = -1;
	private Colour turn;
	private Colour myColour = Colour.White;
	private String movement = null;

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
        if (isCorrectPieceSelected(board.getBoard()[x][y]) && selectedX == -1) {
            board.getBoard()[x][y].getPiece().movementCheck(board, turn, x, y);
            selectedX = x;
            selectedY = y;
            System.out.println(selectedX);
            System.out.println(selectedY);
        } else if (board.getBoard()[x][y].isHighlighted()) {
            board.getBoard()[x][y].setPiece(board.getBoard()[selectedX][selectedY].getPiece());
            board.getBoard()[selectedX][selectedY].empty();
            board.clearHighlights();
            setMovement(x, y);
            turnPasses();
        }
    }

    public Field[][] getBoard() {
        return board.getBoard();
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
	}
}
