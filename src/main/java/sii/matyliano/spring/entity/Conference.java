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

    private User logged = null;

    public Conference() {
        startDate = LocalDate.of(2019, 6, 1);
        endDate = LocalDate.of(2019, 6, 2);
        startTime = LocalTime.of(10, 0);
        endTime = LocalTime.of(13, 45);
    }

//    private void initLecturePaths() {
//        LocalDate current = startDate;
//
//        while (!current.isAfter(endDate)) {
//            List<LecturePath> paths = Arrays.asList(new LecturePath[3]);
//            dayPaths.add(paths);
//            current = current.plusDays(1);
//        }
//
//        LocalDate date = startDate;
//        LocalDate date2 = startDate.plusDays(1);
//        LocalTime time = startTime;
//        LocalTime time2 = time.plusHours(2);
//
//        LecturePath path0 = new LecturePath("First Path");
//        path0.addLecture(new Lecture("Co w Javie piszczy ", date, time));
//        path0.addLecture(new Lecture("Vaadin dla opornych", date, time2));
//
//        LecturePath path01 = new LecturePath("Second Path");
//        path01.addLecture(new Lecture("Nie taki Python straszny", date, time));
//        path01.addLecture(new Lecture("", date, time2));
//
//        LecturePath path02 = new LecturePath("Third Path");
//        path02.addLecture(new Lecture("", date, time));
//        path02.addLecture(new Lecture("", date, time2));
//
//        LecturePath path10 = new LecturePath("First Path");
//        path10.addLecture(new Lecture("", date2, time2));
//        path10.addLecture(new Lecture("  ", date2, time2));
//
//        LecturePath path20 = new LecturePath("Second Path");
//        path20.addLecture(new Lecture("", date2, time2));
//        path20.addLecture(new Lecture("", date2, time2));
//
//        LecturePath path30 = new LecturePath("Third Path");
//        path30.addLecture(new Lecture("", date2, time2));
//        path30.addLecture(new Lecture("", date2, time2));
//
//        dayPaths.get(0).set(0, path0);
//        dayPaths.get(0).set(1, path01);
//        dayPaths.get(0).set(2, path02);
//        dayPaths.get(1).set(0, path10);
//        dayPaths.get(1).set(1, path20);
//        dayPaths.get(1).set(2, path30);
//
//    }

    public boolean signIn(int lectureId) {
        if (logged == null) {
            System.out.println("Error! You're not logged in");
            return false;
        }
        for (List<LecturePath> paths : dayPaths) {
            for (LecturePath path : paths) {
                for (Lecture lecture : path.getLectures()) {
                    if (lecture.getId() == lectureId) {
                        return logged.addLecture(lecture);
                    }
                }
            }
        }
        return false;
    }


    public boolean login(String username, String email) {
        if (logged != null) {
            System.out.println("Error! You are already logged! Please log out.");
            return false;
        }
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                if (u.getEmail().equals(email)) {
                    System.out.println("OK!  Logged in successfully as: " + username + "!");
                    logged = u;
                    return true;
                } else {
                    System.out.println("Error! The given login is already taken!");
                    return false;
                }
            }
        }
        System.out.println("OK! Logged in successfully as: " + username);
        User user = new User(username, email);
        users.add(user);
        logged = user;
        return true;
    }

    public boolean logout() {
        if (logged != null) {
            logged = null;
            System.out.println("OK! logged out successfully!");
            return true;
        }
        return false;
    }
    // Wiem, że w vaadinie to tak nie wygląda, ale zrobiłam sobie metody, żeby wyprintować dane w terminalu i zobaczyć, czy w ogóle działa

    public void print() {
        System.out.println("####### PLAN KONFERENCJI #######");
        LocalDate date = startDate;
        for (List<LecturePath> paths : dayPaths) {
            System.out.println("Dzien: " + date);
            printPaths(paths);
            System.out.println();
            date = date.plusDays(1);
        }
    }

    public void printPaths(List<LecturePath> paths) {
        System.out.print("\t  |\t");
        for (LecturePath p : paths) {
            System.out.print(p.getName() + "\t|\t");
        }
        System.out.println();

        int counter = 0;
        LocalTime time = startTime;
        while (!time.isAfter(endTime)) {

            System.out.print(time.toString() + " |\t");
            for (LecturePath p : paths) {
                if (p.getLectures().size() > counter) {
                    Lecture lecture = p.getLectures().get(counter);
                    System.out.print(lecture.getId() + "." + lecture.getName() + "\t\t|\t");
                } else {
                    System.out.print("\t" + "\t|\t");
                }
            }
            System.out.println();
            counter++;

            time = time.plus(Lecture.DURATION).plus(BREAK_TIME);
        }
    }


}
