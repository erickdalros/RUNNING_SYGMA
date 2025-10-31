package telas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class Telas {

    public static void alterarTela(Stage stage, String caminhoFXML) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(Telas.class.getResource(caminhoFXML), "O FXML NAO EXISTE : " + caminhoFXML));
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
