package g53554.humbug.model;

/**
 *
 * @author jj
 */
public class Level {

    /**
     * Return the level of the game
     *
     * @param nMoves the number of move remaining 
     * @return new level of the game
     */
    public static Level getLevel(int nMoves) {
        Game jeu = new Game();
        return new Level(jeu.getBoard(), jeu.animals(), nMoves);
    }

    private Board board;
    private Animal[] animals;
    private int nMoves;

    /**
     *
     * @param board
     * @param animals
     * @param nMoves
     */
    public Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     *
     * @return
     */
    public Board getBoard() {
        return board;
    }

    /**
     *
     * @return
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     *
     * @return
     */
    public int getnMoves() {
        return nMoves;
    }

}
