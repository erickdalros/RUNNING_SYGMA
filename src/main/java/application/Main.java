package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/view/menu/MenuPrincipal.fxml"));
            Scene scene = new Scene(parent);
            stage.setTitle("Running Race - Sygma Som e Luz and BinaByte");
            Image icon = new Image(getClass().getResourceAsStream("/img/SYGMASOMELUZ.png"));
            stage.getIcons().add(icon);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
