package org.aquarium;

import java.util.Stack;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class Controls extends GridPane {
    public Button[] entityButtons = new Button[5];
    public String[] entityButtonNames = { "Bubbles", "Wrecked Ship", "Crab", "Seahorse", "Seaweed" };
    public Space space;
    private Stack<Button> stackBtn = new Stack<>();
    private Stack<Integer> stackInt = new Stack<>();
    private Stack<String> stackStr = new Stack<>();
    private Toggle toggle = new Toggle();
    private ToggleEntityVisibility toggleV = new ToggleEntityVisibility(toggle);

    public Controls(Space space) {
        this.space = space;
        initializeButtons();
    }

    public void initializeButtons() {
        int btn_minWidth = 200;
        int btn_minHeight = 50;
        int padding = 15;

        Button fishBtn = new Button("Generate Fishes");
        fishBtn.setMinSize(btn_minWidth, btn_minHeight);
        fishBtn.setPadding(new Insets(padding));
        fishBtn.setOnAction(e -> space.toggleFishes(fishBtn));
        this.addRow(0, fishBtn);

        for (int i = 0; i < entityButtonNames.length; i++) {
            final Integer innerIndex = i;
            entityButtons[innerIndex] = new Button("Add " + entityButtonNames[innerIndex]);
            entityButtons[innerIndex].setMinSize(btn_minWidth, btn_minHeight);
            entityButtons[innerIndex].setPadding(new Insets(padding));
            entityButtons[innerIndex].setOnAction(e -> {
                toggleEntityVisibility(entityButtons[innerIndex], innerIndex, entityButtonNames[innerIndex]);
                space.performCommand(toggleV);
            });
            if (innerIndex == 4) {
                this.addRow(1, entityButtons[innerIndex]);
            } else {
                this.addRow(0, entityButtons[innerIndex]);
            }
        }


        Button badgeBtn = new Button("See Badges");
        badgeBtn.setMinSize(btn_minWidth, btn_minHeight);
        badgeBtn.setPadding(new Insets(padding));
        badgeBtn.setOnAction(e -> 
            toggleBadgeListVisibility(badgeBtn));
        this.addRow(1, badgeBtn);

        Button musicBtn = new Button("Play BG Music");
        musicBtn.setMinSize(btn_minWidth, btn_minHeight);
        musicBtn.setPadding(new Insets(padding));
        musicBtn.setOnAction(e -> toggleMusic(musicBtn));
        this.addRow(1, musicBtn);

        Button undoBtn = new Button("Undo");
        undoBtn.setMinSize(btn_minWidth, btn_minHeight);
        undoBtn.setPadding(new Insets(padding));
        undoBtn.setOnAction(e -> space.undoCommand(toggleV));
        this.addRow(1, undoBtn);

        Button exitBtn = new Button("Exit");
        exitBtn.setMinSize(btn_minWidth, btn_minHeight);
        exitBtn.setPadding(new Insets(padding));
        exitBtn.setOnAction(e -> space.stop());
        this.addRow(1, exitBtn);

        this.setBackground(new Background(new BackgroundFill(Color.web("#C2C5CC"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.setPadding(new Insets(5, 5, 10, 5 ));
        this.setAlignment(Pos.CENTER);
        this.setHgap(7);
        this.setVgap(7);
        this.setPrefHeight(145);
    }

    public void toggleEntityVisibility(Button button1, int index1, String entityName) {
        toggle.setSpace(space);
        toggle.setStackBtn(stackBtn);
        toggle.setStackInt(stackInt);
        toggle.setStackStr(stackStr);
        toggle.setButton(button1);
        toggle.setEntityName(entityName);
        toggle.setIndex(index1);
    }

    public void toggleBadgeListVisibility(Button button) {
        boolean visibility = space.toggleBadgeListPopup();
        if (!visibility) {
            button.setText("See Badges List");
        } else {
            button.setText("Hide Badges List");
        }
    }

    public void toggleMusic(Button button) {
        boolean playing = space.toggleMusic();
        if (!playing) {
            button.setText("Stop Music");
        } else {
            button.setText("Play Music");
        }
    }
}