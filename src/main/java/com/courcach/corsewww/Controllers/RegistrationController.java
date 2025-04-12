package com.courcach.corsewww.Controllers;

import com.courcach.corsewww.Models.ConnectionToServer;
import com.courcach.corsewww.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField surnameField;

    @FXML
    private Text errorText;

    @FXML
    private Button registrationBut;

    @FXML
    private Button signInBut;



    public void initialize() {
        signInBut.setOnAction(e -> {
            Stage stage = (Stage) signInBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showLoginWindow();
        });

        registrationBut.setOnAction(e -> {
            String email = emailField.getText();
            String name = nameField.getText();
            String surname = surnameField.getText();
            String login = loginField.getText();
            String password = passwordField.getText();
            if(email.isEmpty() || name.isEmpty() || surname.isEmpty() || login.isEmpty() || password.isEmpty()) {
                errorText.setVisible(true);
                showError("Пожалуйста,заполните все поля");
                return;
            }
            if (!email.contains("@") || !email.contains(".") || email.length() < 5) {
                showError("Неверно введена почта");
                return;
            }
            if (!isValidName(name) || !isValidName(surname)) {
                showError("Имя и фамилия должны содержать только буквы (2-50 символов)");
                return;
            }
            if (login.length() < 5 || login.length() > 20) {
                showError("Логин должен содержать 5-20 символов");
                return;
            }
            if(password.length() < 8 || password.length() > 20) {
                showError("Пароль не может содержать меньше 8 символов");
                return;
            }

            ConnectionToServer connection = new ConnectionToServer();
            connection.connect("localhost", 7777);
            Stage stage = (Stage) registrationBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showClientWindow();


        });
    }

    private void showError(String error) {
        errorText.setVisible(true);
        errorText.setText(error);
    }

    private boolean isValidName(String name) {
        if (name.length() < 2 || name.length() > 50) return false;
        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

}

