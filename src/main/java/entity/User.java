package entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Table(name = "users")
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
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
}
