package g53554.humbug.model;

/**
 * Direction will determine where the animal will move to we will use the four
 * cardinal point to determine the direction
 *
 * @author jj
 */
public enum Direction {
    NORTH(-1, 0), SOUTH(1, 0), EAST(0, 1), WEST(0, -1);
    private int deltaRow;
    private int deltaColumn;

    /**
     * Getter for deltaColumn
     *
     * @return detaColumn
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

    /**
     * Getter for deltaRow
     *
     * @return deltaRow
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Private Constructor of Direction
     *
     * @param deltaRow
     * @param deltaColumn
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

}
