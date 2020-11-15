package gojoego.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.annotations.VisibleForTesting;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class GameBoard {
    private int rows;
    private int columns;
    private int numberOfBombs;
    private Cell[][] cells;

    public GameBoard() {
        // Jackson deserialization
    }

    public GameBoard(int rows, int columns, int numberOfBombs) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];
        this.numberOfBombs = numberOfBombs;
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
    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public long countTotalCells() {
        return Arrays.stream(this.getCells())
              .map(row -> row.length)
              .reduce(0, (a, b) -> a + b);
    }

    public long countCellsWithStatus(CellStatus targetStatus) {
        return Arrays.stream(this.getCells())
                     .map(row -> Arrays.stream(row)
                              .filter(cell -> cell.getStatus().equals(targetStatus))
                              .count()
                     )
                     .reduce(0L, (a, b) -> a + b);
    }

    public long countCellsWithContent(CellContent content) {
        return Arrays.stream(this.getCells())
                     .map(row -> Arrays.stream(row)
                                       .filter(cell -> cell.getContent().equals(content))
                                       .count()
                         )
                     .reduce(0L, (a, b) -> a + b);
    }

    public CellContent uncoverCell(int row, int col) {
        cells[row][col].uncover();
        if (cells[row][col].getContent().equals(CellContent.EMPTY)) {
            uncoverEmptyNeighbors(row, col);
        }
        return cells[row][col].getContent();
    }

    @VisibleForTesting
    protected void uncoverEmptyNeighbors(int row, int col) {
        applyFunctionOnNeighborhood(row, col, (Integer i, Integer j) -> {
            final Cell cell = cells[i.intValue()][j.intValue()];
            if (!cell.isUncovered() && cell.isEmpty()) {
                cell.uncover();
                uncoverEmptyNeighbors(i.intValue(), j.intValue());
            }
        });
    }

    @VisibleForTesting
    protected void updateSurroundingBombsHints() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[i][j].getContent().equals(CellContent.EMPTY)) {
                    this.updateSurroundingBombsForCell(i, j);
                }
            }
        }
    }

    private void updateSurroundingBombsForCell(int row, int col) {
        AtomicInteger totalBombs = new AtomicInteger();

        applyFunctionOnNeighborhood(row, col, (Integer i, Integer j) -> {
            if (cells[i.intValue()][j.intValue()].getContent().equals(CellContent.BOMB)) {
                totalBombs.getAndIncrement();
            }
        });

        if (totalBombs.get() > 0) {
            cells[row][col].setContent(CellContent.HINT);
            cells[row][col].setSurroundingBombs(totalBombs.get());
        }
    }

    private void applyFunctionOnNeighborhood(int row, int col, BiConsumer<Integer, Integer> function) {
        int startingCheckRow = Math.max(0, row - 1);
        int startingCheckCol = Math.max(0, col - 1);

        int lastCheckRow = Math.min( this.rows - 1, row + 1);
        int lastCheckCol = Math.min( this.columns - 1, col + 1);

        for (int i = startingCheckRow; i <= lastCheckRow; i++) {
            for (int j = startingCheckCol; j <= lastCheckCol; j++) {
                if (!(i == row && j == col)) {
                    function.accept(i, j);
                }
            }
        }

    }

    @VisibleForTesting
    protected void initializeGameBoard() {
        int numberOfAddedBombs = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells.length; j++) {
                final CellContent cellContent = randomlyDecideContentType(numberOfAddedBombs);
                if (cellContent.equals(CellContent.BOMB)) {
                    numberOfAddedBombs++;
                }
                cells[i][j] = new Cell(cellContent);
            }
        }

        // Make sure we added all the bombs requested
        if (numberOfAddedBombs < this.numberOfBombs) {
            completeMissingBombs(numberOfAddedBombs);
        }
    }

    // 'not randomly' adding bombs
    private void completeMissingBombs(int numberOfAddedBombs) {
        int i = 0;
        int j = 0;
        int missingBombs = this.numberOfBombs - numberOfAddedBombs;
        while (missingBombs > 0) {
            if (!cells[i][j].getContent().equals(CellContent.BOMB)) {
                cells[i][j].setContent(CellContent.BOMB);
                missingBombs--;
            }
            i++;
            if (i >= cells.length) {
                i = 0;
                j++;
            }
        }
    }

    private CellContent randomlyDecideContentType(int numberOfAddedBombs) {
        if (numberOfAddedBombs < this.numberOfBombs) {
            double randomValue = Math.random();
            if (randomValue < this.numberOfBombs / ( this.rows * this.columns)) {
                return CellContent.BOMB;
            }
        }
        return CellContent.EMPTY;
    }
}
