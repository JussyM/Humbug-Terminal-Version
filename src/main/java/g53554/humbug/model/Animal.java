package g53554.humbug.model;

/**
 * these are the animal that will be on the board an animal know where he is on
 * the board but do not know were is the star
 *
 * @author jj
 */
public abstract class Animal {

    private Position positionOnBoard;
    private boolean onStar;

    /**
     * Simple constructor of Animal
     *
     * @param positionOnBoard is the position of the animals on the board
     */
    public Animal(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
        this.onStar = false;
    }

    /**
     * Getter for Postion
     *
     * @return positionOnBoard
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * getter for onStar
     *
     * @return onStar
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * Setter for onStar
     *
     * @param onStar boolean that change the attribut
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }

    /**
     * Setter for Position on board
     *
     * @param positionOnBoard is the position of the animals on the board
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * This method will help the animal to move on the board this method return
     * the new position of the animal if he move but if he is block the will
     * return his old position but if he move and fall out of the board the
     * position will return null
     *
     * @param board of the game 
     * @param direction of the animals
     * @param animals arrays of the animals of the game 
     * @return new position
     */
    public abstract Position move(Board board,
            Direction direction, Animal... animals);

}
