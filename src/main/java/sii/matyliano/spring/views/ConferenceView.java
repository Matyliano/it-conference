package sii.matyliano.spring.views;

import com.vaadin.flow.router.Route;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import sii.matyliano.spring.entity.Conference;


@Route(value = ConferenceView.CONFERENCE)
public class ConferenceView {

    public static final String CONFERENCE = "conference";


    protected void init(VaadinRequest vaadinRequest) {

        VerticalLayout content = new VerticalLayout();
        content.setSizeFull();

        content.addComponent(new Label("<b>Welcome!!  </b>"));

        Grid<Conference> grid = new Grid<>();
        grid.setCaption("My Grid");
        grid.setItems(new Conference());
        grid.setSizeFull();
        content.addComponent(grid);
        content.setExpandRatio(grid, 1);

    }
}
