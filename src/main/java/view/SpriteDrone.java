package view;

import fr.ubx.poo.td2.Drone;
import javafx.scene.image.ImageView;

public class SpriteDrone extends Sprite {
    // Constructors
    public SpriteDrone(Drone drone) {
        super(drone,new ImageView(ImageResource.imageDrone));
    }
}
