package main.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "users")
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "session_id")
    @Size(max = 255)
    private String sessionId;

    @Column(name = "login")
    @Size(max = 255)
    private String login;

    public User(Integer id, String sessionId, String login) {
        this.id = id;
        this.sessionId = sessionId;
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
