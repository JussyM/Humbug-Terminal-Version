package g53554.humbug.model;

import static g53554.humbug.model.SquareType.*;

/**
 * The board contains squares that may have animal or not It represented by an
 * arrays of two dimensions
 *
 * @author jj
 */
public class Board {

    private Square[][] squares;

    /**
     * Board constructor
     *
     * @param squares
     */
    public Board(Square[][] squares) {
        this.squares = squares;
    }

    /**
     * return a new board of 3 row and 3 column with some SquareType initialized
     * at some certain position according to the first level of the game
     *
     * @return board
     */
    public static Board getInitBoard() {
        Board board = new Board(new Square[][]{
            {new Square(GRASS), new Square(GRASS), null},
            {null, new Square(GRASS), new Square(GRASS)},
            {null, null, new Square(STAR)}
        });
        return board;
    }

    /**
     * return a boolean true if the squareType is a star but false if not
     *
     * @param position
     * @return boolean
     */
    public boolean isInside(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("La postion est null  On ne peut"
                    + " pas savoir si le squareType est une Star ou pas");
        }
        if (position.getRow() < 0 || position.getRow() > squares.length) {
            return false;

        }
        if (position.getColumn() < 0
                || position.getColumn() > squares[position.getRow()].length) {
            return false;

        }
        if (squares[position.getRow()][position.getColumn()] == null) {
            return false;
        }
        return squares[position.getRow()][position.getColumn()].getType()
                == SquareType.GRASS;

    }

    /**
     * return the squareType at the position given as args
     *
     * @param position
     * @return SquareType
     */
    public SquareType getSquareType(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("La position est null donc on ne"
                    + " peut pas préciser le SquareType");
        }
        if (squares[position.getRow()][position.getColumn()] == null) {
            throw  new IllegalArgumentException("");
        }

        return squares[position.getRow()][position.getColumn()].getType();
    }

    /**
     * return the number of row on the board
     *
     * @return nbRow
     */
    public int getNbRow() {
        return squares.length;

    }

    /**
     * return the number of column on the board
     *
     * @return nbColumn
     */
    public int getNbColumn() {
        return squares[0].length;

    }
}
