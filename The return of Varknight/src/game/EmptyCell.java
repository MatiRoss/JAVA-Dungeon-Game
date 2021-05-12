package game;

import characters.Character;

/**
 * Class representing an empty cell of the game board
 */
public class EmptyCell extends Cell {

    public EmptyCell() {
    }

    @Override
    public void interaction(Character player, Cell cell) {
    }

    @Override
    public String eventDescription() {
        return "Vous tombez sur une case vide. Un peu de répit pour vous.";
    }

    @Override
    public String toString() {
        return "Vous tombez sur une case vide. Un peu de répit pour vous.";
    }
}
