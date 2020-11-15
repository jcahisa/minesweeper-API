package gojoego.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameBoardTest {

    @Test
    public void createNewGameBoard() {
        final GameBoard gameBoard = new GameBoard(10, 10, 10);
        assertEquals(10, gameBoard.getRows());
        assertEquals(10, gameBoard.getColumns());

        assertEquals("Total Cells",100, gameBoard.countTotalCells());
        assertEquals("All Cells are Covered",100, gameBoard.countCellsWithStatus(CellStatus.COVERED));
        assertEquals("No Cell is flagged",0, gameBoard.countCellsWithStatus(CellStatus.FLAGGED));
        assertEquals("No Cell is uncovered", 0, gameBoard.countCellsWithStatus(CellStatus.UNCOVERED));

        assertEquals("Expected number of bombs", 10, gameBoard.countCellsWithContent(CellContent.BOMB));
    }
}
