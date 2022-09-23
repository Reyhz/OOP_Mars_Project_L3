package fr.ubx.poo.td2;

public class Drone extends Vehicle {
    // Constructors
    public Drone(Position position, double energy, double cost) {
        super(position, energy, cost);
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

        setMoving(true);

        Position[] posArr = new Position[dist];

        for(int i = 0; i<dist; i++){
            if( i % 2 == 1 ){
                if( y == target.getY()){
                    if(x > target.getX()){
                        x--;
                    }
                    else{
                        x++;
                    }
                }
                if( y > target.getY() ){
                    y--;
                }
                if( y < target.getY() ){
                    y++;
                }

                posArr[i] = new Position(x, y);
            }
            else{
                if( x == target.getX()){
                    if( y > target.getY()){
                        y--;
                    }
                    else{
                        y++;
                    }
                }
                if( x > target.getX()){
                    x--;
                }
                if( x < target.getX()){
                    x++;
                }
                posArr[i] = new Position(x, y);
            }
        }
        return posArr;
    }

}
