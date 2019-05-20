package sii.matyliano.spring.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.ui.Panel;
import sii.matyliano.spring.MainView;

@Route(value = LoginView.ROUTE)
public class LoginView extends VerticalLayout {

    public static final String ROUTE = "login";

    private VerticalLayout root;
    private Panel panel;
    private TextField username;
    private PasswordField password;
    private Button login;
    private Button register;


    public LoginView() {

        root = new VerticalLayout();
        root.setMargin(true);
        root.setHeight("100%");

        panel = new Panel("Login");
        panel.setSizeUndefined();

        username = new TextField("Username");
        username.setValue("user");

        password = new PasswordField("Password");
        password.setValue("password");

        login = new Button("Login");
        register = new Button("register");

        login.addClickListener(event ->
                UI.getCurrent().navigate(MainView.MAINVIEW));

        register.addClickListener(event ->
                UI.getCurrent().navigate(RegisterView.REGISTER));

        add(username, password, login, register);

    }
    //HAAAA! It's ALIVE! FINALLY!
}
