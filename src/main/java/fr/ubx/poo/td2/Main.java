package fr.ubx.poo.td2;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Drone;
import model.Position;
import model.Robot;
import model.Vehicle;
import view.SpriteDecor;
import view.SpriteDrone;
import view.SpriteRobot;
import view.SpriteVehicle;
import view.View;
import view.World;

public class Main extends Application {

    @Override
    public void start(Stage stage)  {
        // Set view width & height
        int width = 20;
        int height = 20;

        // Creating World map
        World world = new World(width, height, 5, 10);
        SpriteDecor[] sprites_dec = world.randomizer();

        // Creation du robot et du drone
        Vehicle[] vehicle = new Vehicle[2];
        SpriteVehicle[] sprites_veh = new SpriteVehicle[2];

        Position position = new Position(4,4);
        vehicle[0] = new Robot(position, 200, 2, world);
        sprites_veh[0] = new SpriteRobot((Robot) vehicle[0]);

        position = new Position(8,8);
        vehicle[1] = new Drone(position, 200, 2);
        sprites_veh[1] = new SpriteDrone((Drone) vehicle[1]);

        // Affiche la fenetre
        View view = new View(width, height);
        stage.setTitle("POO");
        stage.setScene(view.getPane().getScene());
        stage.show();
        view.getPane().setOnMouseClicked(e -> {
            Position target = view.getPosition(e);
            for(int i = 0; i < vehicle.length; i++){
                if(vehicle[i].canMove(target) && !vehicle[i].getMoving() && !vehicle[i].getPosition().equals(target) && world.get(target) != World.ROCK){
                    sprites_veh[i].animateMove(target);
                }
            }
        });

        // Initializing Vehicle sprites
        for(int i = 0; i < sprites_veh.length; i++){
            view.getPane().getChildren().addAll(sprites_veh[i].getImg());
        }

        // Initializing Decor Sprites
        for(int i = 0; i < sprites_dec.length; i++){
            view.getPane().getChildren().addAll(sprites_dec[i].getImg());
        }
    }

    public static void main(String[] args) { launch(); }
}