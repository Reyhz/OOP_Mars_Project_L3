package view;

import javafx.scene.image.ImageView;
import model.Robot;

public class SpriteRobot extends Sprite {
    // Constrctors
    public SpriteRobot(Robot robot) {
        super(robot,new ImageView(ImageResource.imageRobot));
    }
}
