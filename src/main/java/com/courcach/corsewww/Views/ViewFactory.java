package com.courcach.corsewww.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {

    // SignIn SignUp Windows
    public  void showLoginWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(fxmlLoader);
    }

    public  void showRegistrationWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/registration.fxml"));
        createStage(fxmlLoader);
    }


    // Admin Section
    public  void showAdminWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
        createStage(fxmlLoader);
    }

    public  void showOrdersForAdminWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/CheckOrders.fxml"));
        createStage(fxmlLoader);
    }

    public  void showEditUsersWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/EditUsers.fxml"));
        createStage(fxmlLoader);
    }

    public  void showMarksWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Marks.fxml"));
        createStage(fxmlLoader);
    }


    // Client section
    public  void showClientWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        createStage(fxmlLoader);
    }

    public  void showAddNewOrderWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Client/AddNewOrder.fxml"));
        createStage(fxmlLoader);
    }

    public  void showCheckUserHistoryWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Client/CheckUserHistory.fxml"));
        createStage(fxmlLoader);
    }

    public  void showCheckMyOrderWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Client/CheckMyOrder.fxml"));
        createStage(fxmlLoader);
    }



    // Employee section
    public  void showEmployeeWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Employee/Employee.fxml"));
        createStage(fxmlLoader);
    }

    // Methods for open and close stages
    private void createStage(FXMLLoader fxmlLoader) {
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setTitle("LogisticOrder");
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
