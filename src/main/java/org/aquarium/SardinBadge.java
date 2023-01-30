package org.aquarium;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Popup;

public class SardinBadge extends Badge {

    private static SardinBadge uniqueSardinBadge;

    private SardinBadge(AquariumSpace aquarium) {
        this.aquarium = aquarium;
    }

    public static SardinBadge getInstance(AquariumSpace aquarium){
        if (uniqueSardinBadge == null) {
			System.out.println("Creating unique instance of a badge");
			uniqueSardinBadge = new SardinBadge(aquarium);
		    return uniqueSardinBadge;
		} 
        else {
            return null;
        }
    }

    @Override
    public void printBadgeWithDescription() {
        Image badge = new Image(App.class.getResourceAsStream("/org/aquarium/images/Sardine-Badge.png"));
        ImageView badgeView = new ImageView(badge);
        Popup popup = new Popup();
        Label plabel = new Label();
        Button close = new Button();

        plabel.setMinHeight(350);
        plabel.setMinWidth(650);
        plabel.setStyle("-fx-background-color: #808080; -fx-font-size:25");

        close.setText("Close");
        close.setOnAction(e -> {
            popup.hide();
        });

        popup.getContent().add(plabel);
        popup.getContent().add(close);
        popup.getContent().add(badgeView);
        System.out.println(aquarium.getStage());
        popup.show(aquarium.getStage());
    }
    
}
