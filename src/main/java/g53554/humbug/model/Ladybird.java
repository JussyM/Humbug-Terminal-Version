package g53554.humbug.model;

/**
 *
 * @author jj
 *
 */
public class Ladybird extends Animal {

    /**
     * LadyBird Constructor
     *
     * @param positionOnBoard position of the ladayBird
     */
    public Ladybird(Position positionOnBoard) {
        super(positionOnBoard);

    }

    /**
     * return a new postion of the LadyBird according to the direction if a
     * animal can stop him  if any animal can't stop him the method return null
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
