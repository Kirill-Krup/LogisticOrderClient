package com.courcach.corsewww.Controllers.Client;

import com.courcach.corsewww.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Objects;

public class AddNewOrderController {
    @FXML
    private Button backFromFirstBut;

    @FXML
    private Button deleteBut;

    @FXML
    private TextField adressTextField;

    @FXML
    private TextField fio;

    @FXML
    private TextField phone;

    @FXML
    private Text redStar;

    @FXML
    private ComboBox<String> selectAdress;

    @FXML
    private ComboBox<String> selectTypeOfDelivery;

    public void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList("Самовывоз", "Доставка");
        ObservableList<String> adresses = FXCollections.observableArrayList("ул. Ленина 10, ТЦ Столица, 1 этаж", "пр. Независимости 46, ТЦ Галерея, 2ой этаж", "ул. Притыцкого 156, ТЦ Тивали, 2 этаж", "ул. Кальварийская 6, ТЦ Экспобел", "ул. Янки Купалы 17, ТЦ Европа, -1 этаж");
        selectTypeOfDelivery.setItems(items);
        selectAdress.setItems(adresses);

        backFromFirstBut.setOnAction(event -> {
            Stage stage = (Stage) backFromFirstBut.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            Model.getInstance().getViewFactory().showClientWindow();
        });

        deleteBut.setOnAction(event -> {

           fio.setText("");
           phone.setText("");
        });

        selectTypeOfDelivery.setOnAction(event -> {
            if(Objects.equals(selectTypeOfDelivery.getValue(), "Доставка")) {
                adressTextField.setOpacity(1);
                adressTextField.setMouseTransparent(false);
                redStar.setOpacity(1);
                if(selectAdress.getOpacity() == 1) {
                    selectAdress.setOpacity(0);
                    selectAdress.setMouseTransparent(true);
                }
            }
            else if (Objects.equals(selectTypeOfDelivery.getValue(),"Самовывоз")){
                selectAdress.setOpacity(1);
                selectAdress.setMouseTransparent(false);
                redStar.setOpacity(1);
                if(adressTextField.getOpacity() == 1) {
                    adressTextField.setOpacity(0);
                    adressTextField.setMouseTransparent(true);
                }
            }
        });




    }
}
