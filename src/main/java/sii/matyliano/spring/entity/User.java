package sii.matyliano.spring.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String username;
    private String email;


    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "users_lectures",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "lectures_id"))
    private List<Lecture> lectures = new ArrayList<>();

    public User() {
    }


    public User(String username, String password) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;
    }


    public boolean addLecture(Lecture lecture) {
        return true;
    }
}
