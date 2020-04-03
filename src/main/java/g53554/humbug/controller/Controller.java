package g53554.humbug.controller;

import g53554.humbug.model.Animal;
import g53554.humbug.model.Direction;
import g53554.humbug.model.Model;
import g53554.humbug.model.Position;
import g53554.humbug.view.text.InterfaceView;

/**
 * Controller method interact with the player
 *
 * @author jj
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
     */
    public void startGame() {
        game.startLevel(1);
        view.displayHelp();
        try {
            do {
                view.displayBoard(game.getBoard(), game.animals());
                Position position = view.askPosition();
                while (!positionValable(position, game.animals())) {
                    view.displayError("Pas d'animal à cette case " + "\n");
                    position = view.askPosition();

                }
                Direction direction = view.askDirection();
                game.move(position, direction);
              

            } while (!game.levelIsOver());

            view.displayBoard(game.getBoard(), game.animals());

        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {

            view.displayError("L'animal est sortie du jeu");

        }

    }

    /**
     *
     * @param position
     * @param animals
     * @return
     */
    private boolean positionValable(Position position, Animal... animals) {
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position)) {
                return true;
            }
        }
        return false;

    }
}
