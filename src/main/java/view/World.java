package view;

import model.Position;

public class World {
    // Data 
    public static final int EMPTY = 0;
    public static final int ROCK = 1;
    public static final int DUST = 2;

    private int grid[][];
    private float percentageDust;
    private float percentageRock;

    // Constructors
    public World(int width, int height){
        this.grid = new int[width][height];
    }

    public World(int width, int height, float percentageRock, float percentageDust){
        this(width, height);
        this.percentageDust = percentageDust;
        this.percentageRock = percentageRock;
    }

    // Methods
    public int get(Position pos){
        return this.grid[pos.getX()][pos.getY()];
    }

    public void set(Position pos, int kind){
        this.grid[pos.getX()][pos.getY()] = kind;
    }

    // TODO: Placing decor at random using percentageRock & percentageDust
    private SpriteDecor[] randomizer(int width, int height){
        return null;
    }
}
