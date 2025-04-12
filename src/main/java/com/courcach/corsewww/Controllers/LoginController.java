package com.courcach.corsewww.Controllers;

import com.courcach.corsewww.Models.ConnectionToServer;
import com.courcach.corsewww.Models.Model;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LoginController {
    @FXML
    private Button signUpBut;

    @FXML
    private Button enterBut;

    @FXML
    private Text errorLabel;

    @FXML
    private TextField loginInput;

    @FXML
    private TextField passwordInput;

    public void initialize() {
        signUpBut.setOnAction(e -> {
            Stage stage = (Stage) signUpBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showRegistrationWindow();
        });

        enterBut.setOnAction(e -> {
            String login = loginInput.getText();
            String password = passwordInput.getText();
            if(login.isEmpty() || password.isEmpty()) {
                showError("Пожалуйста, заполните все поля");
                return;
            }
            try {
                ConnectionToServer connection = new ConnectionToServer();
                connection.connect("localhost", 7777);
                String role = connection.authenticate(login, password);
                if (role == null) {
                    showError("Неверно введён логин или пароль");
                    return;
                }
                Stage stage = (Stage) enterBut.getScene().getWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
                switch (role){
                    case "admin":
                        Model.getInstance().getViewFactory().showAdminWindow();
                        break;
                    case "employee":
                        Model.getInstance().getViewFactory().showEmployeeWindow();
                        break;
                    case "client":
                        Model.getInstance().getViewFactory().showClientWindow();
                        break;
                }
            }catch (IOException | ClassNotFoundException ex) {
                showError("Ошибка подключения к серверу");
                ex.printStackTrace();
            }
        });
    }
    private void showError(String error) {
        errorLabel.setVisible(true);
        errorLabel.setText(error);
    }
}