package g53554.humbug.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * these are the animal that will be on the board an animal know where he is on
 * the board but do not know were is the star
 *
 * @author jj
 */
@JsonTypeInfo(use = Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @Type(value = Bumbelbee.class),
    @Type(value = Grasshopper.class),
    @Type(value = Ladybird.class),
    @Type(value = Snail.class),
    @Type(value = Spider.class),})
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
     * default constructor to initialized the animals
     */
    public Animal() {
    }

    /**
     * Getter for Position
     *
     * @return positionOnBoard position of the animal on the board
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * getter for onStar
     *
     * @return onStar boolean of animal that verify if he's out or not
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * Setter for onStar
     *
     * @param onStar boolean that change the attribute
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
     * return a boolean true if an animal is on the next square is on the board
     * and false if not
     *
     * @param position is the nextPosition of the animal
     * @param animals arrays of animals
     * @return found boolean true if iit's free and false if not
     */
    private boolean isFree(Position position, Animal... animals) {
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
     * return the position of the spider if an animal can stop him or return
     * null if not
     *
     * @param position arrays of all the position of the spider
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays of the animals
     * @return position where the spider will stop at
     */
    private Position allPositionAreFree(Position[] position,
            Animal... animals) {
        for (int i = 0; i < position.length; i++) {
            Position instance = position[i];
            for (Animal animal1 : animals) {
                if (instance.equals(animal1.getPositionOnBoard())) {
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
     * Return the position of the spider if a wall can block him
     *
     * @param position arrays of all the next Position of the spider
     * @param board bor of tht game
     * @param direction where the spider is going
     * @return new position
     */
    private Position wallBloc(Position[] position,
            Board board, Direction direction) {
        for (Position position1 : position) {
            int hasWall = hasWall(position1, direction, board);
            int hasWallMove = hasWallMove(position1, direction, board);
            if (hasWall == 1) {
                return positionOnBoard;
            }
            if (hasWallMove == 1) {
                return position1;
            }
            if (hasWallMove == 2) {
                if (directionValue(direction)) {
                    return position1.next(direction.opposite());
                } else {
                    return position1.next(direction.opposite());
                }

            }

        }
        return null;
    }

    /**
     * return true if the direction is north or south
     *
     * @param direction direction of the animal
     * @return true/ false
     */
    private boolean directionValue(Direction direction) {
        return direction == Direction.NORTH || direction == Direction.SOUTH;
    }

    /**
     * Return the animal on the next Square
     *
     * @param position next position
     * @param animals arrays of animals
     * @return animal at the next Square
     */
    private Animal animalOnNextSquare(Position position, Animal... animals) {
        Animal animalNext = null;
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(position)) {
                animalNext = animal;
            }
        }
        return animalNext;
    }

    /**
     * Set the state of the animal who's onStar
     *
     * @param position animal nextPosition
     * @param animals arrays of animal
     */
    private void setAnimalStates(Position position, Animal... animals) {
        animalOnNextSquare(position, animals).setPositionOnBoard(null);
        this.setPositionOnBoard(position);
    }

    /**
     * verify if the position is inside the board
     *
     * @param board of the game
     * @param position of the animal
     * @return true if is inside and false if not
     */
    private boolean isInside(Board board, Position position) {
        return board.isInside(position);
    }

    /**
     * verify if the position board is inside and free
     *
     * @param board of the game
     * @param animalNextPosition next Position of the animal
     * @param direction of the animal
     * @param animals arrays of all the animals
     * @return true / false
     */
    private boolean insideAndFreeGrass(Board board,
            Position animalNextPosition,
            Animal... animals) {
        return isInside(board, animalNextPosition)
                && board.getSquareType(animalNextPosition) == SquareType.GRASS
                && isFree(animalNextPosition, animals);

    }

    /**
     * verify if the position board is inside and star
     *
     * @param board of the game
     * @param position next Position of the animal
     * @return true / false
     */
    private boolean insideAndStar(Board board, Position position) {
        return isInside(board, position)
                && board.getSquareType(position) == SquareType.STAR;

    }

    /**
     * set animal state if it drop on Star square
     *
     * @param position next Position of the animal
     * @param board of the game
     */
    private void setAnimalState(Position position, Board board) {
        this.setOnStar(true);
        this.setPositionOnBoard(position);
        board.setOnGrass(position);
    }

    /**
     * verifie if the square has wall according to the right and the opposite
     * direction
     *
     * @param position next Position of the board
     * @param direction of animal
     * @param board of the game
     * @return true\false
     */
    private int hasWall(Position position, Direction direction,
            Board board) {
        if (board.isInside(position) && board.getSquares()[positionOnBoard.
                getRow()][positionOnBoard.getColumn()].hasWall(direction)) {
            return 1;
        }
        if (board.isInside(position) && board.getSquares()[position.
                getRow()][position.getColumn()].hasWall(direction.
                opposite())) {
            return 2;

        }
        return 0;

    }

    /**
     * verifie if the square has wall according to the right and the opposite
     * direction
     *
     * @param position next Position of the board
     * @param direction of animal
     * @param board of the game
     * @return true\false
     */
    private int hasWallMove(Position position, Direction direction,
            Board board) {
        if (board.isInside(position) && board.getSquares()[position.
                getRow()][position.
                        getColumn()].hasWall(direction)) {
            return 1;

        } else if (board.isInside(position) && board.getSquares()[position.
                getRow()][position.
                        getColumn()].hasWall(direction.opposite())) {
            return 2;
        }
        return 0;

    }

    /**
     * return the next Position of all the animals of the game
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays of animals
     * @return Next Position of the animal
     */
    private Position animalsNextPosition(Board board, Direction direction,
            Animal... animals) {
        Position[] spiderParcours = spiderParcours(direction, board,
                positionOnBoard);
        Position animalNextPosition = null;
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard().equals(positionOnBoard)
                    && animal instanceof Snail) {
                int hasWall = hasWall(positionOnBoard.next(direction),
                        direction, board);
                if (hasWall == 1 || hasWall == 2) {
                    animalNextPosition = positionOnBoard;
                    break;

                } else {
                    animalNextPosition = positionOnBoard.next(direction);
                    break;

                }

            }

            if (animal.getPositionOnBoard().equals(positionOnBoard)
                    && animal instanceof Spider) {
                var spiderNextPos = allPositionAreFree(spiderParcours, animals);
                if (spiderNextPos != null) {
                    if (hasWall(spiderNextPos, direction, board) == 1
                            || hasWall(spiderNextPos, direction, board) == 2) {
                        animalNextPosition = wallBloc(spiderParcours,
                                board, direction);
                        break;
                    } else {
                        animalNextPosition = spiderNextPos;
                        break;
                    }

                } else {
                    spiderNextPos = wallBloc(spiderParcours, board, direction);
                    if (spiderNextPos != null) {
                        animalNextPosition = spiderNextPos;
                        break;
                    } else {
                        animalNextPosition = null;
                        break;
                    }
                }
            }

            if (animal.getPositionOnBoard().equals(positionOnBoard)
                    && animal instanceof Grasshopper) {
                var grassHopperNextpos = grassHopperNextPosition(board,
                        direction, animals);
                if (grassHopperNextpos != null) {
                    var hasWall = hasWall(grassHopperNextpos,
                            direction, board);
                    if (hasWall == 1 || hasWall == 2) {
                        animalNextPosition = grassHopperNextpos;
                        break;

                    } else {
                        animalNextPosition = grassHopperNextpos;
                        break;
                    }

                } else {
                    animalNextPosition = null;
                    break;
                }

            }
            if (animal.getPositionOnBoard().equals(positionOnBoard)
                    && animal instanceof Ladybird) {
                animalNextPosition = ladybirdNextPosition(positionOnBoard,
                        board, direction, animals);
            }
            if (animal.getPositionOnBoard().equals(positionOnBoard)
                    && animal instanceof Bumbelbee) {
                var bumblebeeNextPosition = bumblebeeNextPosition(board,
                        direction, animals);
                if (bumblebeeNextPosition != null) {
                    var hasWall = hasWall(bumblebeeNextPosition, direction, board);
                    if (hasWall == 1 || hasWall == 2) {
                        animalNextPosition = bumblebeeNextPosition;
                        break;
                    } else {
                        animalNextPosition = bumblebeeNextPosition;
                        break;
                    }
                } else {
                    animalNextPosition = null;
                    break;
                }

            }
            if (animal.getPositionOnBoard().equals(positionOnBoard)
                    && animal instanceof Butterfly) {
                var butterflyNextPosition = butterflyNextPosition(board,
                        direction, animals);
                if (butterflyNextPosition != null) {
                    var hasWall = hasWall(butterflyNextPosition, direction, board);
                    if (hasWall == 1 || hasWall == 2) {
                        animalNextPosition = butterflyNextPosition;
                        break;
                    } else {
                        animalNextPosition = butterflyNextPosition;
                        break;
                    }
                } else {
                    animalNextPosition = null;
                    break;
                }
            }

        }
        return animalNextPosition;

    }

    /**
     * Return an arrays of position of the spider according to the direction
     *
     * @param direction of the animal
     * @param board of the game
     * @param position spider position
     * @return array of position
     */
    private Position[] spiderParcours(Direction direction, Board board,
            Position position) {
        Position[] spiderParcour = null;
        switch (direction) {
            case EAST:
                spiderParcour = spiderParcoursCol(board, direction, position);
                break;
            case WEST:
                spiderParcour = spiderParcoursCol(board, direction, position);
                break;
            case SOUTH:
                spiderParcour = spiderParcoursRow(board, direction, position);
                break;
            case NORTH:
                spiderParcour = spiderParcoursRow(board, direction, position);
                break;

        }
        return spiderParcour;

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
        Position[] spider = new Position[board.getNbColumn() - 1];
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
        Position[] spider = new Position[board.getNbRow() - 1];
        for (int i = 0; i < spider.length; i++) {
            spider[i] = spiderPosActuelle.next(direction);
            spiderPosActuelle = spider[i];

        }
        return spider;
    }

    /**
     * Verify if the next Position is Equal to the position on the board
     *
     * @param position nextPosition of the animal
     * @return true/false
     */
    private boolean positionAreEquals(Position position) {
        return position.equals(positionOnBoard);
    }

    /**
     * Return the next Position of the grassHopper
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays of animals
     * @return grassHopper next position
     */
    private Position grassHopperNextPosition(Board board,
            Direction direction, Animal... animals) {

        Position[] grassHopperParcours = spiderParcours(direction,
                board, positionOnBoard);
        for (Position grassHopperPos : grassHopperParcours) {
            if (isInside(board, grassHopperPos)) {
                if (isFree(grassHopperPos, animals)) {

                    return grassHopperPos;

                }

            }

        }

        return null;
    }

    /**
     * Return the next Position of Bumbelbee
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays of animals
     * @return grassHopper next position
     */
    private Position bumblebeeNextPosition(Board board,
            Direction direction, Animal... animals) {
        Position instance = positionOnBoard.next(direction).
                next(direction);
        if (isInside(board, instance)) {
            while (!isFree(instance, animals)
                    && isInside(board, instance)) {
                instance = instance.next(direction);
            }
            return instance;

        } else {
            instance = null;
        }

        return instance;
    }

    /**
     * return the next Position of the butterfly
     *
     * @param board of the game
     * @param direction direction of the butterfly
     * @param animals arrays that contain the animals on the board
     * @return null / new position who's the next position
     */
    private Position butterflyNextPosition(Board board, Direction direction,
            Animal... animals) {
        Position butterflyNextPosition = positionOnBoard.next(direction).
                next(direction).next(direction);
        if (isInside(board, butterflyNextPosition)) {
            if (isFree(butterflyNextPosition, animals)) {

                return butterflyNextPosition;

            } else {

                return butterflyNextPosition.next(direction);

            }
        } else {
            butterflyNextPosition = null;
        }

        return butterflyNextPosition;

    }

    /**
     * return the next position of the lady bird
     *
     * @param position where ladybird is on the board
     * @param board of the game
     * @param direction where the animal is going to
     * @param animals arrays that contain all the animal of the game
     * @return next Position of ladybird
     */
    private Position ladybirdNextPosition(Position position,
            Board board, Direction direction, Animal... animals) {
        var instance = position.next(direction).next(direction);
        if (board.isInside(instance)) {
            if (isFree(instance, animals)) {
                var hasWall = hasWall(instance, direction, board);
                var hasWallMove = hasWallMove(instance, direction, board);
                if (hasWall == 1) {
                    return position;
                }
                if (hasWall == 2) {
                    return position.next(direction);
                }
                if (hasWallMove == 1) {
                    return instance;
                }
                if (hasWallMove == 2) {
                    return position.next(direction);
                }
                if (hasWall == 0 || hasWallMove == 0) {
                    return instance;
                }
            } else {
                instance = position.next(direction);
                if (isFree(instance, animals)) {
                    var hasWall = hasWall(instance, direction, board);
                    var hasWallMove = hasWallMove(instance, direction, board);
                    if (hasWall == 1 || hasWall == 2) {
                        return position;
                    }
                    if (hasWallMove == 1) {
                        return instance;
                    }
                    if (hasWallMove == 2) {
                        return instance;
                    }
                    if (hasWall == 0 || hasWallMove == 0) {
                        return instance;
                    }

                }

            }
        } else {
            instance = position.next(direction);
            if (isFree(instance, animals)) {
                var hasWall = hasWall(instance, direction, board);
                var hasWallMove = hasWallMove(instance, direction, board);
                if (hasWall == 1 || hasWall == 2) {
                    return position;
                }
                if (hasWallMove == 1) {
                    return instance;
                }
                if (hasWallMove == 2) {
                    return instance;
                }

            }
        }
        return null;

    }

    /**
     * Return or apply the nextPosition of each animals according to the animal
     * that call him
     *
     * @param board of the game
     * @param direction of the animal
     * @param animals arrays that contain all the animal of he game
     * @return next Position or null
     */
    protected Position animalsMove(Board board, Direction direction,
            Animal... animals) {
        var animalsNextPosition = animalsNextPosition(board, direction,
                animals);
        if (animalsNextPosition == null) {
            this.setPositionOnBoard(null);
            return null;
        }
        if (positionAreEquals(animalsNextPosition)) {
            return this.getPositionOnBoard();
        } else {
            if (!isInside(board, animalsNextPosition)) {
                this.setPositionOnBoard(null);
                return null;
            }
            if (insideAndFreeGrass(board, animalsNextPosition,
                    animals)) {
                this.setPositionOnBoard(animalsNextPosition);
                return this.getPositionOnBoard();

            }

            if (insideAndStar(board, animalsNextPosition)) {
                setAnimalState(animalsNextPosition, board);
                return this.getPositionOnBoard();
            }

            if (!insideAndFreeGrass(board, animalsNextPosition,
                    animals)) {
                return this.getPositionOnBoard();

            }

        }

        return null;
    }

}
