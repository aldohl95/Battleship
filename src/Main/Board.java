package Main;
import piece.Ship;
import java.util.*;


public class Board {

    private int gsize = 10;
    private char[][] grid = new char[gsize][gsize];
    private List<Ship> ships = new ArrayList<>();

    //loops through each row of the grid and fills it with
    // ~ representing water
    public Board(){
        for(char[] row : grid){
            Arrays.fill(row, '~');
        }
    }
    //checks if piece can be placed if it can it will place it
    public boolean placeShip(Ship ship, int row, int col, boolean horizontal){
        int size = ship.getSize();

        if(horizontal){
            //return false if ship will go out of borders
            if(col + size > gsize){
                return false;
            }
            //loops the area ship will be place and
            // if ship does not encounter water will return false
            for(int i = 0; i < size; i++) {
                if (grid[row][col + i] != '~') {
                    return false;
                }
            }
            //if the area it will be place is valid will place the ship
            for(int i = 0; i < size; i++){
                grid[row][col+i] = 'S';
            }

        }
        else{
            if(row + size > gsize){
                return false;
            }
            for(int i = 0; i < size; i++){
                if(grid[row + i][col] != '~'){
                    return false;
                }
            }
            for(int i = 0; i < size; i++){
                grid[row + i][col] = 'S';
            }
        }
        ship.place(row, col, horizontal);
        ships.add(ship);
        return true;
    }

    public boolean attackHits(int row, int col){
        //returns false if that area has already been hit
        if(grid[row][col] == 'X' || grid[row][col] == '0'){
            return false;
        }
        //if that location is a ship
        if(grid[row][col] == 'S'){
            //changes it to X to mark the location as a hit
            grid[row][col] = 'X';
            //loops throughthe ships locations to see if there is a ship there
            for(Ship ship : ships){
                if(isHit(ship, row, col)){
                    ship.hit();
                }
            }
            return true;
        }
        //if it doesnt hit replaces that location to 0 marking a miss
        else{
            grid[row][col] = '0';
            return false;
        }
    }
    //loops through all the ships to see if they have all been sunk
    public boolean allShipsSunk(){
        for(Ship ship: ships){
            if(!ship.isSUnk()){
                return false;
            }
        }
        return true;
    }

    public void print(boolean revealShips){
        System.out.print("  ");
        for (int col = 0; col < gsize; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        for (int row = 0; row < gsize; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < gsize; col++) {
                char c = grid[row][col];
                if (!revealShips && c == 'S') {
                    System.out.print("~ ");
                } else {
                    System.out.print(c + " ");
                }
            }
            System.out.println();
        }
    }
    //checks if target corresponds to a ship location
    public boolean isHit(Ship ship, int row, int col){
        int r = ship.getRow();
        int c = ship.getCol();
        for(int i = 0; i < ship.getSize(); i++){
            //if ship is horizontal uses left value if not uses right value
            int checkRow = ship.isHorizontol() ? r : r  + i;
            int checkCol = ship.isHorizontol()? c + i : c ;
            if(checkRow == row && checkCol == col){
                return true;
            }
        }
        return false;
    }

}
