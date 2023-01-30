package org.aquarium;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EntityImageViewAdapter extends ImageView {
    public Entity entity;

    public EntityImageViewAdapter(Entity entity) {
        super(new Image(entity.assetPath));
        this.entity = entity;
    }
    
}