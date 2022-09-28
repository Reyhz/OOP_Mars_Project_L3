package view;

import fr.ubx.poo.td2.Robot;
import javafx.scene.image.ImageView;

public class SpriteRobot extends Sprite {
    // Constrctors
    public SpriteRobot(Robot robot) {
        super(robot,new ImageView(ImageResource.imageRobot));
    }
}
