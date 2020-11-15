package gojoego.resources;

import com.codahale.metrics.annotation.Timed;
import gojoego.api.Game;
import gojoego.exception.BusinessLogicException;
import gojoego.exception.GameNotFoundException;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

    @GET
    @Timed
    @Path("/{gameId}")
    public Game getGame(UUID gameId) {
        return activeGames.get(gameId);
    }

    @PUT
    @Timed
    @Path("/{gamedId}/cell/{row}/{col}/toggleFlag")
    public Game toggleFlag(@PathParam("gamedId") UUID gameId,
                           @PathParam("row") int row,
                           @PathParam("col") int col) throws BusinessLogicException {
        final Game game = getActiveGame(gameId);
        game.toggleFlagOnCell(row, col);
        return game;
    }

    @PUT
    @Timed
    @Path("/{gamedId}/cell/{row}/{col}/uncoverCell")
    public Game uncoverCell(@PathParam("gamedId") UUID gameId,
                           @PathParam("row") int row,
                           @PathParam("col") int col) throws BusinessLogicException {
        final Game game = getActiveGame(gameId);
        game.uncoverCell(row, col);
        return game;
    }

    private Game getActiveGame(UUID gameId) throws BusinessLogicException {
        final Game game = activeGames.get(gameId);
        if (game == null) {
            throw new GameNotFoundException("Requested Game Not Found");
        }
        return game;
    }
}
