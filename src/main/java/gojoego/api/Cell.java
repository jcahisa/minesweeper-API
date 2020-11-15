package gojoego.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cell {
    private CellContent content;
    private CellStatus status;
    private int surroundingBombs = 0;

    public Cell() {
    }

    public Cell(CellContent content) {
        this.status = CellStatus.COVERED;
        this.content = content;
    }

    @JsonProperty
    public CellContent getContent() {
        return content;
    }

    public void setContent(CellContent content) {
        this.content = content;
    }

    @JsonProperty
    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }

    @JsonProperty
    public int getSurroundingBombs() {
        return surroundingBombs;
    }

    public void setSurroundingBombs(int surroundingBombs) {
        this.surroundingBombs = surroundingBombs;
    }

    public void uncover() {
        this.status = CellStatus.UNCOVERED;
    }

    public boolean isUncovered() {
        return status.equals(CellStatus.UNCOVERED);
    }

    public boolean isEmpty() {
        return content.equals(CellContent.EMPTY);
    }

    public boolean isBomb() {
        return content.equals(CellContent.BOMB);
    }

    public void toogleFlag() {
        if (status.equals(CellStatus.FLAGGED)) {
            setStatus(CellStatus.COVERED);
        } else {
            setStatus(CellStatus.FLAGGED);
        }
    }
}
