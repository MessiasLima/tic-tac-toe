package br.com.cajumobile.tictactoe;

public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        game.showWelcomeMessage();
        game.askForPlayersName();
        do{
            game.showBoard();
            game.playerMove();
        }while(game.getRunning());

    }
}
