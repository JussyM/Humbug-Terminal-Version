package g53554.humbug.model;

/**
 *
 * @author jj
 */
public class GrassHopper extends Animal {

    /**
     * GrassHopper Constructor
     *
     * @param positionOnBoard of the animal on the board
     */
    public GrassHopper(Position positionOnBoard) {
        super(positionOnBoard);

    }

    /**
     * return a new postion of the grassHopper according to the direction if a
     * animal can stop him if any animal can't stop him the method return null
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
