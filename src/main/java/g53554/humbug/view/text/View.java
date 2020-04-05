package g53554.humbug.view.text;

import g53554.humbug.model.Animal;
import g53554.humbug.model.Board;
import g53554.humbug.model.Direction;
import g53554.humbug.model.Game;
import g53554.humbug.model.Position;
import g53554.humbug.model.Snail;
import g53554.humbug.model.Spider;
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

    public static void main(String[] args) {
        View v = new View();
        Game g = new Game();
        g.startLevel(0);
        v.displayBoard(Board.getInitBoard(), g.animals());

    }

    /**
     * Display The board of the game according to the level
     *
     * @param board
     * @param animals
     */
    @Override
    public void displayBoard(Board board, Animal... animals) {
        String[][] boardArrays = boardExtend(initBoard(board, animals));
        printColPosition(boardArrays[0]);
        System.out.println("");
        System.out.println("");
        displayBoardMethod(boardArrays);
    }

    /**
     * DisplayBoard Code
     *
     * @param boardArrays
     */
    private void displayBoardMethod(String[][] boardArrays) {
        int line;
        int endLine = 2;
        for (line = 0; line < boardArrays.length; line++) {
            for (int col = 0; col < boardArrays[line].length; col++) {
                if (!emptyBoard(boardArrays[line])) {
                    switch (boardArrays[line][col]) {
                        case "GRASS":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "STAR":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ * }" + TerminalColor.toDefault);
                            break;
                        case "Snail":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ E }" + TerminalColor.toDefault);

                            break;
                        case "Spider":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ A }" + TerminalColor.toDefault);

                            break;

                        case "GRASS_A_T":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "GRASS_T":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "GRASS_A_T_D":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);

                            break;
                        case "GRASS_T_D":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "STAR_T_D":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "STAR_T":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        default:
                            System.out.print(
                                    "     ");
                            break;

                    }
                    if (col == boardArrays[0].length - 1 && line == endLine) {
                        System.out.println("");
                        printLine(boardArrays[0]);
                        System.out.println("");
                        endLine += 3;

                    } else if (col == boardArrays[0].length - 1
                            && line != endLine) {
                        printLineIndex(line);
                        System.out.println("");
                    }

                }

            }

        }

    }

    /**
     * Print the endLine
     *
     * @param boardArray board use as reference for the printing
     */
    private void printLine(String[] boardArray) {
        int i = 0;
        while (i < boardArray.length) {
            System.out.print("-----");
            i++;
        }
    }

    /**
     * verify if the board given as an argument is empty or not if yes nothing
     * need to be printOut
     *
     * @param boardArrays will be the arrays use for verification
     * @return boolean true if emply false if not
     */
    private boolean emptyBoard(String[] boardArrays) {
        int i = 0;
        while (i < boardArrays.length && boardArrays[i].equals("nothing")) {
            i++;
        }
        return i == boardArrays.length;
    }

    /**
     * print each line index
     *
     * @param col here is the column index use to know in which line we are
     */
    private void printLineIndex(int col) {
        switch (col) {
            case 1:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 0);
                break;
            case 4:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 1);
                break;
            case 7:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 2);
                break;
            case 10:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 3);
                break;
            case 13:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 4);
                break;

        }

    }

    /**
     * Print each column position
     *
     * @param board use the arrays of string as ref to print the column index
     */
    private void printColPosition(String[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                    + TerminalColor.toDefault, i);

        }

    }

    /**
     * Turn the board into a String arrays and insert the contains of each
     * square
     *
     * @param board of the game
     * @param animals of the game
     * @return new String board
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
                    for (Animal animal1 : animals) {
                        if (animal1.getPositionOnBoard().equals(position)
                                && animal1 instanceof Snail) {
                            boardArrays[row][col] = "Snail";
                        } else if (animal1.getPositionOnBoard().equals(position)
                                && animal1 instanceof Spider) {
                            boardArrays[row][col] = "Spider";
                        }
                    }

                } else {
                    boardArrays[row][col] = "null";
                }
            }
        }
        return boardArrays;

    }

    /**
     * Extend The String Board From (line x column) size to ((line x 4)x column)
     * size
     *
     * @param sBoard the initial board of the game
     * @return new extend board with more line
     */
    private String[][] boardExtend(String[][] sBoard) {
        String[][] board = new String[sBoard.length * 4][sBoard[0].length];
        changeNull(board);
        assignedArrays(sBoard, board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                switch (board[i][j]) {
                    case "Spider":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "Snail":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "GRASS":
                        board[i - 1][j] = "GRASS_T";
                        board[i + 1][j] = "GRASS_T_D";
                        break;
                    case "STAR":
                        board[i - 1][j] = "STAR_T";
                        board[i + 1][j] = "STAR_T_D";
                        break;
                    default:
                        break;
                }

            }

        }

        return board;
    }

    /**
     * Full out each respective part of the extend board
     *
     * @param sBoard initial board
     * @param board extend board
     */
    private void assignedArrays(String[][] sBoard, String[][] board) {
        int index = 1;
        for (String[] sBoard1 : sBoard) {
            board[index] = sBoard1;
            index += 3;
        }
    }

    /**
     * Change the null value of the extend board to avoie nullPointeurException
     *
     * @param tab extend board
     */
    private void changeNull(String[][] tab) {
        for (String[] tab1 : tab) {
            for (int j = 0; j < tab1.length; j++) {
                tab1[j] = "nothing";
            }
        }
    }

    /**
     * Return a boolean if an animal is present
     *
     * @param position that need to be check
     * @param animals of the game
     * @return boolean true if animal is present false if not
     */
    private boolean animalIsPresent(Position position, Animal... animals) {
        int i = 0;
        boolean found = false;
        while (i < animals.length && !found) {
            if (animals[i].getPositionOnBoard().equals(position)) {

                found = true;
            }
            i++;

        }
        return found;
    }

    /**
     * Display a an error message if occure
     *
     * @param message of the error
     */
    @Override
    public void displayError(String message) {
        System.err.print(TerminalColor.toRed(message));
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
     * @return input which is string that determine the direction of the animal
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
     * @param input of the user
     * @return boolean if correct true and false if not
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
