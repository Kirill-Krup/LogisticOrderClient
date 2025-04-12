package com.courcach.corsewww.Controllers.Client;


import com.courcach.corsewww.Models.Model;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClientController {
    @FXML
    private Button menuBut;

    @FXML
    private Button aboutUsBut;

    @FXML
    private Button backFromAboutUsBut;

    @FXML
    private Button backBut;

    @FXML
    private Button exitBut;

    @FXML
    private Button addNewOrder;

    @FXML
    private Pane mainPane;

    @FXML
    private Pane topPane;

    @FXML
    private Pane aboutUsPane;

    @FXML
    private VBox menuBox;

    @FXML
    private Text homeText;

    public void initialize() {
        menuBox.setMouseTransparent(true);
        menuBut.setOnAction(e -> {
           menuBox.setOpacity(1);
           topPane.setStyle("-fx-background-color: rgba(0,0,0,0.8)");
           mainPane.setStyle("-fx-background-color: rgba(0,0,0,0.8)");
           menuBox.setMouseTransparent(false);
           if(aboutUsPane.getOpacity() == 1){
               aboutUsPane.setOpacity(0);
           }
        });

        //Menu section
        addNewOrder.setOnAction(e -> {
            Stage stage = (Stage) addNewOrder.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showAddNewOrderWindow();
        });

        backBut.setOnAction(e -> {
            menuBox.setOpacity(0);
            menuBox.setMouseTransparent(true);
            topPane.setStyle("-fx-background-color: rgba(0,0,0,0.5)");
            mainPane.setStyle("-fx-background-color: rgba(0,0,0,0.5)");
        });

        aboutUsBut.setOnAction(e -> {
            aboutUsPane.setOpacity(1);
            aboutUsBut.setUnderline(true);
            homeText.setUnderline(false);
        });

        backFromAboutUsBut.setOnAction(e -> {
           aboutUsPane.setOpacity(0);
            aboutUsBut.setUnderline(false);
            homeText.setUnderline(true);
        });

        exitBut.setOnAction(e -> {
            Stage stage = (Stage) menuBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showLoginWindow();
        });
    }
}
