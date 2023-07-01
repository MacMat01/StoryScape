package it.unicam.cs.storyscape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Main class of the application.
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/app.fxml")));

        primaryStage.setTitle("StoryScape");
        primaryStage.setScene(new javafx.scene.Scene(root, 1280, 720));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}