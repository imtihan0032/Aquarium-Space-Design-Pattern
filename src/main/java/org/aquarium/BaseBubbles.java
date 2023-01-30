package org.aquarium;

public class BaseBubbles extends Entity {
    public BaseBubbles() {
        this.name = "bubbles";
        this.assetPath = App.class.getResource("images/bubbles.png").toExternalForm();
    }
}