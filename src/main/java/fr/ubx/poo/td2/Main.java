package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {

        // Creation du robot et du drone
        Vehicle[] vehicle = new Vehicle[2];
        Sprite[] sprites = new Sprite[2];

        Position position = new Position(4,4);
        vehicle[0] = new Robot(position, 200, 2);
        sprites[0] = new SpriteRobot((Robot) vehicle[0]);

        position = new Position(8,8);
        vehicle[1] = new Drone(position, 200, 2);
        sprites[1] = new SpriteDrone((Drone) vehicle[1]);

        // Affiche la fenetre
        View view = new View(20, 20);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            for(int i = 0; i < vehicle.length; i++){
                if(vehicle[i].canMove(target) && !vehicle[i].getMoving()){
                    sprites[i].animateMove(target);
                }
            }
            //if (robot.canMove(target) && !robot.getMoving()) {
            //    spriteRobot.animateMove(target);
            //}
        });

        view.getPane().getChildren().addAll(sprites[0].getImg());
        view.getPane().getChildren().addAll(sprites[1].getImg());

    }

    public static void main(String[] args) { launch(); }
}