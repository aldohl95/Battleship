package Player;

import Main.Board;

public abstract class Player {

    private Board board = new Board();

    public Board getBoard() {
        return board;
    }

    public abstract void placeShips();
    public abstract void move(Player opponent);
}
