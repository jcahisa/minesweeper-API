package gojoego.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import gojoego.exception.BusinessLogicException;
import org.joda.time.DateTime;

import java.util.UUID;

public class Game {
    private UUID id;
    private UUID userId;
    private DateTime startTime;
    private GameStatus status;
    private GameBoard gameBoard;

    public Game() {
        // Jackson deserialization
    }

    public Game(UUID userId) throws BusinessLogicException {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.startTime = DateTime.now();
        this.status = GameStatus.ACTIVE;
        this.gameBoard = new GameBoard(10, 10, 10);
    }

    @JsonProperty
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonProperty
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @JsonProperty
    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    @JsonProperty
    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    @JsonProperty
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void toggleFlagOnCell(int row, int col) throws BusinessLogicException {
        gameBoard.toggleFlagOnCell(row, col);
    }

    public void uncoverCell(int row, int col) throws BusinessLogicException {
        gameBoard.uncoverCell(row, col);
    }

}
