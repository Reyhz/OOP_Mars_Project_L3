package fr.ubx.poo.td2;

public abstract class Vehicle {
    // Data
    private final double cost;
    private Position position;
    private double energy;

    // Flags
    private boolean isMoving = false;

    // Constructors
    public Vehicle(Position position, double energy, double cost) {
        this.position = new Position(position.getX(),position.getY());
        this.energy = energy;
        this.cost = cost;
    }

    // Methods
    public Position getPosition() {
        return new Position(this.position.getX(), this.position.getY());
    }

    public boolean getMoving() {
        return this.isMoving;
    }

    public double getEnergy(){
        return this.energy;
    }

    public double getCost(){
        return this.cost;
    }

    protected void setMoving( boolean move ){
        this.isMoving = move;
    }

    private int range() {
        return (int)(energy/cost);
    }

    public boolean canMove(Position target) {
        int dist = this.distance(target);
        return dist < this.range();
    }


    public void move(Position target) {
        if(this.canMove(target)){
            int dist = this.distance(target);
            this.position.translate(target.getX(), target.getY());
            energy -= dist * cost;
            setMoving(false);
        }

        System.out.println(this);
    }

    public abstract int distance(Position target);

    public abstract Position[] getPathTo(Position target);

    @Override
    public String toString(){
        return "Move Completed: " + this.getClass().getSimpleName() + "( Energy = " + this.energy + " )";
    }
}
