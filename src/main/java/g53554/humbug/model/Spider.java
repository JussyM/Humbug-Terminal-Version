package g53554.humbug.model;

/**
 * This class represent the Spider that move on the board while their's no
 * barriers or animal to stop him
 *
 * @author jj
 */
public class Spider extends Animal {

    /**
     * simple spider constructor
     *
     * @param positionOnBoard of animals on the board
     */
    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Default spider constructor
     */
    public Spider() {
        super();
    }

    /**
     * return a new postion of the spider according to the direction if a animal
     * can stop him if any animal can't stop him the method return null
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays of animals
     * @return new position or null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        return animalsMove(board, direction, animals);

    }

}
