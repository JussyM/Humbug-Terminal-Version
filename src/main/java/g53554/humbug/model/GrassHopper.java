package g53554.humbug.model;

/**
 *
 * @author jj
 */
public class GrassHopper extends Animal {

    /**
     *
     * @param positionOnBoard
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
        var grassHopperNextPosition = animalsNextPosition(board,
                direction, animals);
        if (grassHopperNextPosition == null) {
            super.setPositionOnBoard(null);
            return null;
        }
        if (positionAreEquals(grassHopperNextPosition)) {
            return super.getPositionOnBoard();
        } else {
            if (!isInside(board, grassHopperNextPosition)) {
                super.setPositionOnBoard(null);
                return null;
            }
            if (insideAndFreeGrass(board, grassHopperNextPosition,
                    direction, animals)) {
                super.setPositionOnBoard(grassHopperNextPosition);
                return super.getPositionOnBoard();

            }

            if (insideAndStar(board, grassHopperNextPosition,
                    direction, animals)) {
                setAnimalState(grassHopperNextPosition, board);
                return super.getPositionOnBoard();
            }

            if (!insideAndFreeGrass(board, grassHopperNextPosition,
                    direction, animals)
                    && !animalsIsOnStar(grassHopperNextPosition, animals)) {
                return super.getPositionOnBoard();

            }
            if (!insideAndFreeGrass(board, grassHopperNextPosition,
                    direction, animals)
                    && animalsIsOnStar(grassHopperNextPosition, animals)) {
                setAnimalStates(grassHopperNextPosition, animals);
                return super.getPositionOnBoard();
            }

        }

        return null;
    }

}
