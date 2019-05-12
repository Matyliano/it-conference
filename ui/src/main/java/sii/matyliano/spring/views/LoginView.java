package sii.matyliano.spring.views;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.navigator.View;
import com.vaadin.ui.LoginForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Route(value = LoginView.ROUTE)
@PageTitle("Login")
//@HtmlImport("frontend://bower_components/iron-form/iron-form.html")
public class LoginView extends LoginForm implements View {

public static final String ROUTE = "login";

private static final Logger logger = LoggerFactory.getLogger(LoginView.class);





}
