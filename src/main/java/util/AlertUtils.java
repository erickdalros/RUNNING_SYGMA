package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class AlertUtils {

    public static void mostrarAlerta(String title, String header, String content, AlertType type) {

        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();

    }


    public static void mostrarAlertaWindows(Stage stage, String message) {
        Popup popup = new Popup();

        Label label = new Label(message);
        label.setStyle("-fx-background-radius: 10; " +
                "-fx-background-color: rgba(30,30,30,0.9); " +
                "-fx-text-fill: white; " +
                "-fx-padding: 15px; " +
                "-fx-font-size: 16px;");

        StackPane root = new StackPane(label);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: transparent;");
        root.setPickOnBounds(false);

        popup.getContent().add(root);

        // POSIÇÃO — canto inferior direito
        Scene scene = stage.getScene();
        double x = stage.getX() + scene.getWidth() - 300; // largura até canto direito
        double y = stage.getY() + scene.getHeight() - 120; // altura até canto inferior

        popup.show(stage);
        popup.setX(x);
        popup.setY(y);

        // ANIMAÇÕES
        FadeTransition fadeIn = new FadeTransition(Duration.millis(300), root);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);

        PauseTransition stay = new PauseTransition(Duration.seconds(2));

        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), root);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);

        fadeOut.setOnFinished(e -> popup.hide());

        SequentialTransition sequence = new SequentialTransition(fadeIn, stay, fadeOut);
        sequence.play();
    }

}