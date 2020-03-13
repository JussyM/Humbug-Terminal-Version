package g53554.humbug.model;

/**
 * Direction will determine where the animal will move to we will use the four
 * cardinal point to determine the direction
 *
 * @author jj
 */
public enum Direction {
    NORTH, SOUTH, EAST, WEST;
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

}
