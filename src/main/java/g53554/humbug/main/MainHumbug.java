package g53554.humbug.main;

import g53554.humbug.controller.Controller;
import g53554.humbug.model.Game;
import g53554.humbug.view.text.View;

/**
 * Main method for humbug
 *
 * @author jj
 */
public class MainHumbug {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }

}
