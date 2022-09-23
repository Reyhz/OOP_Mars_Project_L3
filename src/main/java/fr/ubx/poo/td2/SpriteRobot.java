package fr.ubx.poo.td2;

import javafx.scene.image.ImageView;

public class SpriteRobot extends Sprite {
    // Constrctors
    public SpriteRobot(Robot robot) {
        super(robot,new ImageView(ImageResource.imageRobot));
    }
}
