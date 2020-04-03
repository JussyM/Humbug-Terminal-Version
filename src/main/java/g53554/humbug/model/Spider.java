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
        Position spiderPos = super.getPositionOnBoard();
        Position[] spiderPacours = null;
        switch (direction) {
            case EAST:
                spiderPacours = spiderParcoursCol(board, direction, spiderPos);
                break;
            case WEST:
                spiderPacours = spiderParcoursCol(board, direction, spiderPos);
                break;
            case SOUTH:
                spiderPacours = spiderParcoursRow(board, direction, spiderPos);
                break;
            case NORTH:
                spiderPacours = spiderParcoursRow(board, direction, spiderPos);
                break;

        }
        Position spiderNextPosition = allPositionAreFree(spiderPacours,
                animals);

        if (spiderNextPosition == null) {
            super.setPositionOnBoard(null);
            return null;
        }
        if (board.isInside(spiderNextPosition)
                && board.getSquareType(spiderNextPosition)
                == SquareType.GRASS
                && isFree(spiderNextPosition, animals)) {
            super.setPositionOnBoard(spiderNextPosition);
            return super.getPositionOnBoard();

        }
        if (board.isInside(spiderNextPosition)
                && board.getSquareType(spiderNextPosition)
                == SquareType.STAR) {
            super.setOnStar(true);
            super.setPositionOnBoard(spiderNextPosition);
            board.setOnGrass(spiderNextPosition);
            return super.getPositionOnBoard();
        }
        if (board.isInside(spiderNextPosition)
                && board.getSquareType(spiderNextPosition)
                == SquareType.GRASS
                && !isFree(spiderNextPosition, animals)
                && !animalsIsOnStar(spiderNextPosition, animals)) {
            return spiderPos;

        }
        if (board.isInside(spiderNextPosition)
                && board.getSquareType(spiderNextPosition)
                == SquareType.GRASS
                && !isFree(spiderNextPosition, animals)
                && animalsIsOnStar(spiderNextPosition, animals)) {
            super.setPositionOnBoard(spiderNextPosition);
            animalOnNextSquare(spiderNextPosition, animals)
                    .setPositionOnBoard(null);
            return super.getPositionOnBoard();
        }

        return null;
    }

    /**
     * Return an arrays of all the spider column position according to a
     * direction
     *
     * @param board of the game
     * @param direction of the animal next position
     * @param spiderPosActuelle Position of the spider
     * @return arrays of position
     */
    private Position[] spiderParcoursCol(Board board,
            Direction direction, Position spiderPosActuelle) {
        Position[] spider = new Position[board.getNbColumn()];
        for (int i = 0; i < spider.length; i++) {
            spider[i] = spiderPosActuelle.next(direction);
            spiderPosActuelle = spider[i];

        }
        return spider;
    }

    /**
     * Return an arrays of all the spider row position according to a direction
     *
     * @param board of the game
     * @param direction of the animal next position
     * @param spiderPosActuelle Position of the spider
     * @return arrays of position
     */
    private Position[] spiderParcoursRow(Board board,
            Direction direction, Position spiderPosActuelle) {
        Position[] spider = new Position[board.getNbRow()];
        for (int i = 0; i < spider.length; i++) {
            spider[i] = spiderPosActuelle.next(direction);
            spiderPosActuelle = spider[i];

        }
        return spider;
    }

}
