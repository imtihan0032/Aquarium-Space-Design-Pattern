package org.aquarium;

public class BaseWreckedShip extends Entity {
    public BaseWreckedShip() {
        this.name = "wrecked ship";
        this.assetPath = App.class.getResource("images/wrecked-ship.png").toExternalForm();

    }
}