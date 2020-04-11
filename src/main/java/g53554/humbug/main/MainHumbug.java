package g53554.humbug.main;

import g53554.humbug.controller.Controller;
import g53554.humbug.model.Game;
import g53554.humbug.view.text.View;
import java.util.Scanner;

/**
 * Main method for humbug to run the game
 *
 * @author jj
 */
public class MainHumbug {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        int nLevel = verifieAndReturnCorrectInput();
        controller.startGame(nLevel);
    }

    /**
     * Ask the level number to the players
     *
     * @return int the level number given by the player
     */
    private static int askLevel() {
        System.out.println("Choisir le niveau de jeu entre (1-40): ");
        Scanner clavier = new Scanner(System.in);
        while (!clavier.hasNextInt()) {
            clavier.next();
            System.out.println("Le nombre entrez n'est pas un entier"
                    + "\n" + "Retry: ");
        }
        return clavier.nextInt();
    }

    /**
     * verfy the input is correct and can be use to launch the game
     *
     * @return correct input (int) level number
     */
    private static int verifieAndReturnCorrectInput() {
        int level = askLevel();
        while (level <= 0 || level > 40) {
            level = askLevel();
        }
        return level;
    }

}
