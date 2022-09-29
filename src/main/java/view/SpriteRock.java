package view;

import model.Position;
import javafx.scene.image.ImageView;

public class SpriteRock extends SpriteDecor{
    // Constructors
    public SpriteRock(Position pos) {
        super(pos,new ImageView(ImageResource.imageRock));
    }
}
