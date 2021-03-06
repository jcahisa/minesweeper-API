package gojoego.resources;

import com.codahale.metrics.annotation.Timed;
import gojoego.api.Game;
import gojoego.api.User;
import gojoego.db.GameDAO;
import gojoego.db.UserDAO;
import gojoego.exception.BusinessLogicException;
import gojoego.exception.UserNameAlreadyExists;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    final UserDAO dao;
    final GameDAO gameDAO;

    public UserResource(UserDAO dao, GameDAO gameDAO) {
        this.dao = dao;
        this.gameDAO = gameDAO;
    }

    @GET
    @Timed
    @UnitOfWork
    @Path("/{userName}")
    public Optional<User> getUser(@PathParam("userName") String userName) throws BusinessLogicException {
        return dao.findByUserName(userName);
    }

    @POST
    @Timed
    @UnitOfWork
    @Path("/{userName}")
    public User createUser(@PathParam("userName") String userName) throws BusinessLogicException {
        final Optional<User> optionalExistingUser = dao.findByUserName(userName);
        if (optionalExistingUser.isPresent()) {
            throw new UserNameAlreadyExists("User name already exists");
        }
        final User newUser = new User(userName);
        return dao.create(newUser);
    }

    @GET
    @Path("/{userId}/activeGames")
    @Timed
    @UnitOfWork
    public List<Game> findActiveGames(@PathParam("userId") UUID userId) {
        return gameDAO.findActiveGamesForUser(userId);
    }

    @POST
    @Timed
    @UnitOfWork
    @Path("/{userId}/createGame")
    public Game createGame(@PathParam("userId") UUID userId) throws BusinessLogicException {
        final Game newGame = new Game(userId);
        return gameDAO.create(newGame);
    }

    @GET
    @Path("/all")
    @Timed
    @UnitOfWork
    public List<User> findAll() {
        return dao.findAll();
    }
}
