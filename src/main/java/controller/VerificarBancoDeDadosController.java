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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public void initialize() { // deve ser dado o select aqui

        List<String> list = new ArrayList<>();
        list.add(0,"Corrida01112025");
        list.add(1,"Corrida10112025");
        listaBancos.setItems(FXCollections.observableArrayList(list));
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
   @FXML
    public void GoToCriarBancoDeDados() {

        String nomeBancoDados = NomeBanco.getText().trim();

        if (nomeBancoDados.isEmpty()) {
            AlertUtils.mostrarAlerta("ATENÇÃO", null,
                    "O nome do banco de dados não pode ser vazio", Alert.AlertType.WARNING);
            return;
        }

        if (!nomeBancoDados.endsWith(".db")) {
            nomeBancoDados += ".db";
        }

        String pastaRelativa = "src/main/java/data";
        File pasta = new File(pastaRelativa);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        File arquivoBanco = new File(pasta, nomeBancoDados);
        try {
            if (!arquivoBanco.exists()) {
                boolean criado = arquivoBanco.createNewFile();
                if (criado) {
                    System.out.println("Banco criado em: " + arquivoBanco.getAbsolutePath());
                } else {
                    System.out.println("Banco já existe em: " + arquivoBanco.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            AlertUtils.mostrarAlerta("ERRO", null,
                    "Erro ao criar o banco de dados:\n" + e.getMessage(), Alert.AlertType.ERROR);
            return;
        }

        String url = "jdbc:sqlite:" + arquivoBanco.getAbsolutePath();
        System.out.println("URL do banco: " + url);
    }

    @FXML
    public void GoToAtualizarLista(){
        System.out.println("Atualizando a lista de bancos de dados....");
    }

}
