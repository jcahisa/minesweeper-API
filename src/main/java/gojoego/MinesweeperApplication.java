package gojoego;

import gojoego.api.Game;
import gojoego.api.User;
import gojoego.db.GameDAO;
import gojoego.db.UserDAO;
import gojoego.exception.BusinessLogicExceptionMapper;
import gojoego.resources.GameResource;
import gojoego.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MinesweeperApplication extends Application<MinesweeperConfiguration> {

    private final HibernateBundle<MinesweeperConfiguration> hibernate = new HibernateBundle<MinesweeperConfiguration>(User.class, Game.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(MinesweeperConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(final String[] args) throws Exception {
        new MinesweeperApplication().run(args);
    }

    @Override
    public String getName() {
        return "Minesweeper";
    }

    @Override
    public void initialize(final Bootstrap<MinesweeperConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final MinesweeperConfiguration configuration,
                    final Environment environment) {
        final UserDAO dao = new UserDAO(hibernate.getSessionFactory());
        final GameDAO gameDao = new GameDAO(hibernate.getSessionFactory());

        final GameResource gameResource = new GameResource(gameDao);
        environment.jersey().register(gameResource);

        environment.jersey().register(new UserResource(dao, gameDao));
        environment.jersey().register(new BusinessLogicExceptionMapper());
    }

}
