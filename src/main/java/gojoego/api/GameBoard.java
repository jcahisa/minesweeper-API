package gojoego.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameBoard {
    private int rows;
    private int columns;
    private int[][] gameBoard;

    public GameBoard() {
        // Jackson deserialization
    }

    public GameBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.gameBoard = new int[rows][columns];
        this.initializeGameBoard();
    }

    @JsonProperty
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @JsonProperty
    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    @JsonProperty
    public int[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(int[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    private void initializeGameBoard() {

    }
}
