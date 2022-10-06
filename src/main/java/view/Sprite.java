package view;

import javafx.scene.image.ImageView;
import model.Position;

public abstract class Sprite {
    // Data
    protected ImageView img;

    // Constructor
    public Sprite(ImageView img){
        this.img = img;
    }

    // Methods
    public ImageView getImg(){
        return img;
    }

    protected void updateLocation(Position position) {
        img.setX(position.getX() * ImageResource.size);
        img.setY(position.getY() * ImageResource.size);
    }
}
