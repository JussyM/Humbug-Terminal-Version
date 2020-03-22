package g53554.humbug.view.text;

import g53554.humbug.model.Animal;
import g53554.humbug.model.Board;
import g53554.humbug.model.Direction;
import g53554.humbug.model.Position;
import g53554.humbug.model.SquareType;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Here is the game view contains all the method that help us to see what we
 * playing as game
 *
 * @author jj
 */
public class View implements InterfaceView {

    /**
     * Display The board of the game according to the level
     *
     * @param board
     * @param animals
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] boardArrays = initBoard(board, animals);
        printSquareLine(boardArrays[0]);
        System.out.println("");
        displayBoardMethod(boardArrays);
    }

    /**
     * DisplayBoard Code
     *
     * @param boardArrays
     */
    private void displayBoardMethod(String[][] boardArrays) {
        for (String[] boardPrint : boardArrays) {
            for (int col = 0; col < boardPrint.length; col++) {

                switch (boardPrint[col]) {
                    case "GRASS":

                        System.out.print(TerminalColor.toDefault
                                + TerminalColor.GREEN_BACKGROUND
                                + "[  ] " + TerminalColor.toDefault);

                        break;
                    case "STAR":
                        System.out.print(TerminalColor.GREEN_BACKGROUND
                                + "[ ★ ]" + TerminalColor.toDefault);
                        break;
                    case "GRASS_A":
                        System.out.print(TerminalColor.GREEN_BACKGROUND
                                + "[S ] " + TerminalColor.toDefault);

                        break;
                    case "STAR_A":
                        System.out.println("\033[42m[   ]\033[0m");
                        break;
                    default:
                        System.out.print(TerminalColor.WHITE_BACKGROUND
                                + "[  ]" + TerminalColor.toDefault);
                        break;
                }
                if (col == boardArrays[0].length - 1) {
                    System.out.println("");
                    printSquareLine(boardPrint);
                    System.out.println("");

                }
            }
        }

    }

    /**
     * Turn the board into a String arrays and insert the value of each square
     *
     * @param board
     * @param animals
     * @return ARRAY_STRING
     */
    private String[][] initBoard(Board board, Animal... animals) {
        String[][] boardArrays = new String[board.getNbRow()][board
                .getNbColumn()];
        for (int row = 0; row < boardArrays.length; row++) {
            for (int col = 0; col < boardArrays[row].length; col++) {
                Position position = new Position(row, col);
                boolean animalIsPresent = animalIsPresent(position, animals);
                if (board.isInside(position)
                        && board.getSquareType(position) == SquareType.STAR
                        && !animalIsPresent) {
                    boardArrays[row][col] = "STAR";
                } else if (board.isInside(position)
                        && board.getSquareType(position) == SquareType.GRASS
                        && !animalIsPresent) {
                    boardArrays[row][col] = "GRASS";
                } else if (board.isInside(position)
                        && board.getSquareType(position) == SquareType.GRASS
                        && animalIsPresent) {
                    boardArrays[row][col] = "GRASS_A";
                } else if (board.isInside(position)
                        && board.getSquareType(position) == SquareType.STAR
                        && animalIsPresent) {
                    boardArrays[row][col] = "STAR_A";
                } else {
                    boardArrays[row][col] = "null";
                }
            }
        }
        return boardArrays;

    }

    /**
     * print the line tha separate each endLine
     *
     * @param board
     */
    private void printSquareLine(String[] board) {
        int i = 0;
        while (i < board.length) {
            System.out.print("▬▬▬▬▬");
            i++;

        }
    }

    /**
     * Return a boolean if an animal is present
     *
     * @param position
     * @param animal
     * @return boolean true if animal is present false if not
     */
    private boolean animalIsPresent(Position position, Animal... animal) {
        int i = 0;
        boolean found = false;
        while (i < animal.length && !found) {
            if (animal[i].getPositionOnBoard().equals(position)) {
                found = true;
            }
            i++;

        }
        return found;
    }

    /**
     * Display a an error message if occure
     *
     * @param message
     */
    @Override
    public void displayError(String message) {
        System.err.print(message);
    }

    /**
     * Ask the postion to the user
     *
     * @return new position
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
        String[] direction = {"north", "east", "west", "south"};
        System.out.println("Direction Possible: " + Arrays.toString(direction));

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

    /**
     * Display The game begin
     */
    @Override
    public void displayHelp() {
        System.out.println(TerminalColor.toGreen("*****************************"
                + "*"));
        System.out.println(TerminalColor.toRed("***********HUMBUG***********"
                + "**"));
        System.out.println(TerminalColor.toGreen("****************************"
                + "**" + "\n"));

    }
}
