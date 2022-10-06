package view;

import java.util.ArrayList;
import java.util.List;

import model.Position;

public class World {
    // Data 
    public static final int EMPTY = 0;
    public static final int ROCK = 1;
    public static final int DUST = 2;

    private int grid[][];
    private int width;
    private int height;
    private int percentageDust;
    private int percentageRock;

    // Constructors
    public World(int width, int height){
        this.grid = new int[width][height];
        this.width = width;
        this.height = height;
    }

    public World(int width, int height, int percentageRock, int percentageDust){
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

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public SpriteDecor[] randomizer(){
        return randomizer(this.width, this.height);
    }

    public SpriteDecor[] randomizer(int width, int height){
        List<SpriteDecor> dec_list = new ArrayList<SpriteDecor>();
        Position rdm_pos = new Position(0, 0);

        int kind = DUST;
        int nbr_dust = (int)((width * height) * ((float)this.percentageDust / 100));
        int nbr_rock = (int)((width * height) * ((float)this.percentageRock / 100));
        while( nbr_rock != 0 ){
            if( nbr_dust == 0 && kind != ROCK ){
                kind = ROCK;
            }

            rdm_pos.random(width, height);
            if( this.grid[rdm_pos.getX()][rdm_pos.getY()] == EMPTY){
                // Adding the corresponding sprite to the array
                dec_list.add(DecorFactory.create(rdm_pos, kind));
                set(rdm_pos, kind);
                
                // We placed a decor element, we decrement the counter
                if(kind == DUST) nbr_dust--;
                else nbr_rock--;
            }
        }

        // Converting the list back to array, to mach the return type of the function
        SpriteDecor[] dec_array = new SpriteDecor[dec_list.size()];
        dec_list.toArray( dec_array );

        return dec_array;
    }
}
