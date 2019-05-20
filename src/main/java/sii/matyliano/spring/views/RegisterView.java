package sii.matyliano.spring.views;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.ui.Panel;

@Route(value = RegisterView.REGISTER)
public class RegisterView {

    public static final String REGISTER = "register";

    private VerticalLayout root;
    private Panel panel;
    private TextField username;
    private TextField email;
    private TextField confirmEmail;
    private PasswordField password;
    private PasswordField confirmPassword;
    private Button register;
    private Button back;


    public RegisterView() {
        root = new VerticalLayout();
        root.setMargin(true);
        root.setHeight("100%");

        panel = new Panel("Register");
        panel.setSizeUndefined();

        username = new TextField("Username");
        username.setValue("user");

        email = new TextField("Email");
        confirmEmail = new TextField("Confirm Email");

        password = new PasswordField("Password");
        password.setValue("password");

        confirmPassword = new PasswordField("Confirm Password");
        confirmPassword.setValue("password");
        addButtons();

    }

    public void addButtons() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        register = new Button("Register");
        back = new Button("Back");
        buttonLayout.add(register, back);
    }

}
