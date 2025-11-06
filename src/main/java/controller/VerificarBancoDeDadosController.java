package controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import telas.Telas;
import util.AlertUtils;
import dao.Create;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.Select;


public class VerificarBancoDeDadosController {


    @FXML
    private Button MenuPrincipal;

    @FXML
    private Button CriarBancoDeDados;

    @FXML
    private Button AtualizarLista;

    @FXML
    public TextField NomeBanco;

    @FXML
    private ComboBox<String> listaBancos;

    @FXML
    public void criarBancoDeDados() { /* da um erro mas cria a tabela */
        String nome = NomeBanco.getText();
        Create create = new Create();
        try {
            create.criarTabelaDefault(nome);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void initialize() {

        Select select = new Select();

        List<String> nomeTabela = select.selectTabelas();
        listaBancos.setItems(FXCollections.observableArrayList(nomeTabela));
        if (!nomeTabela.isEmpty()) {
            listaBancos.getSelectionModel().selectFirst();
        }
    }

    @FXML
    public void GoToMostrarListainitializeDeBancoDeDados() {
        String valorSelecionado = listaBancos.getValue();
        System.out.println("Banco selecionado: " + valorSelecionado);
    }

    @FXML
    public void GoToMenuPrincipal(){
        System.out.println("Mudando a scena de nome MenuPrincipal.fxml");
        Stage stage = (Stage) MenuPrincipal.getScene().getWindow();
        Telas.alterarTela(stage, "/view/menu/MenuPrincipal.fxml");
    }


}
