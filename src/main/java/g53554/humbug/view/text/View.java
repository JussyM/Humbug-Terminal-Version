package g53554.humbug.view.text;

import g53554.humbug.model.*;
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
        String[][] boardArrays = boardExtend(initBoard(board, animals));
        printColPosition(boardArrays[0]);
        System.out.println("");
        System.out.println("");
        displayBoardMethod(boardArrays);

    }

    /**
     * DisplayBoard Code
     *
     * @param boardArrays is the board of the game converted to arrays of String
     * for the print
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
                        case "grass_up":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "grass_dwn":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;

                        case "grass_right":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{#  }" + TerminalColor.toDefault);
                            break;
                        case "grass_left":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{  #}" + TerminalColor.toDefault);
                            break;

                        case "STAR":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ * }" + TerminalColor.toDefault);
                            break;
                        case "SNAIL":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ E }" + TerminalColor.toDefault);

                            break;
                        case "snail_up":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ E }" + TerminalColor.toDefault);
                            break;
                        case "snail_dwn":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ E }" + TerminalColor.toDefault);
                            break;
                        case "snail_right":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{#E }" + TerminalColor.toDefault);
                            break;
                        case "snail_left":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ E#}" + TerminalColor.toDefault);
                            break;
                        case "SPIDER":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ A }" + TerminalColor.toDefault);

                            break;
                        case "spider_up":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ A }" + TerminalColor.toDefault);
                            break;
                        case "spider_dwn":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ A }" + TerminalColor.toDefault);
                            break;
                        case "spider_right":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{#A }" + TerminalColor.toDefault);
                            break;
                        case "spider_left":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ A#}" + TerminalColor.toDefault);
                            break;
                        case "GRASSHOPPER":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ G }" + TerminalColor.toDefault);

                            break;
                        case "GRASSHOPPER_T":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);

                            break;
                        case "grassHopper_up":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ G }" + TerminalColor.toDefault);
                            break;
                        case "grassHopper_dwn":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ G }" + TerminalColor.toDefault);
                            break;
                        case "grassHopper_right":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{#G }" + TerminalColor.toDefault);
                            break;
                        case "grassHopper_left":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ G#}" + TerminalColor.toDefault);
                            break;
                        case "GRASSHOPPER_T_D":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);

                            break;
                        case "LADYBIRD":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ L }" + TerminalColor.toDefault);

                            break;
                        case "LADYBIRD_T":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "LADYBIRD_T_D":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "ladyBird_up":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ L }" + TerminalColor.toDefault);
                            break;
                        case "ladyBird_dwn":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ L }" + TerminalColor.toDefault);
                            break;
                        case "ladyBird_right":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{#L }" + TerminalColor.toDefault);
                            break;
                        case "ladyBird_left":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ L#}" + TerminalColor.toDefault);
                            break;
                        case "BUMBLEBEE":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ B }" + TerminalColor.toDefault);
                            break;
                        case "BUMBLEBEE_T":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "BUMBLEBEE_T_D":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "bumblebee_up":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ B }" + TerminalColor.toDefault);
                            break;
                        case "bumblebee_dwn":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ B }" + TerminalColor.toDefault);
                            break;
                        case "bumblebee_right":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{#B }" + TerminalColor.toDefault);
                            break;
                        case "bumblebee_left":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ B#}" + TerminalColor.toDefault);
                            break;
                        case "BUTTERFLY":
                            System.out.print(TerminalColor.YELLOW_BACKGROUND
                                    + "{ P }" + TerminalColor.toDefault);
                            break;
                        case "BUTTERFLY_T":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "BUTTERFLY_T_D":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{   }" + TerminalColor.toDefault);
                            break;
                        case "butterfly_up":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ P }" + TerminalColor.toDefault);
                            break;
                        case "butterfly_dwn":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ P }" + TerminalColor.toDefault);
                            break;
                        case "butterfly_right":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{#P }" + TerminalColor.toDefault);
                            break;
                        case "butterfly_left":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ P#}" + TerminalColor.toDefault);
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
                        case "star_up":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ * }" + TerminalColor.toDefault);
                            break;
                        case "star_dwn":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ * }" + TerminalColor.toDefault);
                            break;
                        case "star_right":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{#* }" + TerminalColor.toDefault);
                            break;
                        case "star_left":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ *#}" + TerminalColor.toDefault);
                            break;
                        case "GRASS_A_T_up":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ # }" + TerminalColor.toDefault);
                            break;
                        case "GRASS_A_T_D_dwn":
                            System.out.print(TerminalColor.toDefault
                                    + TerminalColor.YELLOW_BACKGROUND
                                    + "{ # }" + TerminalColor.toDefault);
                            break;

                        default:
                            System.out.print(TerminalColor.WHITE_BACKGROUND
                                    + "     " + TerminalColor.toDefault);
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
     * @return boolean true if empty false if not
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
            case 16:
                System.out.printf(" " + TerminalColor.CYAN_BACKGROUND + "[%02d]"
                        + TerminalColor.toDefault, 5);
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
                boolean hasWall = hasWall(position, board);
                if (!hasWall) {
                    displayNoWall(board, boardArrays, position, animalIsPresent,
                            row, col,
                            animals);

                } else {
                    displayWithWall(board, boardArrays,
                            position, animalIsPresent, row, col, animals);
                }

            }
        }
        return boardArrays;

    }

    /**
     * Insert each value according to the position with a board without wall
     *
     * @param board of the game
     * @param boardArrays arrays of String that will printOut the game
     * @param position each square position
     * @param animalIsPresent boolean that determine if animal is present or not
     * @param row position row
     * @param col position column
     * @param animals arrays that contain all the animal of the game
     */
    private void displayNoWall(Board board, String[][] boardArrays,
            Position position,
            boolean animalIsPresent, int row, int col, Animal... animals) {
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
                    boardArrays[row][col] = "SNAIL";
                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Spider) {
                    boardArrays[row][col] = "SPIDER";
                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Grasshopper) {
                    boardArrays[row][col] = "GRASSHOPPER";

                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Ladybird) {
                    boardArrays[row][col] = "LADYBIRD";
                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Bumbelbee) {
                    boardArrays[row][col] = "BUMBLEBEE";

                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Butterfly) {
                    boardArrays[row][col] = "BUTTERFLY";

                }
            }
        } else {
            boardArrays[row][col] = "null";
        }

    }

    /**
     * Insert each value according to the position with a board with wall
     *
     * @param board of the game
     * @param boardArrays arrays of String that will printOut the game
     * @param position each square position
     * @param animalIsPresent boolean that determine if animal is present or not
     * @param row position row
     * @param col position column
     * @param animals arrays that contain all the animal of the game
     */
    private void displayWithWall(Board board, String[][] boardArrays,
            Position position,
            boolean animalIsPresent, int row, int col, Animal... animals) {
        char wall = squareHasWall(board, position);
        if (board.isInside(position)
                && board.getSquareType(position) == SquareType.STAR
                && !animalIsPresent) {
            switch (wall) {
                case 'N':
                    boardArrays[row][col] = "star_up";
                    break;
                case 'S':
                    boardArrays[row][col] = "star_dwn";
                    break;
                case 'E':
                    boardArrays[row][col] = "star_left";
                    break;
                case 'W':
                    boardArrays[row][col] = "star_right";
                    break;
                default:
                    boardArrays[row][col] = "STAR";
                    break;
            }

        } else if (board.isInside(position)
                && board.getSquareType(position) == SquareType.GRASS
                && !animalIsPresent) {
            switch (wall) {
                case 'N':
                    boardArrays[row][col] = "grass_up";
                    break;
                case 'S':
                    boardArrays[row][col] = "grass_dwn";
                    break;
                case 'E':
                    boardArrays[row][col] = "grass_left";
                    break;
                case 'W':
                    boardArrays[row][col] = "grass_right";
                    break;
                default:
                    boardArrays[row][col] = "GRASS";
                    break;
            }

        } else if (board.isInside(position)
                && board.getSquareType(position) == SquareType.GRASS
                && animalIsPresent) {
            for (Animal animal1 : animals) {
                if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Snail) {
                    switch (wall) {
                        case 'N':
                            boardArrays[row][col] = "snail_up";
                            break;
                        case 'S':
                            boardArrays[row][col] = "snail_dwn";
                            break;
                        case 'E':
                            boardArrays[row][col] = "snail_left";
                            break;
                        case 'W':
                            boardArrays[row][col] = "snail_right";
                            break;
                        default:
                            boardArrays[row][col] = "SNAIL";
                            break;
                    }

                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Spider) {
                    switch (wall) {
                        case 'N':
                            boardArrays[row][col] = "spider_up";
                            break;
                        case 'S':
                            boardArrays[row][col] = "spider_dwn";
                            break;
                        case 'E':
                            boardArrays[row][col] = "spider_left";
                            break;
                        case 'W':
                            boardArrays[row][col] = "spider_right";
                            break;
                        default:
                            boardArrays[row][col] = "SPIDER";
                            break;
                    }
                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Grasshopper) {
                    switch (wall) {
                        case 'N':
                            boardArrays[row][col] = "grassHopper_up";
                            break;
                        case 'S':
                            boardArrays[row][col] = "grassHopper_dwn";
                            break;
                        case 'E':
                            boardArrays[row][col] = "grassHopper_left";
                            break;
                        case 'W':
                            boardArrays[row][col] = "grassHopper_right";
                            break;
                        default:
                            boardArrays[row][col] = "GRASSHOPPER";
                            break;
                    }

                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Ladybird) {
                    switch (wall) {
                        case 'N':
                            boardArrays[row][col] = "ladyBird_up";
                            break;
                        case 'S':
                            boardArrays[row][col] = "ladyBird_dwn";
                            break;
                        case 'E':
                            boardArrays[row][col] = "ladyBird_left";
                            break;
                        case 'W':
                            boardArrays[row][col] = "ladyBird_right";
                            break;
                        default:
                            boardArrays[row][col] = "LADYBIRD";
                            break;
                    }
                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Bumbelbee) {
                    switch (wall) {
                        case 'N':
                            boardArrays[row][col] = "bumblebee_up";
                            break;
                        case 'S':
                            boardArrays[row][col] = "bumblebee_dwn";
                            break;
                        case 'E':
                            boardArrays[row][col] = "bumblebee_left";
                            break;
                        case 'W':
                            boardArrays[row][col] = "bumblebee_right";
                            break;
                        default:
                            boardArrays[row][col] = "BUMBLEBEE";
                            break;
                    }

                } else if (animal1.getPositionOnBoard().equals(position)
                        && animal1 instanceof Butterfly) {
                    switch (wall) {
                        case 'N':
                            boardArrays[row][col] = "butterfly_up";
                            break;
                        case 'S':
                            boardArrays[row][col] = "butterfly_dwn";
                            break;
                        case 'E':
                            boardArrays[row][col] = "butterfly_left";
                            break;
                        case 'W':
                            boardArrays[row][col] = "butterfly_right";
                            break;
                        default:
                            boardArrays[row][col] = "BUTTERFLY";
                            break;
                    }

                }

            }

        } else {
            boardArrays[row][col] = "null";
        }
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
                    case "SPIDER":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "spider_right":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "spider_left":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "spider_up":
                        board[i - 1][j] = "GRASS_A_T_up";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "spider_dwn":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D_dwn";
                        break;

                    case "SNAIL":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "snail_right":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "snail_left":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "snail_up":
                        board[i - 1][j] = "GRASS_A_T_up";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "snail_dwn":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D_dwn";
                        break;

                    case "GRASS":
                        board[i - 1][j] = "GRASS_T";
                        board[i + 1][j] = "GRASS_T_D";
                        break;
                    case "grass_right":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "grass_left":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "grass_up":
                        board[i - 1][j] = "GRASS_A_T_up";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "grass_dwn":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D_dwn";
                        break;
                    case "STAR":
                        board[i - 1][j] = "STAR_T";
                        board[i + 1][j] = "STAR_T_D";
                        break;
                    case "star_right":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "star_left":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "star_up":
                        board[i - 1][j] = "GRASS_A_T_up";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "star_dwn":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D_dwn";
                        break;
                    case "GRASSHOPPER":
                        board[i - 1][j] = "GRASSHOPPER_T";
                        board[i + 1][j] = "GRASSHOPPER_T_D";
                        break;
                    case "grassHopper_right":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "grassHopper_left":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "grassHopper_up":
                        board[i - 1][j] = "GRASS_A_T_up";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "grassHopper_dwn":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D_dwn";
                        break;
                    case "LADYBIRD":
                        board[i - 1][j] = "LADYBIRD_T";
                        board[i + 1][j] = "LADYBIRD_T_D";
                        break;
                    case "ladyBird_right":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "ladyBird_left":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "ladyBird_up":
                        board[i - 1][j] = "GRASS_A_T_up";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "ladyBird_dwn":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D_dwn";
                        break;
                    case "BUMBLEBEE":
                        board[i - 1][j] = "BUMBLEBEE_T";
                        board[i + 1][j] = "BUMBLEBEE_T_D";
                        break;
                    case "bumblebee_right":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "bumblebee_left":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "bumblebee_up":
                        board[i - 1][j] = "GRASS_A_T_up";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "bumblebee_dwn":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D_dwn";
                        break;
                    case "BUTTERFLY":
                        board[i - 1][j] = "BUTTERFLY_T";
                        board[i + 1][j] = "BUTTERFLY_T_D";
                        break;
                    case "butterfly_right":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "butterfly_left":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "butterfly_up":
                        board[i - 1][j] = "GRASS_A_T_up";
                        board[i + 1][j] = "GRASS_A_T_D";
                        break;
                    case "butterfly_dwn":
                        board[i - 1][j] = "GRASS_A_T";
                        board[i + 1][j] = "GRASS_A_T_D_dwn";
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
     * Change the null value of the extend board to avoid nullPointeurException
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
     * Ask the position to the user
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
     * Ask a direction and return a direction given by the user
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

    /**
     * Display win message
     */
    @Override
    public void displayWinner() {
        System.out.println(TerminalColor.toBlue("WIN"));
    }

    /**
     * return a boolean if a squaree hasWall
     *
     * @param position at a certain position on the board
     * @param board of the game
     * @return true or false;
     */
    private boolean hasWall(Position position, Board board) {
        Square[][] boardSquare = board.getSquares();
        if (board.isInside(position)) {
            return boardSquare[position.getRow()][position.getColumn()].
                    isEastWall()
                    || boardSquare[position.getRow()][position.getColumn()].
                            isNorthWall()
                    || boardSquare[position.getRow()][position.getColumn()].
                            isSouthWall()
                    || boardSquare[position.getRow()][position.getColumn()].
                            isWestWall();
        }
        return false;
    }

    /**
     * return a caracter that dertermine which direction wall the square has
     *
     * @param board of the game
     * @param position of the square
     * @return caracter according to the direction
     */
    private char squareHasWall(Board board, Position position) {
        Square[][] boardSquare = board.getSquares();
        boolean[] arraysWalls = {boardSquare[position.getRow()][position.
            getColumn()].
            isEastWall(), boardSquare[position.getRow()][position
            .getColumn()].
            isNorthWall(),
            boardSquare[position.getRow()][position.getColumn()].
            isSouthWall(),
            boardSquare[position.getRow()][position.getColumn()].
            isWestWall()};
        if (arraysWalls[0]) {
            return 'E';
        }
        if (arraysWalls[1]) {
            return 'N';
        }
        if (arraysWalls[2]) {
            return 'S';
        }
        if (arraysWalls[3]) {
            return 'W';
        }
        return 0;
    }

    /**
     * Display the number of moves remaining for game
     *
     * @param getMoves number of moves remains
     */
    @Override
    public void displayremainingMove(int getMoves) {
        System.out.println("Nombre de déplacement: " + getMoves + "\n");
    }

}
