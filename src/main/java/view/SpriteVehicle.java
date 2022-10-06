package view;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import model.Position;
import model.Vehicle;

public abstract class SpriteVehicle extends Sprite{
    // Data
    private Vehicle vehicle;

    // Constructors
    public SpriteVehicle(Vehicle vehicle, ImageView img){
        super(img);
        this.vehicle = vehicle;
        updateLocation(this.vehicle.getPosition());
    }

    // Methods
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
                vehicle.move(positionPath[positionPath.length-1]);
            });
        } else {
            // Direct move
            vehicle.move(target);
            updateLocation(target);
        }
    }
}
