package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import telas.Telas;

public class CadastroCorredorController {

    @FXML
    private Button MenuPrincipal;

    @FXML
    private Button AtualizarLista;

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
    private TextField Email;

    @FXML
    private TextField Celular;


    @FXML
    public void GetValuesLabels() {
        // Coletei os valores dos TextFields
        String numero = NumeroCorredor.getText();
        String nome = NomeCompleto.getText();
        String dataNascimento = DataNascimento.getText();
        String DataNacimentoBanco = dataNascimento.replaceAll("[^0-9]", "");
        String DataNascimentoOficial = null;
        if (DataNacimentoBanco.length() == 8) {
            DataNascimentoOficial = DataNacimentoBanco.substring(4, 8) + DataNacimentoBanco.substring(2, 4) + DataNacimentoBanco.substring(0, 2);
        }
        String documento = DocumentoPessoal.getText();
        String email = Email.getText();
        String celular = Celular.getText();

        System.out.println("Numero: " + numero);
        System.out.println("Nome: " + nome);
        System.out.println("DataNascimento: " + DataNascimentoOficial);
        System.out.println("DocumentoPessoal: " + documento);
        System.out.println("Email: " + email);
        System.out.println("Celular: " + celular);


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
