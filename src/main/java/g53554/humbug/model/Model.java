package g53554.humbug.model;

/**
 * Game interface where all the game methode will be implement
 *
 * @author jj
 */
public interface Model {

    /**
     * Return the board of the game
     *
     * @return board
     */
    Board getBoard();

    /**
     * return an arrays of animal
     *
     * @return animal[]
     */
    Animal[] animals();

    /**
     * Start the game in the level as argument
     *
     * @param level
     */
    void startLevel(int level);

    /**
     * return a boolean if the level is over or not
     *
     * @return boolean
     */
    boolean levelIsOver();

    /**
     * Apply a move for an animal according to the direction
     *
     * @param position
     * @param direction
     */
    void move(Position position, Direction direction);
}
