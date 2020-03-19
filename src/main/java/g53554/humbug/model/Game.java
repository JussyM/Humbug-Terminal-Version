package g53554.humbug.model;

/**
 * This class
 *
 * @author jj
 */
public class Game implements Model {

    private final Board board = Board.getInitBoard();
    private Animal[] animals;

    /**
     * return the board of the game
     *
     * @return board
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * return the animals
     *
     * @return animals
     */
    @Override
    public Animal[] animals() {
        return animals;
    }

    /**
     *
     * @param level
     */
    @Override
    public void startLevel(int level) {
        getBoard();
        animals();

    }

    /**
     *
     * @return
     */
    @Override
    public boolean levelIsOver() {
        return false;
    }

    /**
     *
     * @param position
     * @param direction
     */
    @Override
    public void move(Position position, Direction direction) {

    }

}
