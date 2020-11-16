package gojoego.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import gojoego.db.GameBoardConverter;
import gojoego.exception.BusinessLogicException;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "minesweeper_games")
@NamedQueries({
        @NamedQuery(
                name = "gojoego.api.Game.findActiveGames",
                query = "select g from User u, Game g where u.id = :userId and g.userId = u.id"
        )
})
public class Game {
    private UUID id;
    private UUID userId;
    private DateTime startTime;
    private DateTime endTime;
    private GameStatus status;
    private GameBoard gameBoard;

    public Game() {
        // Jackson deserialization
    }

    public Game(UUID userId) throws BusinessLogicException {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.startTime = DateTime.now();
        this.endTime = null;
        this.status = GameStatus.ACTIVE;
        this.gameBoard = new GameBoard(10, 10, 10);
    }

    @JsonProperty
    @Id
    @Column(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @JsonProperty
    @Column(name = "userId")
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @JsonProperty
    @Column(name = "startTime")
    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    @JsonProperty
    @Column(name = "endTime")
    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    @JsonProperty
    @Column(name = "status")
    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    @JsonProperty
    @Column(name = "gameboard", columnDefinition="TEXT")
    @Convert(converter = GameBoardConverter.class)
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
        CellContent content = gameBoard.uncoverCell(row, col);
        if (content.equals(CellContent.BOMB)) {
            this.status = GameStatus.LOSE;
            this.endTime = DateTime.now();
            return;
        }

        if (gameBoard.allNonBombsCellsHaveBeenUncovered()) {
            this.status = GameStatus.WIN;
            this.endTime = DateTime.now();
        };

        return;
    }

}
