package sii.matyliano.spring.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.navigator.Navigator;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = LoginView.ROUTE)
@PageTitle("Login")
@HtmlImport("frontend://bower_components/iron-form/iron-form.html")
public class LoginView extends VerticalLayout {

public static final String ROUTE = "login";


Navigator navigator;

    public LoginView() {
        TextField userNameTextField = new TextField("Username");
        userNameTextField.getElement().setAttribute("name", "username"); //
        PasswordField passwordField = new PasswordField("Password");
        passwordField.getElement().setAttribute("name", "password"); //
        Button submitButton = new Button("Login");
        submitButton.setId("submitbutton"); //
        UI.getCurrent().getPage().executeJavaScript("document.getElementById('submitbutton').addEventListener('click', () => document.getElementById('ironform').submit());"); //

        FormLayout formLayout = new FormLayout(); //
        formLayout.add(userNameTextField, passwordField, submitButton);

        Element formElement = new Element("form"); //
        formElement.setAttribute("method", "post");
        formElement.setAttribute("action", "login");
        formElement.appendChild(formLayout.getElement());

        Element ironForm = new Element("iron-form"); //
        ironForm.setAttribute("id", "ironform");
        ironForm.setAttribute("allow-redirect", true); //
        ironForm.appendChild(formElement);

        getElement().appendChild(ironForm); //

        setClassName("login-view");
    }



}
