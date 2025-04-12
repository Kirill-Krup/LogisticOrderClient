package com.courcach.corsewww.Controllers.Admin;

import com.courcach.corsewww.Models.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Stack;

public class MarksController {
    @FXML
    private Button backBut;

    public void initialize() {
        backBut.setOnAction(event -> {
            Stage stage = (Stage) backBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showAdminWindow();
        });
    }
}
