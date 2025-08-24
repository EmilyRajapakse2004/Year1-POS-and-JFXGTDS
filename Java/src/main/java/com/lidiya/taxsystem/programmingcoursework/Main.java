package com.lidiya.taxsystem.programmingcoursework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/lidiya/taxsystem/programmingcoursework/main_view.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        stage.setTitle("Tax Department System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
