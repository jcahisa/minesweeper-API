package gojoego.db;

import gojoego.api.Game;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class GameDAO extends AbstractDAO<Game> {
    public GameDAO(SessionFactory factory) {
        super(factory);
    }

    public Game create(Game game) {
        return persist(game);
    }

    public List<Game> findActiveGamesForUser(UUID userId) {
        final Query<Game> query = (Query<Game>) namedQuery("gojoego.api.Game.findActiveGames");
        query.setParameter("userId", userId);
        return list(query);
    }
}
