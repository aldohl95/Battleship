package Main;

import Player.ComputerPlayer;
import Player.HumanPlayer;

public class Main {
    public static void main(String[] args) {
        HumanPlayer player = new HumanPlayer();
        ComputerPlayer computer = new ComputerPlayer();

        player.placeShips();
        computer.placeShips();

        while (true) {
            System.out.println("\nYour Board:");
            player.getBoard().print(true);
            System.out.println("\nEnemy Board:");
            computer.getBoard().print(false);

            player.move(computer);
            if (computer.getBoard().allShipsSunk()) {
                System.out.println("You win!");
                break;
            }

            computer.move(player);
            if (player.getBoard().allShipsSunk()) {
                System.out.println("You lose!");
                break;
            }
        }
    }
}