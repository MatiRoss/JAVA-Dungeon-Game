package gameBoard;

import enemies.*;
import equipments.*;
import game.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class that represents the game board.
 * The board is an ArrayList of objects of type Cell.
 * It has an integer attribute playerPosition representing the position of the player on the current board.
 * It has different integer attributes that lets you handle the numbers of objects on the board when generating a new game board.
 *
 * @see Cell
 */
public class Board {
    private int playerPosition;
    private ArrayList<Cell> board;

    private int nbGobelins;
    private int nbSorcerers;
    private int nbDragons;
    private int nbClubs;
    private int nbSwords;
    private int nbThunderstrike;
    private int nbFireBalls;
    private int nbHealthPotions;
    private int nbBigHealthPotions;
    private int nbEmptyCells;
    private int nbGobelinKings;
    private int nbShields;
    private int nbPhilters;


    /**
     * Board constructor.
     * It uses the integer attributes of the class to determine how many objects will be on the board when generated.
     *
     * @see Board#generateBoard()
     */

    /**
     * Board constructor with higher difficulty.
     * It uses the integer attributes of the class to determine how many objects will be on the board when generated.
     *
     * @see Board#generateBoard()
     */

    public Board(int level) {
        if (level == 1) {
            board = new ArrayList<Cell>();
            this.playerPosition = 0;

            this.nbGobelins = 9;
            this.nbSorcerers = 9;
            this.nbDragons = 4;
            this.nbClubs = 5;
            this.nbSwords = 4;
            this.nbThunderstrike = 5;
            this.nbFireBalls = 4;
            this.nbHealthPotions = 6;
            this.nbBigHealthPotions = 2;
            this.nbEmptyCells = 4;
            this.nbGobelinKings = 2;
            this.nbShields = 5;
            this.nbPhilters = 5;

            generateBoard();
            Collections.shuffle(this.board);

        } else if (level == 2) {
            board = new ArrayList<Cell>();
            this.playerPosition = 0;

            this.nbGobelins = 11;
            this.nbSorcerers = 12;
            this.nbDragons = 9;
            this.nbClubs = 3;
            this.nbSwords = 2;
            this.nbThunderstrike = 3;
            this.nbFireBalls = 1;
            this.nbHealthPotions = 3;
            this.nbBigHealthPotions = 2;
            this.nbEmptyCells = 2;
            this.nbGobelinKings = 8;
            this.nbShields = 4;
            this.nbPhilters = 4;

            generateBoard();
            Collections.shuffle(this.board);

        } else if (level == 3) {
            board = new ArrayList<Cell>();
            this.playerPosition = 0;

            this.nbGobelins = 10;
            this.nbSorcerers = 10;
            this.nbDragons = 15;
            this.nbClubs = 4;
            this.nbSwords = 3;
            this.nbThunderstrike = 4;
            this.nbFireBalls = 2;
            this.nbHealthPotions = 3;
            this.nbBigHealthPotions = 2;
            this.nbEmptyCells = 4;
            this.nbGobelinKings = 15;
            this.nbShields = 3;
            this.nbPhilters = 3;

            generateBoard();
            Collections.shuffle(this.board);
        }
    }

    /**
     * Method that fills up the board with the different objects (ennemies, equipments, potions...).
     * Their numbers is based on the 'nbName' attribute defined in the constructor.
     */
    public void generateBoard() {
        for (int i = 0; i < nbGobelins; i++) {
            board.add(new Goblin());
        }
        for (int i = 0; i < nbSorcerers; i++) {
            board.add(new Sorcerer());
        }
        for (int i = 0; i < nbDragons; i++) {
            board.add(new Dragon());
        }
        for (int i = 0; i < nbClubs; i++) {
            board.add(new Club());
        }
        for (int i = 0; i < nbSwords; i++) {
            board.add(new Sword());
        }
        for (int i = 0; i < nbThunderstrike; i++) {
            board.add(new Thunderstrike());
        }
        for (int i = 0; i < nbFireBalls; i++) {
            board.add(new Fireball());
        }
        for (int i = 0; i < nbHealthPotions; i++) {
            board.add(new HealthPotion());
        }
        for (int i = 0; i < nbBigHealthPotions; i++) {
            board.add(new BigHealthPotion());
        }
        for (int i = 0; i < nbEmptyCells; i++) {
            board.add(new EmptyCell());
        }
        for (int i = 0; i < nbGobelinKings; i++) {
            board.add(new GoblinKing());
        }
        for (int i = 0; i < nbShields; i++) {
            board.add(new Shield());
        }
        for (int i = 0; i < nbPhilters; i++) {
            board.add(new Philter());
        }
        Collections.shuffle(this.board);
    }

    public ArrayList<Cell> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<Cell> board) {
        this.board = board;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(int playerPosition) {
        this.playerPosition = playerPosition;
    }
}