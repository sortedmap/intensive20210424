package main.model;

import entity.User;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "messages")
@Entity
@Data
public class Message {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Integer id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id")
  private User user;

  @Column(columnDefinition = "TEXT")
  private String message;

  @Column(name = "time")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime time;
}
