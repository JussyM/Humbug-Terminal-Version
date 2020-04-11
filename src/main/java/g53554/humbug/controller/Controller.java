package g53554.humbug.controller;

import g53554.humbug.model.Animal;
import g53554.humbug.model.Direction;
import g53554.humbug.model.LevelStatus;
import g53554.humbug.model.Model;
import g53554.humbug.model.Position;
import g53554.humbug.view.text.InterfaceView;

/**
 * Controller method interact with the player
 *
 * @author 53554 
 */
public class Controller {

    private Model game;
    private InterfaceView view;

    /**
     * Controller constructor
     *
     * @param game class that initialized the game
     * @param view class that printOut the game board and animals
     */
    public Controller(Model game, InterfaceView view) {
        if (game == null || view == null) {
            throw new NullPointerException("Le view ou le game "
                    + "n'est pas initialiser ");
        }
        this.game = game;
        this.view = view;
    }

    /**
     * Start game method he initialized all the animals on the board initialized
     * the board and display it
     *
     * @param nLevel number the represent the level of the game
     */
    public void startGame(int nLevel) {
        view.displayHelp();

        int i = nLevel;
        while (i <= 40) {
            try {
                view.displayAnimalSigle();
                game.startLevel(i);
                view.displayMessage("NIVEAU: " + game.getCurrentLevel() + "\n");

                do {
                    view.displayremainingMove(game.getRemainingMoves());
                    view.displayBoard(game.getBoard(), game.animals());
                    Position position = view.askPosition();
                    while (!validPosition(position, game.animals())) {
                        view.displayError("Pas d'animal à cette case " + "\n");
                        position = view.askPosition();

                    }
                    Direction direction = view.askDirection();
                    game.move(position, direction);

                } while (game.getLevelStatus() != LevelStatus.WIN);
                i++;

                view.displayBoard(game.getBoard(), game.animals());
                view.displayWinner();

            } catch (NullPointerException | ArrayIndexOutOfBoundsException
                    | IllegalStateException e) {

                view.displayError(e.getMessage() + "\n");

            }

        }
        view.displayMessage("Félicitation vous avez finit le jeu");

    }

    /**
     * Verify if the position given as argument is correct and if their's an
     * animal at that position
     *
     * @param position given by the usr
     * @param animals arrays of all the animals of the game
     * @return boolean true if correct false if not
     */
    private boolean validPosition(Position position, Animal... animals) {
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position)) {
                return true;
            }
        }
        return false;

    }

}
