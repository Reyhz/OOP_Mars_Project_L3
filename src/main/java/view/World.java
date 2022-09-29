package view;

import model.Position;

public class World {
    // Data 
    public static final int EMPTY = 0;
    public static final int ROCK = 1;
    public static final int DUST = 2;

    private int tab[][];

    // Constructor
    public World(int width, int height){
        this.tab = new int[width][height];
    }

    // Methods
    public int get(Position pos){
        return tab[pos.getX()][pos.getY()];
    }

    public void set(Position pos, int kind){
        tab[pos.getX()][pos.getY()] = kind;
    }
}
