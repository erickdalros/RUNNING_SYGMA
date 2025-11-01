package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import telas.Telas;

public class GerenciarCorridaController {

    @FXML
    private Button MenuPrincipal;

    @FXML
    private Button Chegou;

    @FXML
    private Button TabelaCorrida;


    public void GoToMenuPrincipal() {
        System.out.println("Mudando a scena de nome MenuPrincipal.fxml");
        Stage stage = (Stage) MenuPrincipal.getScene().getWindow();
        Telas.alterarTela(stage, "/view/menu/MenuPrincipal.fxml");
    }

    public void GoToChegou() {
        System.out.println("Corredor Chegou");
    }

    public void GoToTabelaCorrida() {
        System.out.println("Tabela de corredores");
    }

}
