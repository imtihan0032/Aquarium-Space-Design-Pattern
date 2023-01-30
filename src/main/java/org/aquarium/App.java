package org.aquarium;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    AquariumSpace aquariumSpace;

    @Override
    public void start(Stage stage) throws IOException {
        aquariumSpace = new AquariumSpace(stage);
        aquariumSpace.startAquarium();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        aquariumSpace.stopAquarium();
    }

    public static void main(String[] args) {
        launch();
    }
}