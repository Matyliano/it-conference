package sii.matyliano.spring.backend.controller;



import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;


import org.springframework.beans.factory.annotation.Autowired;
import sii.matyliano.spring.backend.repository.UserRepository;
import sii.matyliano.spring.entity.User;


@SpringComponent
@UIScope
public class UserEditor extends VerticalLayout implements KeyNotifier {

    private final UserRepository repository;


    //the currently edited user
    private User user;

    //field to edit
    TextField email = new TextField("Email");

    //action buttons
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");

    HorizontalLayout actions = new HorizontalLayout(save, cancel);

    Binder<User> binder = new Binder<>(User.class);
    private ChangeHandler changeHandler;

    @Autowired
    public UserEditor(UserRepository repository) {
        this.repository = repository;

        add(email, actions);

        // bind using naming convention
        binder.bindInstanceFields(this);

        // Configure and style components
        setSpacing(true);

        save.getElement().getThemeList().add("primary");

        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());

        cancel.addClickListener(e -> editUser(user));
        setVisible(false);
    }

    private void save() {
        repository.save(user);
        changeHandler.onChange();
    }

    private final void editUser(User u) {

        if (u == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = u.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            user = repository.findById(u.getId()).get();
        } else {
            user = u;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(user);

        setVisible(true);

        // Focus email initially
        email.focus();


    }

    public interface ChangeHandler {
        void onChange();
    }

    public void setChangeHandler(ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }

}
