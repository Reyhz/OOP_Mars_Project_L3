package fr.ubx.poo.td2;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void translate(int dx, int dy) {
        x = dx;
        y = dy;
    }

    public void translate(int delta) {
        translate(delta, delta);
    }

    @Override
    public boolean equals(Object o){
        // If the object is compared with itself return true
        if( o == this ) return true;
        
        /* Check if o is an instance of Vehicle or not
         * null instance of [type] returns false
         */
        if( !(o instanceof Position)) return false;

        // Typecast to compare data
        Position pos = (Position)o;

        return this.getX() == pos.getX() && this.getY() == pos.getY();
    }
}
