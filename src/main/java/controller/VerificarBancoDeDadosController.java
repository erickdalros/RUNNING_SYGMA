package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import telas.Telas;


public class VerificarBancoDeDadosController {


    @FXML
    private Button MenuPrincipal;

    @FXML
    private Button CriarBancoDeDados;

    @FXML
    private Button AtualizarLista;

    public void GoToMenuPrincipal(){
        System.out.println("Mudando a scena de nome MenuPrincipal.fxml");
        Stage stage = (Stage) MenuPrincipal.getScene().getWindow();
        Telas.alterarTela(stage, "/view/menu/MenuPrincipal.fxml");
    }

    public void GoToCriarBancoDeDados(){
        System.out.println("Banco de dados criado ou não!");
    }

    public void GoToAtualizarLista(){
        System.out.println("Atualizando a lista de bancos de dados....");
    }

}
