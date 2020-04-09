package g53554.humbug.model;

/**
 * Square on the board. A square has a type grass or star and it’s all. A square
 * doesn’t know where it is on the board.
 *
 * @author jj
 */
public class Square {

    private SquareType type;
    private boolean northWall;
    private boolean eastWall;
    private boolean southWall;
    private boolean westWall;

    /**
     * Constructor of the square on the board
     *
     * @param type determine if the squre is GRASS or STAR
     */
    public Square(SquareType type) {
        this.type = type;
        this.northWall = false;
        this.eastWall = false;
        this.southWall = false;
        this.westWall = false;
    }

    /**
     * Default square constructorgetter for each attribut of square
     */
    public Square() {
    }

    /**
     * Setter for northWall
     *
     * @param northWall boolean that change the attribut
     */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    /**
     * Setter for eastWall
     *
     * @param eastWall boolean that change the attribut
     */
    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    /**
     * Setter for southWall
     *
     * @param southWall boolean that change the attribut
     */
    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * Setter for westWall
     *
     * @param westWall boolean that change the attribut
     */
    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }

    /**
     * Getter of the type
     *
     * @return type of the square
     */
    public SquareType getType() {
        return type;
    }

    /**
     * setter for type
     *
     * @param type new type of the square
     */
    public void setType(SquareType type) {
        this.type = type;
    }

    /**
     * Verify if the direction has wall or not
     *
     * @param direction given as args
     * @return boolean true /false
     */
    public boolean hasWall(Direction direction) {
        switch (direction) {
            case NORTH:
                return northWall;
            case SOUTH:
                return southWall;
            case EAST:
                return eastWall;
            case WEST:
                return westWall;
        }
        return false;

    }

    /**
     * getter for each attribut of square
     *
     * @return northWall attribut
     */
    public boolean isNorthWall() {
        return northWall;
    }

    /**
     * getter for each attribut of square
     *
     * @return eastWall attribut
     */
    public boolean isEastWall() {
        return eastWall;
    }

    /**
     * getter for each attribut of square
     *
     * @return southWall attribut
     */
    public boolean isSouthWall() {
        return southWall;
    }

    /**
     * getter for each attribut of square
     *
     * @return westWall attribut
     */
    public boolean isWestWall() {
        return westWall;
    }

}
