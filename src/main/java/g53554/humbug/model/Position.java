package g53554.humbug.model;

/**
 * Position on the board it help us to how where we are on the board
 *
 * @author jj
 */
public class Position {

    private final int row;
    private final int column;

    /**
     * Constructor of Position with row and column as argument
     *
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter for column
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Getter for row
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * hashCode for position
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.row;
        hash = 19 * hash + this.column;
        return hash;
    }

    /**
     * Equals method for position
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        return this.column == other.column;
    }

    /**
     * Return a position according to the direction giving as argument
     *
     * @param direction
     * @return position
     */
    public Position next(Direction direction) {
        return new Position(direction.getDeltaRow() + row,
                direction.getDeltaColumn() + column);
    }

}
