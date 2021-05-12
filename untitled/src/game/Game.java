package game;

import characters.Character;
import enemies.Enemy;
import enemies.Rat;
import menu.*;
import gameBoard.Board;
import tools.Timer;
import java.util.Collections;
import java.util.Scanner;

/**
 * <b>Game is the class that represents the ongoing game.</b>
 * <p>
 * It takes 3 main attributes :
 * - player (of type Character) that represents the current player.
 *
 * @see Character
 * - board (of type Board) that represents the generated game board.
 * @see Board
 * - keyboard (of type Scanner) that allows the player to type throughout the ongoing game.
 * @see Scanner
 * 2 optional attributes :
 * - text (of type MenuText) that regroups all methods returning text.
 * @see MenuText
 * - timer (of type Timer) that has a method with a wait timer.
 * @see tools.Timer#waitSec(int, boolean, boolean)
 * @see Timer
 */

public class Game {

    private Character player;
    private Scanner keyboard;
    private Board board;

    private MenuText text;
    private Timer timer;

    /**
     * Game Constructor instanciating the attributes
     * Collections.shuffle allow for a random generated game board
     *
     * @param player : required parameter that refers to the current player
     */
    public Game(Character player) {
        timer = new Timer();
        this.player = player;
        keyboard = new Scanner(System.in);
        text = new MenuText();
        board = new Board();
        Collections.shuffle(board.getBoard());
    }

    /**
     * playGame method takes no parameters.
     * It makes the player move on the game board whith a random generated number
     *
     * @throws Exception if the player gets out of the board by rolling dice
     * @see CharacterOutOfBoard
     * @see Character#throwDice()
     */
    public void playGame() throws Exception {

        while (board.getPlayerPosition() < board.getBoard().size() && player.getHp() > 0) {
            try {
                timer.waitSec(1, true, true);
                text.rollDice();
                int diceValue = player.throwDice();
                String lanceDe = keyboard.next();
                if (lanceDe.equals("o")) {
                    Cell cell = board.getBoard().get(board.getPlayerPosition());
                    System.out.println(" ---------------------------------------------------");
                    System.out.println("        Vous lancez le dé et faites un... " + diceValue + " !");
                    board.setPlayerPosition(board.getPlayerPosition() + diceValue);
                    if (board.getPlayerPosition() < board.getBoard().size()) {
                        System.out.println("        Vous avancez jusqu'à la case " + board.getPlayerPosition() + ".");
                        System.out.println(" ---------------------------------------------------");
                        System.out.println(cell.eventDescription());
                        System.out.println(" ---------------------------------------------------");
                        if (cell instanceof Enemy) {
                            System.out.println(player.showStats(player));
                            System.out.println(((Enemy) cell).showStats());
                            text.FightOrFlee();
                            boolean ennemyChoice = true;
                            while (ennemyChoice) {
                                int fightChoice = keyboard.nextInt();
                                switch (fightChoice) {
                                    case 1:
                                        System.out.println(player.showStats(player));
                                        ennemyChoice = false;
                                        fight(cell, diceValue);
                                        break;
                                    case 2:
                                        System.out.println(player.showStats(player));
                                        ennemyChoice = false;
                                        flee();
                                        break;
                                    case 3:
                                        player.displayInventory(player);
                                        player.useItem(player);
                                }
                            }
                        } else {
                      /*     text.displayInventory();
                            String displayIventory = keyboard.next();
                           if (displayIventory.equals("i")) {
                                player.displayInventory(player);
                                player.useItem(player);
                            }else {

                            }
                           */
                            cell.interaction(player, cell);
                        }
                    } else if (board.getPlayerPosition() > board.getBoard().size()) {
                        throw new CharacterOutOfBoard();
                    }
                } else if (lanceDe.equals("r")) {
                    startNewGame();
                } else {
                    exitGame();
                }
            } catch (CharacterOutOfBoard e) {
                board.setPlayerPosition(board.getBoard().size());
                System.out.println("        Vous avancez jusqu'à la case " + board.getPlayerPosition() + ".");
                System.out.println(" ---------------------------------------------------");
            }
        }
        if (player.getHp() <= 0) {
            restartChoice();
        }
        text.youWin();
        restartChoice();
    }

    /**
     * Method that starts a new game by generating a new game board,
     * resets player's attributes and position on the board, then call method playGame
     *
     * @throws Exception of type CharacterOutOfBoard
     * @see CharacterOutOfBoard
     */
    public void startNewGame() throws Exception {
        text.launchGame();
        board.setPlayerPosition(0);
        player.setHp(player.getHpMin());
        player.setAttack(player.getAttackMin());
        this.board = new Board();
        playGame();
    }

    /**
     * Method that restart the game, generating a new game board.
     * It resets player's position but KEEPS current attributes and inventory
     *
     * @throws Exception of type CharacterOutOfBoard
     */
    public void restartGame() throws Exception {
        text.launchGame();
        board.setPlayerPosition(0);
        this.board = new Board();
        playGame();
    }

    /**
     * Method that uses the class Scanner to read text and let you choose between starting a new game or exiting
     *
     * @throws Exception of type CharacterOutOfBoard
     */
    public void restartChoice() throws Exception {
        System.out.println("Voulez-vous réessayer?          OUI ('o')      NON ('n')");
        String restartChoice = keyboard.next();
        if (restartChoice.equals("o")) {
            startNewGame();
        } else {
            exitGame();
        }
    }

    /**
     * Method that takes 2 paramers.
     * setDead is a boolean from Ennemy class that is set to false by default.
     * If true, it means the ennemy on the corresponding cell is dead.
     * It then adds a new object Rat to the same cell where the previous enemy died.
     *
     * @param cell      refers to the cell the player is on (of class Cell)
     * @param diceValue refers to the int (between 1 and 6) that the throwDice() method returns
     * @see Enemy
     * @see Cell
     */
    public void fight(Cell cell, int diceValue) {
        ((Enemy) cell).setDead(false);
        cell.interaction(player, cell);
        if (((Enemy) cell).isDead()) {
            board.getBoard().set((board.getPlayerPosition() - diceValue), new Rat());
        }
    }

    /**
     * Method that lets you flee combat.
     * It sends you few cells backwards on the game board (determined by the throwingDice method)
     * It also manages the interaction with the new cell the player is on after fleeing.
     */
    public void flee() {
        int diceValue2 = player.throwDice();
        int newPosition = board.getPlayerPosition() - diceValue2;
        board.setPlayerPosition(newPosition);
        Cell newCell = board.getBoard().get(newPosition);
        System.out.println("Vous fuyez lâchement... Votre couardise vous ramène à la case " + newPosition + ".");
        System.out.println(" ---------------------------------------------------");
        System.out.println(newCell.eventDescription());
        System.out.println(" ---------------------------------------------------");

        if (newCell instanceof Enemy) {
            ((Enemy) newCell).setDead(false);
            System.out.println(player.showStats(player));
            System.out.println(((Enemy) newCell).showStats());
            newCell.interaction(player, newCell);
            if (((Enemy) newCell).isDead()) {
                board.getBoard().set((newPosition), new Rat());
            }
        } else {
            newCell.interaction(player, newCell);
        }
    }

    /**
     * Method that displays texts and terminates the programm.
     */
    public void exitGame() {
        System.out.println("Navré de vous voir déjà partir, peut être n'étiez-vous pas de taille...");
        System.exit(0);
    }
}
