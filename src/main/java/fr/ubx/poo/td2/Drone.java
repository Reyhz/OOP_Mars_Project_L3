package fr.ubx.poo.td2;

public class Drone extends Vehicle {
    // Constructors
    public Drone(Position position, double energy, double cost) {
        super(position, energy, cost);
    }

    // Methods
    @Override
    public int distance(Position target) {
        return (int)Math.sqrt(Math.pow(target.getX() - this.getPosition().getX(), 2) + Math.pow(target.getY() - this.getPosition().getY(), 2));
    }

    @Override
    public Position[] getPathTo(Position target) {
        setMoving(true);

        Position[] posArr = new Position[1];
        posArr[0] = target;
        
        return posArr;
    }

}
