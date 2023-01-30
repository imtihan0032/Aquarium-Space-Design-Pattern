package org.aquarium;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

import javafx.scene.media.Media;

public class Space extends StackPane {
    private ArrayList<EntityImageViewAdapter> entities = new ArrayList<EntityImageViewAdapter>();
    private ArrayList<ImageView> badges = new ArrayList<ImageView>();
    Popup badgeListPopup = new Popup();
    private EntityImageViewAdapter fish;
    AquariumSpace aquarium;
    Media pick;// replace this with your own audio file
    MediaPlayer player;
    int countArapaima = 0; 
    int countMackerel = 0;
    int countSardine = 0;
    int countTilapia = 0;
    int countToman = 0;

    public Space(AquariumSpace aquarium) {
        this.pick = new Media(getClass().getResource("music/bgmusic.mp3").toExternalForm());
        player = new MediaPlayer(pick);
        player.setAutoPlay(false);
        this.aquarium = aquarium;
        this.initializeBackground();
        this.initializeEntities();
        this.initializeBadges();
        this.initializeBadgeListPopup();
        System.out.print(player.getStatus().equals(Status.PLAYING));
    }

    public void initializeBackground() {
        Image image = new Image(App.class.getResource("images/background.png").toExternalForm());
    
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(backgroundImage));
    }

    public void initializeEntities() {
        this.initializeEntities(new BaseEntityFactory());
    }

    public void initializeEntities(EntityFactory entityFactory) {
        EntityImageViewAdapter bubbles = new EntityImageViewAdapter(entityFactory.createBubblesEntity()); // index 0
        EntityImageViewAdapter ship = new EntityImageViewAdapter(entityFactory.createWreckedShipEntity()); // index 1
        EntityImageViewAdapter crab = new EntityImageViewAdapter(entityFactory.createCrabsEntity()); // index 2
        EntityImageViewAdapter seahorse = new EntityImageViewAdapter(entityFactory.createSeahorsesEntity()); // index 3
        EntityImageViewAdapter seaweed = new EntityImageViewAdapter(entityFactory.createSeaweedsEntity()); // index 4

        this.entities.add(bubbles);
        this.entities.add(ship);
        this.entities.add(crab);
        this.entities.add(seahorse);
        this.entities.add(seaweed);

        entities.forEach((entity) -> entity.setVisible(false));

        this.getChildren().addAll(entities);
    }

    public void initializeBadges() {
        Image arapaima = new Image(App.class.getResourceAsStream("/org/aquarium/images/Arapaima-Badge.png"));
        ImageView arapaimaView = new ImageView(arapaima);
        arapaimaView.setFitHeight(200);
        arapaimaView.setFitWidth(400);

        Image mackerel = new Image(App.class.getResourceAsStream("/org/aquarium/images/Mackerel-Badge.png"));
        ImageView mackerelView = new ImageView(mackerel);
        mackerelView.setFitHeight(200);
        mackerelView.setFitWidth(400);

        Image sardin = new Image(App.class.getResourceAsStream("/org/aquarium/images/Sardine-Badge.png"));
        ImageView sardinView = new ImageView(sardin);
        sardinView.setFitHeight(200);
        sardinView.setFitWidth(400);

        Image tilapia = new Image(App.class.getResourceAsStream("/org/aquarium/images/Tilapia-Badge.png"));
        ImageView tilapiaView = new ImageView(tilapia);
        tilapiaView.setFitHeight(200);
        tilapiaView.setFitWidth(400);

        Image toman = new Image(App.class.getResourceAsStream("/org/aquarium/images/Toman-Badge.png"));
        ImageView tomanView = new ImageView(toman);
        tomanView.setFitHeight(200);
        tomanView.setFitWidth(400);

        this.badges.add(arapaimaView);
        this.badges.add(mackerelView);
        this.badges.add(sardinView);
        this.badges.add(tilapiaView);
        this.badges.add(tomanView);

        badges.forEach((badge) -> badge.setVisible(false));
    }

    public void initializeBadgeListPopup() {
        Label plabel = new Label();
        plabel.setStyle("-fx-font-size:25");
        plabel.setText("Badges List");
        plabel.setAlignment(Pos.CENTER);

        GridPane badgeList = new GridPane();
        badgeList.addRow(0, plabel);
        badgeList.addRow(1, badges.get(0), badges.get(1), badges.get(2));
        badgeList.addRow(2, badges.get(3), badges.get(4));
        badgeList.setBackground(
                new Background(new BackgroundFill(Color.web("#C2C5CC"), CornerRadii.EMPTY, Insets.EMPTY)));
        badgeList.setPadding(new Insets(10));
        badgeList.setHgap(10);
        badgeList.setVgap(20);
        badgeList.setAlignment(Pos.CENTER);

        badgeListPopup.getContent().add(badgeList);
    }

    public void addFishes() {
        this.addFishes(new BaseEntityFactory());
    }

    public void addFishes(EntityFactory entityFactory) {
        Random random = new Random();
        int fishRandom = random.nextInt(5);
        switch(fishRandom) {
            case 0:
                this.countArapaima++;
                break;
            case 1:
                this.countMackerel++;
                break;
            case 2:
                this.countSardine++;
                break;
            case 3:
                this.countTilapia++;
                break;
            case 4:
                this.countToman++;
                break;
        }
        fish = new EntityImageViewAdapter(entityFactory.createFishesEntity(aquarium, this, fishRandom, this.countArapaima, this.countMackerel, this.countSardine, this.countTilapia, this.countToman));
        this.getChildren().add(fish);
    }

    public void removeFishes() {
        this.getChildren().remove(fish);
        fish = null;
    }

    public void toggleFishes(Button button) {
        if (fish == null) {
            addFishes();
            button.setText("Remove Fishes");
        } else {
            removeFishes();
            button.setText("Generate Fishes");
        }
    }

    public boolean toggleEntity(Button button, int index, String entityName) {
        var entity = entities.get(index);
        if (!entity.isVisible()) {
            entity.setVisible(true);
            button.setText("Remove " + entityName);
        } else {
            entity.setVisible(false);
            button.setText("Add " + entityName);
        }
        return entity.isVisible();
    }

    public boolean toggleBadgeListPopup() {
        if (!badgeListPopup.isShowing()) {
            badgeListPopup.show(aquarium.getStage());
        } else {
            badgeListPopup.hide();
        }
        return badgeListPopup.isShowing();
    }

    public boolean toggleMusic() {
        if (!this.player.getStatus().equals(Status.PLAYING)) {
            performCommand(new ToggleBGMusic(player));
        } else {
            undoCommand(new ToggleBGMusic(player));
        }
        return this.player.getStatus().equals(Status.PLAYING);
    }

    public void performCommand(Command cmd) {
        cmd.execute();
    }

    public void undoCommand(Command cmd) {
        cmd.undo();
    }

    public ArrayList<ImageView> getBadgeList() {
        return badges;
    }

    public void stop() {
        aquarium.stopAquarium();
    }
}