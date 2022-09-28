package view;

import fr.ubx.poo.td2.Position;
import fr.ubx.poo.td2.Vehicle;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public abstract class Sprite {
    // Data
    private Vehicle vehicle;
    private ImageView img;

    // Constructors
    public Sprite(Vehicle vehicle, ImageView img){
        this.vehicle = vehicle;
        this.img = img;
        updateLocation(this.vehicle.getPosition());
    }

    // Methods
    public ImageView getImg(){
        return img;
    }

    private void updateLocation(Position position) {
        img.setX(position.getX() * ImageResource.size);
        img.setY(position.getY() * ImageResource.size);
    }

    public void animateMove(Position target) {
        // Make the path movement
        Position[] positionPath = vehicle.getPathTo(target);

        if (positionPath != null) {
            Path path = new Path();

            path.getElements().add(new MoveTo(vehicle.getPosition().getX() * ImageResource.size + ImageResource.size / 2,
                    vehicle.getPosition().getY() * ImageResource.size + ImageResource.size / 2));
            for (Position pos : positionPath) {
                path.getElements().add(new LineTo(pos.getX() * ImageResource.size + ImageResource.size / 2, pos.getY() * ImageResource.size + ImageResource.size / 2));
            }

            PathTransition ptr = new PathTransition();
            ptr.setDuration(Duration.millis(300 * vehicle.distance(target)));
            ptr.setPath(path);
            ptr.setNode(getImg());
            ptr.play();

            ptr.setOnFinished(e -> {
                vehicle.move(target);
            });
        } else {
            // Direct move
            vehicle.move(target);
            updateLocation(target);
        }
    }
}
