package sii.matyliano.spring;




import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import sii.matyliano.spring.views.LoginView;


@Route(value = MainView.MAINVIEW)
public class MainView extends VerticalLayout {


    public static final String MAINVIEW = "main";

    public MainView() {

        Image image = new Image("batman.png","Batman");
        image.setWidth("300px");
        Button button = new Button("Go to login page");
        button.addClickListener( event ->
                UI.getCurrent().navigate(LoginView.ROUTE));

        add(image,button);

    }

}
