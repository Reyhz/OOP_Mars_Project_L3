package view;

import javafx.scene.image.ImageView;
import model.Drone;

public class SpriteDrone extends SpriteVehicle {
    // Constructors
    public SpriteDrone(Drone drone) {
        super(drone,new ImageView(ImageResource.imageDrone));
    }
}
