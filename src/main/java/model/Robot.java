package model;

import java.util.ArrayList;
import java.util.List;
import view.World;

public class Robot extends Vehicle {
    private World world;

    // Constructors
    public Robot(Position position, double energy, double cost) {
        super(position, energy, cost);
    }

    public Robot(Position position, double energy, double cost, World world){
        this(position,energy,cost);
        this.world = world;
    }

    // Methods
    @Override
    public int distance(Position target) {
        return Math.abs((target.getX() - this.getPosition().getX())) + Math.abs((target.getY() - this.getPosition().getY()));
    }

    @Override
    public Position[] getPathTo(Position target) {
        int dist = this.distance(target);
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();

        this.setMoving(true);

        List<Position> posList = new ArrayList<Position>();

        for(int i = 0; i<dist; i++){
            if( i % 2 == 1 ){
                if( y == target.getY()){
                    if(x > target.getX()){
                        if( world.isRock(new Position(x-1, y))){
                            break;
                        }
                        x--;
                    }
                    else{
                        if( world.isRock(new Position(x+1, y))){
                            break;
                        }
                        x++;
                    }
                }
                if( y > target.getY() ){
                    if( world.isRock(new Position(x, y-1))){
                        break;
                    }
                    y--;
                }
                if( y < target.getY() ){
                    if( world.isRock(new Position(x, y+1))){
                        break;
                    }
                    y++;
                }

                posList.add(new Position(x, y));
            }
            else{
                if( x == target.getX()){
                    if( y > target.getY()){
                        if( world.isRock(new Position(x, y-1))){
                            break;
                        }
                        y--;
                    }
                    else{
                        if( world.isRock(new Position(x, y+1))){
                            break;
                        }
                        y++;
                    }
                }
                if( x > target.getX()){
                    if( world.isRock(new Position(x-1, y))){
                        break;
                    }
                    x--;
                }
                if( x < target.getX()){
                    if( world.isRock(new Position(x+1, y))){
                        break;
                    }
                    x++;
                }
                posList.add(new Position(x, y));
            }
        }

        // Converting the List to an Array
        Position[] posArr = new Position[posList.size()];
        posList.toArray(posArr);
        
        return posArr;
    }

}
