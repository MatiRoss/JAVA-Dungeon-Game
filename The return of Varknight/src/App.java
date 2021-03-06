import menu.Menu;
import game.Game;

import database.*;

import java.sql.SQLException;

/**
 * Main class with entry point of the program.
 */
public class App {

    public App() {
    }

    /**
     * Entry point of the program.
     * The method instantiate a new Menu, then call the method to create a character.
     * It then instantiate a new Game taking the player as a parameter
     * Finally it launches the game by calling the playGame method
     *
     * @throws Exception
     * @see Menu
     * @see Game
     * @see Menu#characterSelection()
     * @see Game#playGame()
     */
    public static void main(String[] args) throws Exception {
        Menu menu = new Menu();
        menu.characterSelection();

        Game game = new Game(menu.getPlayer());
        game.playGame();

    }
}
