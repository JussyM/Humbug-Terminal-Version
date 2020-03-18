package g53554.humbug.view.text;

import g53554.humbug.model.Animal;
import g53554.humbug.model.Board;
import g53554.humbug.model.Direction;
import g53554.humbug.model.Position;
import g53554.humbug.model.SquareType;
import java.util.Scanner;

/**
 * Here is the game view contains all the method that help us to see what we
 * playing as game
 *
 * @author jj
 */
public class View implements InterfaceView {

    /**
     * Display the board on the level 1 of the game
     *
     * @param board
     * @param animals
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] Sboard = new String[board.getNbRow()][board.getNbColumn()];
        System.out.println("▬▬▬▬▬▬▬");
        for (int i = 0; i < Sboard.length; i++) {
            for (int j = 0; j < Sboard[i].length; j++) {
                Position position = new Position(i, j);
                if (boardIsInside1(board, position, i)) {
                    displayFirstBoardSquare(j);
                } else if (boardIsInside2(board, position, i)) {
                    displaySecondBoardSquare(j, Sboard, i);

                } else if (boardIsInside3(board, position)) {
                    displayThirdBoardSquare();

                }

            }

        }
    }

    /**
     * It display the fisrt Square board
     *
     * @param j
     */
    private void displayFirstBoardSquare(int j) {

        System.out.println(ColorCode.CYAN_BACKGROUND
                + "| " + "\uD83D\uDC0C" + " |" + "  |" + ColorCode.toDefault);
        System.out.println(ColorCode.CYAN_BACKGROUND
                + "|  |" + "  |" + ColorCode.toDefault);

        if (j == 1) {
            System.out.println("▬▬▬▬▬▬▬▬▬▬");
        }

    }

    /**
     * Display The second Square board
     *
     * @param j
     * @param sBoard
     * @param i
     */
    private void displaySecondBoardSquare(int j, String[][] sBoard, int i) {
        System.out.println(ColorCode.toDefault
                + "   " + ColorCode.CYAN_BACKGROUND
                + "|  |" + "  |" + ColorCode.toDefault);
        System.out.println(ColorCode.toDefault
                + "   " + ColorCode.CYAN_BACKGROUND
                + "|  |" + "  |" + ColorCode.toDefault);
        if (j == sBoard[i].length - 1) {
            System.out.println("▬▬▬▬▬▬▬▬▬▬");
        }

    }

    /**
     * Verify if the SquareType is Star And if the position is inside the board
     *
     * @param board
     * @param position
     * @return boolean
     */
    private boolean boardIsInside3(Board board, Position position) {
        return board.isInside(position)
                && board.getSquareType(position)
                == SquareType.STAR;
    }

    /**
     * Display the third part
     */
    private void displayThirdBoardSquare() {
        System.out.println(ColorCode.toDefault
                + "      " + ColorCode.CYAN_BACKGROUND
                + "| *" + "|" + ColorCode.toDefault);
        System.out.println(ColorCode.toDefault
                + "      " + ColorCode.CYAN_BACKGROUND
                + "|  |" + ColorCode.toDefault);
        System.out.println(ColorCode.toDefault
                + "      " + ColorCode.CYAN_BACKGROUND
                + "|  |" + ColorCode.toDefault);
        System.out.println("      " + "▬▬▬▬");

    }

    /**
     * Verify if the SquareType is grass And if the position is inside the board
     *
     * @param board
     * @param position
     * @param i
     * @return boolean
     */
    private boolean boardIsInside1(Board board, Position position, int i) {
        return i <= 0 && board.isInside(position)
                && board.getSquareType(position)
                == SquareType.GRASS;

    }

    /**
     * Verify if the SquareType is grass And if the position is inside the board
     *
     * @param board
     * @param position
     * @param i
     * @return boolean
     */
    private boolean boardIsInside2(Board board, Position position, int i) {
        return i > 0 && board.isInside(position)
                && board.getSquareType(position)
                == SquareType.GRASS;
    }

    /**
     * Display a an error message if occure
     *
     * @param message
     */
    @Override
    public void displayError(String message) {
        System.out.println(message);
    }

    /**
     * Ask the postion to the user
     *
     * @return
     */
    @Override
    public Position askPosition() {
        System.out.println("Entrez une ligne valide: ");
        int lg = valideValue();
        System.out.println("Entrez une colonne valide: ");
        int col = valideValue();

        return new Position(lg, col);

    }

    /**
     * Ask the users a valide input
     *
     * @return primitif Integer
     */
    private int valideValue() {
        Scanner clavier = new Scanner(System.in);
        while (!clavier.hasNextInt()) {
            clavier.next();
            displayError("Le nombre entrez n'est pas un entier");
        }
        return clavier.nextInt();
    }

    /**
     * Ask a direction and return a direction fgiven by the user
     *
     * @return direction or null
     */
    @Override
    public Direction askDirection() {
        String input = valideDirection();
        switch (input) {
            case "north":
                return Direction.NORTH;
            case "south":
                return Direction.SOUTH;
            case "west":
                return Direction.WEST;
            case "east":
                return Direction.EAST;
            default:

        }
        return null;

    }

    /**
     * Ask a direction for the user
     *
     * @return input
     */
    private String valideDirection() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        while (!correct(input)) {
            displayError("La direction n'est pas valable ");
            input = in.next();

        }
        return input;
    }

    /**
     * verify if the direction is correct return true if it's correct false if
     * it's not
     *
     * @param input
     * @return boolean
     */
    private boolean correct(String input) {
        String[] direction = {"north", "east", "west", "south"};
        boolean found = false;
        int i = 0;
        while (i < direction.length && !found) {
            if (input.equals(direction[i])) {
                found = true;
            }
            i++;
        }
        return found;
    }

    public static void main(String[] args) {
        View v = new View();
        v.displayBoard(Board.getInitBoard());
//        v.displayBoard(Board.getInitBoard());
//        //  v.askPosition();
//        //  System.out.println(v.askDirection());
        //       View.displayBoard2(Board.getInitBoard());
    }
}
