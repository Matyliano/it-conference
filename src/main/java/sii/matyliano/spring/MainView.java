package sii.matyliano.spring;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.navigator.ViewChangeListener;
import sii.matyliano.spring.views.LoginView;


@Route(value = MainView.MAINVIEW)
public class MainView extends VerticalLayout {


    public static final String MAINVIEW = "main";


    public MainView() {


        Button button = new Button("Go to login page");
        button.addClickListener(event ->
                UI.getCurrent().navigate(LoginView.ROUTE));

        add(button);

        Button button2 = new Button("Go deeper");
//        button2.addClickListener(event ->
//              //  UI.getCurrent().navigate(ConferenceView.CONFERENCE));
//        );
        add(button2);

        setSizeFull();
        setMargin(false);


    }

    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    //Grid, żeby tu wyświetlić listę ścieżek

}
