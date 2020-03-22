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
     * @param positionOnBoard
     */
    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * return a new postion of the spider according to the direction if a animal
     * can stop him if any animal can't stop him the method return null
     *
     * @param board
     * @param direction
     * @param animals
     * @return new position or null
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animals) {
        Position spiderPos = super.getPositionOnBoard();
        Position[] spiderPacours = spiderParcours(board, direction, spiderPos); // return all the position of the spider in an array
        Position spiderNextPosition = allPositionAreFree(spiderPacours, animals);
        if (spiderNextPosition == null) {
            super.setPositionOnBoard(null);
            return null;
        } else {
            if (board.isInside(spiderNextPosition)
                    && board.getSquareType(spiderNextPosition)
                    == SquareType.GRASS
                    && isSquareisFree(spiderNextPosition, animals)) {
                return spiderNextPosition;

            } else if (board.isInside(spiderNextPosition)
                    && board.getSquareType(spiderNextPosition)
                    == SquareType.STAR) {
                super.setOnStar(true);
                super.setPositionOnBoard(spiderNextPosition);
                board.setOnGrass(spiderNextPosition);
                return super.getPositionOnBoard();
            } else if (board.isInside(spiderNextPosition)
                    && board.getSquareType(spiderNextPosition)
                    == SquareType.GRASS
                    && !isSquareisFree(spiderNextPosition, animals)) {
                return spiderPos;

            }
        }

        return null;
    }

    /**
     * Return an arrays of all the spider position according to a direction
     *
     * @param board
     * @param direction
     * @param spiderPosActuelle
     * @return arrays of position
     */
    private Position[] spiderParcours(Board board,
            Direction direction, Position spiderPosActuelle) {
        Position[] spider = new Position[board.getNbColumn()];
        for (int i = 0; i < spider.length; i++) {
            spider[i] = spiderPosActuelle.next(direction);
            spiderPosActuelle = spider[i];

        }
        return spider;
    }

    /**
     * return the position of the spider if an animal can stop him
     * or retur null if not
     * @param position
     * @param animal
     * @return position where the spider will stop at 
     */
    private Position allPositionAreFree(Position[] position,
            Animal... animal) {
        for (int i = 0; i < position.length; i++) {
            for (Animal animal1 : animal) {
                if (position[i].equals(animal1.getPositionOnBoard())) {
                    if (i - 1 < 0) {
                        return position[i];
                    }
                    return position[i - 1];
                }
            }
        }

        return null;

    }

    /**
     * return a boolean true if the animal is on the board and false if not
     *
     * @param position
     * @param animal
     * @return found
     */
    private boolean isSquareisFree(Position position, Animal... animal) {
        int i = 0;
        boolean found = true;
        while (i < animal.length && found) {
            if (animal[i].getPositionOnBoard().equals(position)) {
                found = false;
            }
            i++;

        }
        return found;
    }

}
