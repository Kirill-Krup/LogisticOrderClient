package com.courcach.corsewww.Controllers.Admin;

import com.courcach.corsewww.Models.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditUsersController {
    @FXML
    private Button backBut;
    
    public void initialize() {
        backBut.setOnAction(e -> {
            Stage stage = (Stage) backBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showAdminWindow();
        });
    }
}
