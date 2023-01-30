package org.aquarium;

public class BaseCrab extends Entity {
    public BaseCrab() {
        this.name = "crab";
        this.assetPath = App.class.getResource("images/crabs.png").toExternalForm();
    }
}