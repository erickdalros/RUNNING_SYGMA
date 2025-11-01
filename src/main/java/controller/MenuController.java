package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import telas.Telas;
import util.AlertUtils;

public class MenuController {

     Telas telas = new Telas();

    @FXML
    private Button VerificarBancoDeDados;

    @FXML
    private Button CadastroCorredores;

    @FXML
    private Button GerenciarCorrida;

    @FXML
    private Button TabelaCorredores;

    @FXML
    private Button Api;

    @FXML
    private void GoToVerificarBancoDeDados(ActionEvent event) {
        System.out.println("Mudando a scena de nome VerificarBancoDeDados.fxml");
        Stage stage = (Stage) VerificarBancoDeDados.getScene().getWindow();
        Telas.alterarTela(stage, "/view/banco/VerificarBancoDeDados.fxml");
    }

    @FXML
    private void GoToCadastroCorredores() {
        System.out.println("Mudando a scena de nome CadastroCorredorView.fxml");
        Stage stage = (Stage) CadastroCorredores.getScene().getWindow();
        Telas.alterarTela(stage, "/view/cadastro/CadastroCorredorView.fxml");
    }

    @FXML
    private void GoToGerenciarCorrida() {
        System.out.println("Mudando a scena de nome GerenciarCorridaView.fxml");
        Stage stage = (Stage) GerenciarCorrida.getScene().getWindow();
        Telas.alterarTela(stage, "/view/corrida/GerenciarCorridaView.fxml");
    }

    @FXML
    private void GoToTabelaCorredores() {
        System.out.println("Mudando a scena de nome TabelaCorredoresView.fxml");
        Stage stage = (Stage) GerenciarCorrida.getScene().getWindow();
        Telas.alterarTela(stage, "/view/corrida/TabelaCorredoresView.fxml");
    }

    @FXML
    private void GoToApi() {
        System.out.println("Aqui será feito a implementação do sistema web com API - https:sygmarunning.netfly.com");
        AlertUtils.mostrarAlerta("Alerta!", null, "Estamos na versão beta... ainda não disponível para usuário comum.... Pedimos paciência enquato desenvolvemos..", Alert.AlertType.WARNING);
    }
}