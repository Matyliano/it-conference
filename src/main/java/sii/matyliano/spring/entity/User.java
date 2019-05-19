package sii.matyliano.spring.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String username;

    @Email
    private String email;

    private String password;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "users_lectures",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "lectures_id"))
    private List<Lecture> lectures = new ArrayList<>();

    public User(String username, String email) {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public String getEmail() {
        return email;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
           inverseJoinColumns = @JoinColumn(name = "roles_id"))
    public Collection<Role> getRoles() {
        return roles;
    }

    public boolean addLecture(Lecture lecture) {
        if (lectures.contains(lecture)) {
            System.out.println("Error! You are already enrolled ");
            return false;
        }
        if (lecture.isFull()) {
            System.out.println("Error! This lecture is full");
            return false;
        }
        for (Lecture l : lectures) {
            if (l.getDate().equals(lecture.getDate()) && l.getTime().equals(lecture.getTime())) {
                System.out.println("Error! You already have a different lecture");
                return false;
            }
        }
        System.out.println("OK! Enrolled for lecture ");
        lectures.add(lecture);
        lecture.addUser(this);
        return true;
    }


}
