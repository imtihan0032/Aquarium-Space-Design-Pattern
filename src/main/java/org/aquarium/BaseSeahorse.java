package org.aquarium;

public class BaseSeahorse extends Entity {
    public BaseSeahorse() {
        this.name = "seahorse";
        this.assetPath = App.class.getResource("images/seahorses.png").toExternalForm();
    }
}