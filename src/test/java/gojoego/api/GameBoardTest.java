package gojoego.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameBoardTest {

    @Test
    public void createNewGameBoardTest() {
        final GameBoard gameBoard = new GameBoard(10, 10, 10);
        assertEquals(10, gameBoard.getRows());
        assertEquals(10, gameBoard.getColumns());

        assertEquals("Total Cells",100, gameBoard.countTotalCells());
        assertEquals("All Cells are Covered",100, gameBoard.countCellsWithStatus(CellStatus.COVERED));
        assertEquals("No Cell is flagged",0, gameBoard.countCellsWithStatus(CellStatus.FLAGGED));
        assertEquals("No Cell is uncovered", 0, gameBoard.countCellsWithStatus(CellStatus.UNCOVERED));

        assertEquals("Expected number of bombs", 10, gameBoard.countCellsWithContent(CellContent.BOMB));
    }

    /*******************************************************************************
        This test use the following GameBoard to test different scenarios:

            0   1   2   3   4
        0 | B |   |   | B |   |
        1 |   |   |   | B |   |
        2 |   |   |   |   |   |
        3 | B |   |   |   |   |
        4 | B | B |   |   | B |

     **********************************************************************************/
    @Test
    public void updateSurroundingBombsTest() {
        final GameBoard gameBoard = new GameBoard();
        gameBoard.setRows(5);
        gameBoard.setColumns(5);

        final Cell[][] cells = new Cell[5][5];
        gameBoard.setCells(cells);
        gameBoard.initializeGameBoard();
        cells[0][0].setContent(CellContent.BOMB);
        cells[0][3].setContent(CellContent.BOMB);
        cells[1][3].setContent(CellContent.BOMB);
        cells[3][0].setContent(CellContent.BOMB);
        cells[4][0].setContent(CellContent.BOMB);
        cells[4][1].setContent(CellContent.BOMB);
        cells[4][4].setContent(CellContent.BOMB);

        gameBoard.updateSurroundingBombs();
        assertEquals(0, cells[0][0].getSurroundingBombs());
        assertEquals(1, cells[0][1].getSurroundingBombs());
        assertEquals(2, cells[0][2].getSurroundingBombs());
        assertEquals(0, cells[0][3].getSurroundingBombs());
        assertEquals(2, cells[0][4].getSurroundingBombs());

        assertEquals(1, cells[1][0].getSurroundingBombs());
        assertEquals(1, cells[1][1].getSurroundingBombs());
        assertEquals(2, cells[1][2].getSurroundingBombs());
        assertEquals(0, cells[1][3].getSurroundingBombs());
        assertEquals(2, cells[1][4].getSurroundingBombs());

        assertEquals(1, cells[2][0].getSurroundingBombs());
        assertEquals(1, cells[2][1].getSurroundingBombs());
        assertEquals(1, cells[2][2].getSurroundingBombs());
        assertEquals(1, cells[2][3].getSurroundingBombs());
        assertEquals(1, cells[2][4].getSurroundingBombs());

        assertEquals(0, cells[3][0].getSurroundingBombs());
        assertEquals(3, cells[3][1].getSurroundingBombs());
        assertEquals(1, cells[3][2].getSurroundingBombs());
        assertEquals(1, cells[3][3].getSurroundingBombs());
        assertEquals(1, cells[3][4].getSurroundingBombs());

        assertEquals(0, cells[4][0].getSurroundingBombs());
        assertEquals(0, cells[4][1].getSurroundingBombs());
        assertEquals(1, cells[4][2].getSurroundingBombs());
        assertEquals(1, cells[4][3].getSurroundingBombs());
        assertEquals(0, cells[4][4].getSurroundingBombs());
    }
}
