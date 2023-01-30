module org.aquarium {
    requires transitive javafx.controls;
    requires transitive javafx.graphics;
    requires transitive javafx.media;
    requires javafx.fxml;

    opens org.aquarium to javafx.fxml;

    exports org.aquarium;
}