package g53554.humbug.model;

/**
 * This class represent the Spider that move on the board while their's no
 * barriers
 *
 * @author jj
 */
public class Spider extends Animal {

    private Position savepos;

    /**
     * simple spider constructor
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
        Position spiderPos = super.getPositionOnBoard();
        Position[] spiderPacours = spiderParcours(board, direction, spiderPos);
        if (isFree(spiderPacours, animals)) {
            super.setPositionOnBoard(null);
            return null;

        } else if (!board.isInside(savepos)) {
            return null;
        } else if (board.isInside(savepos)
                && board.getSquareType(savepos)
                == SquareType.GRASS) {

            return spiderPos = savepos;
        } else if (board.isInside(savepos)
                && board.getSquareType(savepos)
                == SquareType.STAR) {
            super.setOnStar(true);
            super.setPositionOnBoard(savepos);
            board.setOnGrass(savepos);
            return super.getPositionOnBoard();

        }
        return null;
    }

    /**
     * Return an araays of all the spider position according to a direction
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
     *
     * @param position
     * @param animal
     * @return
     */
    private boolean isFree(Position[] position, Animal... animal) {
        Position animalPos;
        boolean found = true;
        int i = 0;
        int j = 0;
        while (i < animal.length && found) {
            animalPos = animal[i].getPositionOnBoard();
            while (j < position.length && found) {
                if (position[j].equals(animalPos)) {
                    savepos = position[j - 1];
                    found = false;
                }

            }
            j++;

        }
        i++;
        return found;

    }

}
