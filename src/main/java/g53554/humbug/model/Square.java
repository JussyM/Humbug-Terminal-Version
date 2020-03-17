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
     * @param type
     */
    public Square(SquareType type) {
        this.type = type;
    }

    /**
     * Getter of the type
     *
     * @return type
     */
    public SquareType getType() {
        return type;
    }

    
}
