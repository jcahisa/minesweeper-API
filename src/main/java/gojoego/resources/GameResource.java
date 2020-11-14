package gojoego.resources;

import gojoego.api.GameBoard;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;

import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/game")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {
    private final String userName;
    private final GameBoard gameBoard;

    public GameResource() {
        this.userName = "Test User";
        this.gameBoard = new GameBoard(10, 10);
    }

    @GET
    public GameBoard getGame() {
        return this.gameBoard;
    }
}
