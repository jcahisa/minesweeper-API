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
}
