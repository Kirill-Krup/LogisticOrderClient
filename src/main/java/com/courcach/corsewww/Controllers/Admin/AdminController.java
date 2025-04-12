package com.courcach.corsewww.Controllers.Admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.courcach.corsewww.Models.Model;

public class AdminController {

    @FXML
    private Button checkOrdersBut;

    @FXML
    private Button editUsersBut;

    @FXML
    private Button marksBut;

    @FXML
    private Button exitBut;

    public void initialize() {
        checkOrdersBut.setOnAction((event) -> {
            Stage stage = (Stage) checkOrdersBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showOrdersForAdminWindow();
        });

        editUsersBut.setOnAction((event) -> {
            Stage stage = (Stage) editUsersBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showEditUsersWindow();
        });

        marksBut.setOnAction((event) -> {
           Stage stage = (Stage) marksBut.getScene().getWindow();
           Model.getInstance().getViewFactory().closeStage(stage);
           Model.getInstance().getViewFactory().showMarksWindow();
        });

        exitBut.setOnAction((event) -> {
            Stage stage = (Stage) exitBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showLoginWindow();
        });
    }
}
