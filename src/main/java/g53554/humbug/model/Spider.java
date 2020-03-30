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
                && isSquareisFree(spiderNextPosition, animals)) {
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
                && !isSquareisFree(spiderNextPosition, animals)) {
            return spiderPos;

        }

        return null;
    }

    /**
     * Return an arrays of all the spider column position according to a
     * direction
     *
     * @param board
     * @param direction
     * @param spiderPosActuelle
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
     * @param board
     * @param direction
     * @param spiderPosActuelle
     * @return array of position
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

    /**
     * return the position of the spider if an animal can stop him or retur null
     * if not
     *
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
