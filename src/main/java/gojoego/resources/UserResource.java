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

    @POST
    @Timed
    @UnitOfWork
    @Path("/{userName}")
    public User createUser(@PathParam("userName") String userName) throws BusinessLogicException {
        System.out.println(String.format("creating user with name = %s", userName));
        final Optional<User> optionalExistingUser = dao.findByUserName(userName);
        if (optionalExistingUser.isPresent()) {
            System.out.println("User Already Exists");
            throw new UserNameAlreadyExists("User name already exists");
        }
        System.out.println(String.format("Create new user with userName = %s ", userName));
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

    @GET
    @Path("/all")
    @Timed
    @UnitOfWork
    public List<User> findAll() {
        return dao.findAll();
    }
}
