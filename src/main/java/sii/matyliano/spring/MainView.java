package sii.matyliano.spring;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

@Route
@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Project Base")
public class MainView extends VerticalLayout {

    public MainView(@Autowired MessageBean bean) {

       // new TextField();
        Button button = new Button("Click me",
                e -> Notification.show(bean.getMessage()));
        add(button);
    }
//   PasswordField ps1 = new PasswordField();
//    public MainView(){
//        FormLayout form = new FormLayout();
//
//        TextField tf1 = new TextField("FirstName");
//
//        tf1.setRequiredIndicatorVisible(true);
//        form.addComponent(tf1);
//
//        TextField tf2 = new TextField("LastName");
//
//        form.addComponent(tf2);
//
//        TextField tf3 = new TextField("Email");
//
//        form.addComponent(tf3);
//
//
//        ps1.setMaxLength(12);
//        ps1.setRequiredIndicatorVisible(true);
//        updateCaption(0);
//        ps1.addValueChangeListener(event ->updateCaption(event.getValue().length()));)
//        form.addComponent(ps1);
//
//
//}
//
//    private void updateCaption(final int textLength) {
//        final StringBuilder builder = new StringBuilder();
//        builder.append(textLength);
//        if (ps1.getMaxLength() >= 0) {
//            builder.append("/").append(ps1.getMaxLength());
//        }
//        builder.append(" characters");
//        ps1.setCaption(builder.toString());
//    }
//        ps1.addValueChangeListener(event -> Notification.show("Value changed:",
//            String.valueOf(event.getValue(),Type.TRAY_NOTIFICATION)));
}
