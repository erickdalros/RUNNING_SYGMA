package controller;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import telas.Telas;
import util.AlertUtils;

import java.util.Optional;

public class GerenciarCorridaController {

    @FXML
    private Button MenuPrincipal;

    @FXML
    private Button Chegou;

    @FXML
    private Button TabelaCorrida;

    @FXML
    private TextField numeroCorredorFXML;

    @FXML
    private Button finalizarCorridaAction;

    @FXML
    private Label labelCronometro;

    private long iniciarTempo;
    private AnimationTimer timer;
    public String tempoFormatado;

    public void iniciarCronometro() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("INICIAR CRONÔMENTRO");
        alert.setHeaderText("VOCÊ REALMENTE DESEJA INICIAR O CRONÔMETRO?");
        alert.setContentText("Caso o cronômetro já foi iniciado e você inicar novamente ele reseta.");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            iniciarTempo = System.nanoTime();

            timer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    long elapsed = now - iniciarTempo;

                    long millis = (elapsed / 1_000_000) % 1000;
                    long seconds = (elapsed / 1_000_000_000) % 60;
                    long minutes = (elapsed / (60L * 1_000_000_000)) % 60;
                    long hours = elapsed / (3600L * 1_000_000_000);

                    tempoFormatado = String.format("%02d : %02d : %02d : %03d",
                            hours, minutes, seconds, millis);

                    labelCronometro.setText(tempoFormatado);
                }
            };
            timer.start();

        } else {
            System.out.println("Cronometro não foi inciado, usuario cliclou em cancelar");
        }
    }

    public void finalizarCorridaAction() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("ESCOLHA UMA AÇÃO DO CRONÔMETRO");
        alert.setHeaderText("VOCÊ QUER PAUSAR O CRONÔMETRO OU SEGUIR?");
        alert.setContentText("Esta ação não pode ser desfeita.");

        ButtonType pausar = new ButtonType("PAUSAR");
        ButtonType continuar = new ButtonType("CONTINUAR");

        alert.getButtonTypes().setAll(pausar, continuar);

        alert.showAndWait().ifPresent(response -> {
            if (response == pausar) {
                timer.stop();
            } else {
                timer.start();
            }
        });
    }

    public void GoToMenuPrincipal() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("RETORNAR AO MENU PRINCIAL?");
        alert.setHeaderText("VOCÊ DESEJA RETORNAR AO MENU?");
        alert.setContentText("Se retornar ao menu princiapl vc perderá todo o progresso...");

        ButtonType sim = new ButtonType("Sim, retornar ao menu");
        ButtonType nao = new ButtonType("Não, desejo ficar aqui");

        alert.getButtonTypes().setAll(sim, nao);

        alert.showAndWait().ifPresent(response -> {
            if (response == sim) {
                Stage stage = (Stage) MenuPrincipal.getScene().getWindow();
                Telas.alterarTela(stage, "/view/menu/MenuPrincipal.fxml");
            } else {
                System.out.println("Não retornou ao menu principal");
            }
        });

    }

    public void GoToChegou() {
        String numeroCorredor = numeroCorredorFXML.getText();
        if(numeroCorredor.isEmpty()) {
            String numero = numeroCorredorFXML.getText();
            AlertUtils.mostrarAlertaWindows((Stage) Chegou.getScene().getWindow(), "O campo número do corredor não pode estar vazio");
        } else {
            System.out.println("Corredor de número " + numeroCorredor + " chegou com um tempo de " + tempoFormatado);
        }


    }

    public void GoToTabelaCorrida() {
        System.out.println("Tabela de corredores");
    }
}