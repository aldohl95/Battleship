package Player;

import piece.*;

import java.util.Random;

public class ComputerPlayer extends Player{
    private Random rand = new Random();

    @Override
    public void placeShips() {
        while (!board.placeShip(new Submarine(), rand.nextInt(10),
                rand.nextInt(10), rand.nextBoolean()));
        while (!board.placeShip(new Destroyer(), rand.nextInt(10),
                rand.nextInt(10), rand.nextBoolean()));
        while (!board.placeShip(new Cruiser(), rand.nextInt(10),
                rand.nextInt(10), rand.nextBoolean()));
        while (!board.placeShip(new Carrier(), rand.nextInt(10),
                rand.nextInt(10), rand.nextBoolean()));
        while (!board.placeShip(new Battleship(), rand.nextInt(10),
                rand.nextInt(10), rand.nextBoolean()));
    }

    @Override
    public void move(Player opponent) {
        int row, col;

        row = rand.nextInt(10);
        col = rand.nextInt(10);
        System.out.println("Computer attacks: " + row + ", " + col);

        if (opponent.getBoard().attackHits(row, col)) {
            System.out.println("Hit!");
        } else {
            System.out.println("Miss.");
        }

    }
}
