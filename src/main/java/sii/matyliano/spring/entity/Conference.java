package sii.matyliano.spring.entity;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Conference {


    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime startTime;
    private LocalTime endTime;

    private static final Duration BREAK_TIME = Duration.ofMinutes(15);

    private List<LecturePath> dayPaths = new ArrayList<>();

    private List<User> users = new ArrayList<>();

    public Conference() {
        startDate = LocalDate.of(2019, 6, 1);
        endDate = LocalDate.of(2019, 6, 2);
        startTime = LocalTime.of(10, 0);
        endTime = LocalTime.of(13, 45);
    }

}
