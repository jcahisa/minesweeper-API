package gojoego.api;

import gojoego.exception.BusinessLogicException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class GameBoardTest {

    @Test
    public void createNewGameBoardTest() throws BusinessLogicException {
        final GameBoard gameBoard = new GameBoard(10, 10, 10);
        assertEquals(10, gameBoard.getRows());
        assertEquals(10, gameBoard.getColumns());

        assertEquals("Total Cells",100, gameBoard.countTotalCells());
        assertEquals("All Cells are Covered",100, gameBoard.countCellsWithStatus(CellStatus.COVERED));
        assertEquals("No Cell is flagged",0, gameBoard.countCellsWithStatus(CellStatus.FLAGGED));
        assertEquals("No Cell is uncovered", 0, gameBoard.countCellsWithStatus(CellStatus.UNCOVERED));

        assertEquals("Expected number of bombs", 10, gameBoard.countCellsWithContent(CellContent.BOMB));
    }

    @Test
    public void updateSurroundingBombsTest() throws Exception {

        // 1's indicate where the bombs will be set
        final GameBoard gameBoard = createTestGameBoard(new int[][] {
                {1, 0, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1}
        });
        final Cell[][] cells = gameBoard.getCells();

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

    @Test
    public void uncoverCellTest() throws Exception {

        // 1's indicate where the bombs will be set
        final GameBoard gameBoard = createTestGameBoard(new int[][] {
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1}
        });
        final Cell[][] cells = gameBoard.getCells();
        gameBoard.uncoverCell(2, 2);

        assertEquals(CellStatus.UNCOVERED, cells[1][2].getStatus());
        assertEquals(CellStatus.COVERED, cells[0][0].getStatus());
        assertEquals(CellStatus.COVERED, cells[0][1].getStatus());
        assertEquals(CellStatus.UNCOVERED, cells[0][2].getStatus());
        assertEquals(CellStatus.UNCOVERED, cells[0][3].getStatus());
        assertEquals(CellStatus.UNCOVERED, cells[0][4].getStatus());

        assertEquals(CellStatus.COVERED, cells[1][0].getStatus());
        assertEquals(CellStatus.COVERED, cells[1][1].getStatus());
        assertEquals(CellStatus.UNCOVERED, cells[1][2].getStatus());
        assertEquals(CellStatus.UNCOVERED, cells[1][3].getStatus());
        assertEquals(CellStatus.UNCOVERED, cells[1][4].getStatus());

        assertEquals(CellStatus.COVERED, cells[2][0].getStatus());
        assertEquals(CellStatus.COVERED, cells[2][1].getStatus());
        assertEquals(CellStatus.UNCOVERED, cells[2][2].getStatus());
        assertEquals(CellStatus.UNCOVERED, cells[2][3].getStatus());
        assertEquals(CellStatus.UNCOVERED, cells[2][4].getStatus());

        assertEquals(CellStatus.COVERED, cells[3][0].getStatus());
        assertEquals(CellStatus.COVERED, cells[3][1].getStatus());
        assertEquals(CellStatus.COVERED, cells[3][2].getStatus());
        assertEquals(CellStatus.COVERED, cells[3][3].getStatus());
        assertEquals(CellStatus.COVERED, cells[3][4].getStatus());

        assertEquals(CellStatus.COVERED, cells[4][0].getStatus());
        assertEquals(CellStatus.COVERED, cells[4][1].getStatus());
        assertEquals(CellStatus.COVERED, cells[4][2].getStatus());
        assertEquals(CellStatus.COVERED, cells[4][3].getStatus());
        assertEquals(CellStatus.COVERED, cells[4][4].getStatus());
    }

    @Test
    public void getCellTest() throws Exception {

        // 1's indicate where the bombs will be set
        final GameBoard gameBoard = createTestGameBoard(new int[][]{
                {1, 0},
                {0, 0}
        });
        final Cell cell = gameBoard.getCell(0, 0);
        assertEquals(cell.getContent(), CellContent.BOMB);

        Exception thrownException = null;
        try {
            final Cell invalidCell = gameBoard.getCell(2, 0);
        } catch (Exception e) {
            thrownException = e;
        }
        assertNotNull(thrownException);
    }

    @Test
    public void allNonBombsUncoveredTest() throws Exception {
        final GameBoard gameBoard = createTestGameBoard(new int[][] {
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        });
        gameBoard.uncoverCell(2, 2);
        assertFalse(gameBoard.allNonBombsCellsHaveBeenUncovered());

        gameBoard.uncoverCell(0, 1);
        assertFalse(gameBoard.allNonBombsCellsHaveBeenUncovered());

        gameBoard.uncoverCell(1, 1);
        assertFalse(gameBoard.allNonBombsCellsHaveBeenUncovered());

        gameBoard.uncoverCell(1, 0);
        assertTrue(gameBoard.allNonBombsCellsHaveBeenUncovered());
    }

    private GameBoard createTestGameBoard(int[][] bombLocations) throws BusinessLogicException {
        final GameBoard gameBoard = new GameBoard();
        final int rows = bombLocations.length;
        final int cols = bombLocations[0].length;
        gameBoard.setRows(rows);
        gameBoard.setColumns(cols);

        final Cell[][] cells = new Cell[rows][cols];
        gameBoard.setCells(cells);
        gameBoard.initializeGameBoard();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (bombLocations[i][j] == 1) {
                    gameBoard.addBomb(i, j);
                }
            }
        }

        gameBoard.updateSurroundingBombsHints();
        return gameBoard;
    }
}
