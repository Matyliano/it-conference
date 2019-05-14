package sii.matyliano.spring.entity;


import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "lectures")
public class Lecture {

    private final int MAX_PEOPLE = 5;
    public final static Duration DURATION = Duration.ofMillis(105);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

    private LocalDate date;
    private LocalTime time;

    @ManyToMany(mappedBy = "lectures")
    private List<User> users = new ArrayList<>();

    private static int counter = 0;


    public Lecture(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

}
