package g53554.humbug.view.text;

import g53554.humbug.model.Animal;
import g53554.humbug.model.Board;
import g53554.humbug.model.Direction;
import g53554.humbug.model.Position;

/**
 * Here is the view interface that contain all the specific view method
 *
 * @author jj
 */
public interface InterfaceView {

    /**
     * Display the board on the level 1 of the game
     *
     * @param board of the game
     * @param animals arrays of the animals
     */
    void displayBoard(Board board, Animal... animals);

    /**
     * Ask a position for the user and return a valid position
     *
     * @return position of the animal choosen
     */
    Position askPosition();

    /**
     * ask a valid direction for the animal to move
     *
     * @return direction of the animals
     */
    Direction askDirection();

    /**
     * print out the error according to the message
     *
     * @param message of the errors
     */
    void displayError(String message);

    /**
     * Display the game name and help
     */
    void displayHelp();

    /**
     * Display win message
     */
    void displayWinner();

    /**
     * Display the remaining move of the game
     *
     * @param getMoves moves of the game
     */
    void displayremainingMove(int getMoves);

}
