package g53554.humbug.model;

/**
 * This class represent the Spider that move on the board while their's no
 * barriers
 *
 * @author jj
 */
public class Spider extends Animal {

    /**
     *
     * @param positionOnBoard
     */

    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     *
     * @param board
     * @param direction
     * @param animals
     * @return
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position newPos = new Position(0, 0);
        
        return null;
    }

}
