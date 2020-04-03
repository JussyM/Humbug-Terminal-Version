package g53554.humbug.model;

/**
 * Square on the board. A square has a type grass or star and it’s all. A square
 * doesn’t know where it is on the board.
 *
 * @author jj
 */
public class Square {

    private SquareType type;

    /**
     * Constructor of the square on the board
     *
     * @param type determine if the squre is GRASS or STAR
     */
    public Square(SquareType type) {
        this.type = type;
    }

    /**
     * Getter of the type
     *
     * @return type of the square
     */
    public SquareType getType() {
        return type;
    }

    /**
     * setter for type
     *
     * @param type new type of the square
     */
    public void setType(SquareType type) {
        this.type = type;
    }

}
