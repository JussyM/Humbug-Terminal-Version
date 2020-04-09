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
     * getter of level status
     *
     * @return levelStatus of the game
     */
    LevelStatus getLevelStatus();

    /**
     * getter for the current level
     *
     * @return level value
     */
    int getCurrentLevel();

    /**
     * return the remaining moves of the games also a getter
     *
     * @return remainingMoves
     */
    int getRemainingMoves();
}
