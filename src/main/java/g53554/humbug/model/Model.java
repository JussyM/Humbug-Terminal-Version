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
     * Apply a move for an animal according to the direction
     *
     * @param position
     * @param direction
     */
    void move(Position position, Direction direction);

    /**
     *
     * @return
     */
    LevelStatus getLevelStatus();

    /**
     *
     * @return
     */
    int getRemainingMoves();
}
