package sii.matyliano.spring.views;

import com.vaadin.flow.router.Route;
import com.vaadin.ui.Grid;
import sii.matyliano.spring.entity.Lecture;
import sii.matyliano.spring.entity.LecturePath;
import sii.matyliano.spring.entity.User;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


@Route(value = ConferenceView.CONFERENCE)
public class ConferenceView {

    public static final String CONFERENCE = "conference";

    private LocalDate startDate;
    private LocalDate endDate;

    private LocalTime startTime;
    private LocalTime endTime;


    private List<List<LecturePath>> dayPaths = new ArrayList<List<LecturePath>>();

    private List<User> users = new ArrayList<>();

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

        dayPaths.get(0).set(0, path0);
        dayPaths.get(0).set(1, path01);
        dayPaths.get(0).set(2, path02);
        dayPaths.get(1).set(0, path10);
        dayPaths.get(1).set(1, path20);
        dayPaths.get(1).set(2, path30);

    }

    public ConferenceView() {

        Grid<LecturePath> grid = new Grid<>(LecturePath.class);
        grid.setItems((Stream<LecturePath>) dayPaths);

    }


//    protected void init(VaadinRequest vaadinRequest) {
//
//        VerticalLayout content = new VerticalLayout();
//        content.setSizeFull();
//
//        content.addComponent(new Label("<b>Welcome!!  </b>"));
//
//        Grid<Conference> grid = new Grid<>();
//        grid.setCaption("My Grid");
//        grid.setItems(new Conference());
//        grid.setSizeFull();
//        content.addComponent(grid);
//        content.setExpandRatio(grid, 1);
//
//    }
}
