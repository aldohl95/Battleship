package Player;

import Main.Board;

public abstract class Player {

    public Board board = new Board();

    public Board getBoard() {
        return board;
    }

    public abstract void placeShips();
    public abstract void move(Player opponent);
}
