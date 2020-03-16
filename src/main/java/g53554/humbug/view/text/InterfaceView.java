package g53554.humbug.view.text;

import g53554.humbug.model.Board;
import g53554.humbug.model.Direction;
import g53554.humbug.model.Position;

/**
 *
 * @author jj
 */
public interface InterfaceView {

    /**
     * Display the board on the level 1 of the game
     *
     * @param board
     */
    void displayBoard(Board board);

    /**
     * Ask a position for the user and return a valid position
     *
     * @return position
     */
    Position askPosition();

    /**
     * ask a valid direction for the animal to move
     *
     * @return direction
     */
    Direction askDirection();

    /**
     * print out the error according to the message
     *
     * @param message
     */
    void displayError(String message);

}
