package com.vaadin.demo.views;

import com.vaadin.demo.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;

@Route(value = "login-form", layout = MainView.class)
@PageTitle("Login Form")
@Tag("login-form-view")
@JsModule("./src/views/login-form-view.js")
public class LoginFormView extends PolymerTemplate<TemplateModel> {

    @Id("usernameField")
    TextField usernameField;

    @Id("passwordField")
    PasswordField passwordField;

    @Id("loginButton")
    Button loginButton;

    @Id("forgotPasswordButton")
    Button forgotPasswordButton;

    public LoginFormView() {
        loginButton.addClickListener(event -> Notification.show(
                "User '" + usernameField.getValue() + "' clicked login."));
        forgotPasswordButton.addClickListener(
                event -> Notification.show("User '" + usernameField.getValue()
                        + "' clicked forgot password."));
    }
}
