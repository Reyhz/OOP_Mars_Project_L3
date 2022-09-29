package view;

import model.Position;
import javafx.scene.image.ImageView;

public class SpriteDust extends SpriteDecor{
    // Constructors
    public SpriteDust(Position pos) {
        super(pos,new ImageView(ImageResource.imageDust));
    }
}