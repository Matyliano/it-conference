package sii.matyliano.spring.entity;


import java.util.ArrayList;
import java.util.List;


public class LecturePath {


    private Long id;

    private String name;

    private List<Lecture> lectures = new ArrayList<>();

    public LecturePath(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

}
