package g53554.humbug.model;

/**
 *
 * @author jj
 */
public class Butterfly extends Animal {

    /**
     *
     * @param positionOnBoard
     */
    public Butterfly(Position positionOnBoard) {
        super(positionOnBoard);
    }

    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return null;
    }

}
