package g53554.humbug.controller;

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
     *
     * @param game
     * @param view
     */
    public Controller(Model game, InterfaceView view) {
        if (game == null || view == null) {
            throw new NullPointerException("Le view ou le game "
                    + "n'est pas initialiser ");
        }
        this.game = game;
        this.view = view;
    }

    public void startGame() {
        game.startLevel(1);
        do {
            view.displayBoard(game.getBoard(), game.animals());
            Position pos = view.askPosition();
            Direction dir = view.askDirection();
            game.move(pos, dir);
        } while (!game.levelIsOver());

    }

}