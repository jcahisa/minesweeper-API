package gojoego.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "minesweeper_users")
@NamedQueries({
        @NamedQuery(
                name = "gojoego.api.User.findAll",
                query = "select u from User u"),

        @NamedQuery(
                name = "gojoego.api.User.findByUserName",
                query = "select u from User u where u.userName = :userName"),

        @NamedQuery(
                name = "gojoego.api.User.findActiveGames",
                query = "select g from User u, Game g where u.id = :userId and g.userId = u.id"
        )
})
public class User {
    private String userName;
    private UUID id;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
        this.id = UUID.randomUUID();
    }

    @Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @Column(name = "id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
