package piece;

public abstract class Ship {
    private int size;
    private int hits;
    private int row,col;
    private boolean isHorizontol;

    // constructor for ships
    public Ship(int size){
        this.size = size;
        this.hits = 0;
    }
    //will take a starting position and whether the ship is going horizontal
    //or not
    public void place(int row,int col, boolean horizontal){
        this.row = row;
        this.col = col;
        this.isHorizontol = horizontal;
    }

    //determines if a ship is sunk
    public boolean isSUnk(){
        //if hits are more than or eqal to the size ship is sunk and returns
        //ture
        if(hits >= size){
            return true;
        }
        //default return is false
        return false;
    }
    //increase hit count
    public void hit(){
        hits++;
    }

    public abstract String getName();

    public int getSize(){
        return size;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public boolean isHorizontol(){
        return isHorizontol;
    }
}
