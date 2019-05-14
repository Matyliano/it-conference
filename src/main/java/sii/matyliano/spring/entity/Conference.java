package sii.matyliano.spring.entity;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Conference {


    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime startTime;
    private LocalTime endTime;

    private static final Duration BREAK_TIME = Duration.ofMinutes(15);

    private List<List<LecturePath>> dayPaths = new ArrayList<List<LecturePath>>();

    private List<User> users = new ArrayList<>();

    public Conference() {
        startDate = LocalDate.of(2019, 6, 1);
        endDate = LocalDate.of(2019, 6, 2);
        startTime = LocalTime.of(10, 0);
        endTime = LocalTime.of(13, 45);
    }

    private void initLecturePaths() {
        LocalDate current = startDate;

        while (!current.isAfter(endDate)) {
            List<LecturePath> paths = Arrays.asList(new LecturePath[3]);
            dayPaths.add(paths);
            current = current.plusDays(1);
        }

        LocalDate date = startDate;
        LocalDate date2 = startDate.plusDays(1);
        LocalTime time = startTime;
        LocalTime time2 = time.plusHours(2);

        LecturePath path0 = new LecturePath("First Path");
        path0.addLecture(new Lecture("Co w Javie piszczy ", date, time));
        path0.addLecture(new Lecture("Vaadin dla opornych", date, time2));

        LecturePath path01 = new LecturePath("Second Path");
        path01.addLecture(new Lecture("Nie taki Python straszny", date, time));
        path01.addLecture(new Lecture("", date, time2));

        LecturePath path02 = new LecturePath("Third Path");
        path02.addLecture(new Lecture("", date, time));
        path02.addLecture(new Lecture("", date, time2));

        LecturePath path10 = new LecturePath("First Path");
        path10.addLecture(new Lecture("", date2, time2));
        path10.addLecture(new Lecture("  ", date2, time2));

        LecturePath path20 = new LecturePath("Second Path");
        path20.addLecture(new Lecture("", date2, time2));
        path20.addLecture(new Lecture("", date2, time2));

        LecturePath path30 = new LecturePath("Third Path");
        path30.addLecture(new Lecture("", date2, time2));
        path30.addLecture(new Lecture("", date2, time2));


    }


}
