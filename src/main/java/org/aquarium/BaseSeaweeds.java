package org.aquarium;

public class BaseSeaweeds extends Entity {
    public BaseSeaweeds() {
        this.name = "seaweeds";
        this.assetPath = App.class.getResource("images/seaweeds.png").toExternalForm();

    }
}