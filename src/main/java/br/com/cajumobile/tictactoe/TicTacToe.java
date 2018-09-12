package br.com.cajumobile.tictactoe;

public class TicTacToe {
    public static void main(String[] args) {
        String[][] board = new String[3][3];
        Game game = new Game();
        game.showWelcomeMessage();
    }
}
