package controller;


import dao.Select;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import telas.Telas;
import model.Corredor;
import javafx.scene.control.TableColumn;
import java.util.ArrayList;
import java.util.List;

public class TabelaCorredoresController {

    public String nomeTabela;

    @FXML
    private Button MenuPrincipal;
    @FXML
    private ComboBox<String> listaBancos;
    @FXML
    private TableView<Corredor> listaCorredores;
    @FXML
    private TableColumn<Corredor, String> colId;
    @FXML
    private TableColumn<Corredor, String> colNumero;
    @FXML
    private TableColumn<Corredor, String> colNome;
    @FXML
    private TableColumn<Corredor, String> colNascimento;
    @FXML
    private TableColumn<Corredor, String> colDocumento;
    @FXML
    private TableColumn<Corredor, String> colCelular;
    @FXML
    private TableColumn<Corredor, String> colSexo;
    @FXML
    private TableColumn<Corredor, String> colGrupo;
    @FXML
    private TableColumn<Corredor, String> colTempo;
    @FXML
    private TableColumn<Corredor, String> colPace;
    @FXML
    private TableColumn<Corredor, String> colPosicao;
    @FXML
    private TableColumn<Corredor, String> colDel;



    @FXML
    public void initialize() {
        Select select = new Select();
        listaCorredores.setEditable(true);

        // Configura colunas do TableView
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colNome.setCellFactory(TextFieldTableCell.forTableColumn());
        colNome.setOnEditCommit(event -> {
            Corredor updateDado = event.getRowValue();
            updateDado.setNome(event.getNewValue());
            System.out.println("Novo dado atualizado: " + updateDado.getNome());

        });
        colNascimento.setCellValueFactory(new PropertyValueFactory<>("nascimento"));
        colDocumento.setCellValueFactory(new PropertyValueFactory<>("documento"));
        colCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colGrupo.setCellValueFactory(new PropertyValueFactory<>("grupo"));
        colTempo.setCellValueFactory(new PropertyValueFactory<>("tempo"));
        colPace.setCellValueFactory(new PropertyValueFactory<>("pace"));
        colPosicao.setCellValueFactory(new PropertyValueFactory<>("posicao"));

        List<String> nomesTabelas = select.selectTabelas();
        listaBancos.setItems(FXCollections.observableArrayList(nomesTabelas));


    }


    @FXML
    public void carregartabela() {
        if (nomeTabela == null || nomeTabela.isEmpty()) {
            System.out.println("Nenhuma tabela selecionada.");
            return;
        }

        Select select = new Select();
        ArrayList<Corredor> corredores = select.listaCorredores(nomeTabela);
        ObservableList<Corredor> listaObservable = FXCollections.observableArrayList(corredores);
        listaCorredores.setItems(listaObservable);

        System.out.println("Tabela carregada com " + corredores.size() + " corredores.");
    }


    @FXML
    public void GoToMostrarListainitializeDeBancoDeDados() {
        nomeTabela = listaBancos.getValue();
        System.out.println("Banco selecionado: " + nomeTabela);
    }

    @FXML
    public void GoToMenuPrincipal(){
        System.out.println("Mudando a scena de nome MenuPrincipal.fxml");
        Stage stage = (Stage) MenuPrincipal.getScene().getWindow();
        Telas.alterarTela(stage, "/view/menu/MenuPrincipal.fxml");

    }

    @FXML
    public void GoToTabelaCorrida(){
        nomeTabela = listaBancos.getValue();
        System.out.println("Banco selecionado: " + nomeTabela);
        carregartabela();
    }



}
