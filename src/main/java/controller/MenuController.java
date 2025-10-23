package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.AlertUtils;

public class MenuController {


    @FXML
    private Button Btn1;
    @FXML
    private TextField TxtNumero1;
    @FXML
    private TextField TxtNumero2;

    @FXML
    private Label LabelResultado;

    @FXML
    private Button Btn2;

    public void onBtnSumAction(){
        try {
            double n1 = Double.parseDouble(TxtNumero1.getText());
            double n2 = Double.parseDouble(TxtNumero2.getText());
            double soma = n1 + n2;
            LabelResultado.setText(String.valueOf(soma));

        } catch (NumberFormatException e) {
            AlertUtils.mostrarAlerta("ERRO!", "Erro parcial", e.getMessage(), Alert.AlertType.INFORMATION);
        }

    }

    @FXML
    private void onBtn1Action() {
        AlertUtils.mostrarAlerta("Atenção!", "Você clicou no botão", "Conteúdo", Alert.AlertType.INFORMATION);
        AlertUtils.mostrarAlerta("Atenção!", null, "Conteúdo", Alert.AlertType.INFORMATION);
        System.out.println("Click");


    }


}