package Main;
import piece.Ship;

import java.util.*;


public class Board {

    private int gsize = 10;
    private int char[][] grid = new char[gsize][gsize];
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

}
