package Player;

import piece.*;
import Main.Board;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private Scanner scanner = new Scanner(System.in);

    @Override
    public void placeShips(){
        System.out.println("Place your ships.");
        placeSingleShip(new Submarine());
        placeSingleShip(new Destroyer());
        placeSingleShip(new Battleship());
        placeSingleShip(new Carrier());
        placeSingleShip(new Cruiser());
    }

    private void placeSingleShip(Ship ship){
        boolean placed = false;

        while(!placed){
            System.out.println("Placing " + ship.getName() + " (size " + ship.getSize() + ")");
            System.out.print("Enter row: ");
            int row = scanner.nextInt();
            System.out.print("Enter column: ");
            int col = scanner.nextInt();
            System.out.print("Horizontal? (true/false): ");
            boolean horizontal = scanner.nextBoolean();

            placed = board.placeShip(ship, row, col, horizontal);

            if(!placed){
                System.out.println("Invalid Placement");
            }
        }
    }

    @Override
    public void move(Player opponent){
        int row, col;
        boolean moveMade = false;

        while(!moveMade){
            System.out.print("Enter attack row: ");
            row = scanner.nextInt();
            System.out.print("Enter attack column: ");
            col = scanner.nextInt();

            if (opponent.getBoard().attackHits(row, col)) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss.");
            }

            moveMade = true;
        }
    }


}
