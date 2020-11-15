package gojoego.resources;

import com.codahale.metrics.annotation.Timed;
import gojoego.api.Game;
import gojoego.api.GameBoard;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;

import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Path("/game")
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {
    private final Map<UUID, Game> activeGames = new HashMap<>();

    public GameResource() {
    }

    @POST
    @Timed
    @Path("/{userId}")
    public Game createGame(@PathParam("userId") UUID userId) {
        final Game newGame = new Game(userId);
        activeGames.put(newGame.getId(), newGame);
        return newGame;
    }

    @GET
    @Timed
    @Path("/{gameId}")
    public Game getGame(UUID gameId) {
        return activeGames.get(gameId);
    }
}
