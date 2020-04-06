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
     * @return positionOnBoard position of the animal on the board
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * getter for onStar
     *
     * @return onStar booolean of animal that verifie if he's out or not
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

    /**
     * return a boolean true if the animal is on the board and false if not
     *
     * @param position is the nextPosition of the animal
     * @param animals arrays of animals
     * @return found boolean true if iit's free and false if not
     */
    protected boolean isFree(Position position, Animal... animals) {
        int i = 0;
        boolean found = true;
        while (i < animals.length && found) {
            if (animals[i].getPositionOnBoard().equals(position)) {
                found = false;
            }
            i++;

        }
        return found;
    }

    /**
     * return the position of the spider if an animal can stop him or retur null
     * if not
     *
     * @param position arrays of all the position of the spider
     * @param animals arrays of the animals
     * @return position where the spider will stop at
     */
    protected Position allPositionAreFree(Position[] position,
            Animal... animals) {
        for (int i = 0; i < position.length; i++) {
            for (Animal animal1 : animals) {
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
     * Verifie if the animal on the next Square of the board must still be on
     * the board if yes return false or true Simply verify if the animal boolean
     * is true of false
     *
     * @param position nextPosition that need to be compare
     * @param animals arrays of the animals
     * @return boolean found true/false
     */
    protected boolean animalsIsOnStar(Position position, Animal... animals) {
        int i = 0;
        boolean found = false;
        while (i < animals.length && !found) {
            if (animals[i].getPositionOnBoard().equals(position)
                    && animals[i].isOnStar()) {
                found = true;
            }
            i++;
        }
        return found;
    }

    /**
     * Return the animal on the next Square
     *
     * @param position next position
     * @param animals arrays of animals
     * @return animal at the next Square
     */
    protected Animal animalOnNextSquare(Position position, Animal... animals) {
        Animal animalNext = null;
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position)) {
                animalNext = animal;
            }
        }
        return animalNext;
    }

    /**
     * verify if the position is inside the board
     *
     * @param board of the game
     * @param position of the animal
     * @return true if is inside and false if not
     */
    protected boolean isInside(Board board, Position position) {
        return board.isInside(position);
    }

    /**
     * verify if the position board is inside and free
     *
     * @param board of the game
     * @param position next Position of the animal
     * @param animals arrays of all the animals
     * @return true / false
     */
    protected boolean insideAndFreeGrass(Board board, Position position,
            Animal... animals) {
        return isInside(board, position)
                && board.getSquareType(position) == SquareType.GRASS
                && isFree(position, animals);

    }

    /**
     * verify if the position board is inside and star
     *
     * @param board of the game
     * @param position next Position of the animal
     * @param animals arrays of all the animals
     * @return true / false
     */
    protected boolean insideAndStar(Board board, Position position,
            Animal... animals) {
        return isInside(board, position)
                && board.getSquareType(position) == SquareType.STAR;

    }

}
