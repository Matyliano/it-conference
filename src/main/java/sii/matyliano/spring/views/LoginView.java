package sii.matyliano.spring.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import sii.matyliano.spring.MainView;

@Route(value = LoginView.ROUTE)
public class LoginView extends VerticalLayout {

public static final String ROUTE = "login";


    public LoginView() {

        TextField username = new TextField("Username");
        username.setValue("user");

        PasswordField password = new PasswordField("Password");
        password.setValue("password");

        Button submitButton = new Button("Login");

        submitButton.addClickListener( event ->
                UI.getCurrent().navigate(MainView.MAINVIEW));

        add(username,password,submitButton);

    }
    //HAAAA! It's ALIVE! FINALLY!
}
