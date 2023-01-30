package org.aquarium;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Popup;

public class ArapaimaBadge extends Badge{

    private static ArapaimaBadge uniqueArapaimaBadge;

    private ArapaimaBadge(AquariumSpace aquarium) {
        this.aquarium = aquarium;
    }

    public static ArapaimaBadge getInstance(AquariumSpace aquarium){
        if (uniqueArapaimaBadge == null) {
			System.out.println("Creating unique instance of a badge");
			uniqueArapaimaBadge = new ArapaimaBadge(aquarium);
            return uniqueArapaimaBadge;
		}
        else {
            return null;
        }
    }

    @Override
    public void printBadgeWithDescription() {
        Image badge = new Image(App.class.getResourceAsStream("/org/aquarium/images/Arapaima-Badge.png"));
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
