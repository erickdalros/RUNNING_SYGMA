package controller;

import dao.Select;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import telas.Telas;
import dao.Insert;

import java.util.ArrayList;
import java.util.List;

public class CadastroCorredorController {

    public String nomeTabela;

    public String sexo;


    @FXML
    private Button MenuPrincipal;

    @FXML
    private Button CadastrarCorredor;

    @FXML
    private TextField NumeroCorredor;

    @FXML
    private TextField NomeCompleto;

    @FXML
    private TextField DataNascimento;

    @FXML
    private TextField DocumentoPessoal;

    @FXML
    private TextField Celular;

    @FXML
    private ComboBox<String> listaBancos;

    @FXML
    private ComboBox<String> Genero;

    @FXML
    public void clearTextField() {
        NumeroCorredor.setText("");
        NomeCompleto.setText("");
        DataNascimento.setText("");
        DocumentoPessoal.setText("");
        Celular.setText("");

    }

    @FXML
    public void initialize() {

        Select select = new Select();

        List<String> nomeTabela = select.selectTabelas();
        listaBancos.setItems(FXCollections.observableArrayList(nomeTabela));
        if (!nomeTabela.isEmpty()) {
            listaBancos.getSelectionModel().selectFirst();
        }
        List<String> sexo = new ArrayList<>();
        Genero.setItems(FXCollections.observableArrayList("Masculino", "Feminino", "Outro"));


    }

    @FXML
    public void GoToMostrarListainitializeDeBancoDeDados() {
        nomeTabela = listaBancos.getValue();
        sexo = Genero.getValue();
        System.out.println("Banco selecionado: " + nomeTabela);
        System.out.println("Gênero selecionado: " + sexo);
    }



    @FXML
    public void GetValuesLabels() {

        //System.out.println(nomeTabela);

        // Coletei os valores dos TextFields
        String numero = NumeroCorredor.getText();
        int numeroInt = Integer.parseInt(numero);
        String nome = NomeCompleto.getText();
        String dataNascimento = DataNascimento.getText();
        String DataNacimentoBanco = dataNascimento.replaceAll("[^0-9]", "");
        String DataNascimentoOficial = null;
        if (DataNacimentoBanco.length() == 8) {
            DataNascimentoOficial = DataNacimentoBanco.substring(4, 8) + DataNacimentoBanco.substring(2, 4) + DataNacimentoBanco.substring(0, 2);
        }
        String documento = DocumentoPessoal.getText();
        int documentoInt = Integer.parseInt(documento);
        String celular = Celular.getText();
        //int celularInt = Integer.parseInt(celular);

        Insert insert = new Insert();
        insert.insertCorredor(numeroInt, nome, DataNacimentoBanco, documentoInt, celular, sexo, nomeTabela);
    }

    public void GoToMenuPricipal() {
        System.out.println("Mudando a scena de nome MenuPrincipal.fxml");
        Stage stage = (Stage) MenuPrincipal.getScene().getWindow();
        Telas.alterarTela(stage, "/view/menu/MenuPrincipal.fxml");
    }

    public void GoToAtualizarLista(){
        System.out.println("Atualizando lista de banco de dados....");
    }



}
