package sii.matyliano.spring.views;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = MainView.MAINVIEW)
public class MainView extends VerticalLayout {


    public static final String MAINVIEW = "main";

    public MainView(@Autowired MessageBean bean) {


        Button button = new Button("Click me",
                e -> Notification.show(bean.getMessage()));
        add(button);
    }

}
