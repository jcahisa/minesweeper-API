package gojoego.db;

import gojoego.api.Game;
import gojoego.api.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDAO extends AbstractDAO<User> {
    public UserDAO(SessionFactory factory) {
        super(factory);
    }

    public User findById(UUID id) {
        return get(id);
    }

    public Optional<User> findByUserName(String userName) {
        final Query<User> query = (Query<User>) namedQuery("gojoego.api.User.findByUserName");
        query.setParameter("userName", userName);
        final User user = uniqueResult(query);
        if (user == null) {
            return Optional.empty();
        } else {
            return  Optional.of(user);
        }
    }

    public User create(User user) {
        return persist(user);
    }

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return list((Query<User>) namedQuery("gojoego.api.User.findAll"));
    }
}
