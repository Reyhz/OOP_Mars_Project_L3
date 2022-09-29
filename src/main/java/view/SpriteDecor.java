package view;

import javafx.scene.image.ImageView;
import model.Position;

public abstract class SpriteDecor extends Sprite {
    // Data 
    private Position pos;

    // Constructor
    public SpriteDecor(Position pos, ImageView img){
        super(img);
        this.pos = pos;
    }
}
