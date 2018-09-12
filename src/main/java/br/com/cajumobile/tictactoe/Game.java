package br.com.cajumobile.tictactoe;

class Game {

    String[][] board = new String[3][3];

    private CommandLine commandLine;

    private String playerX;
    private String playerO;

    Game() {
        this.commandLine = new CommandLine();
    }

    void showWelcomeMessage() {
        commandLine.write("-----------------------------------");
        commandLine.write("--- Welcome to TIC TAC TOE Game ---");
        commandLine.write("-----------------------------------");
        commandLine.write("\n");
    }

    public void askForPlayersName() {
        commandLine.write("Please tell me your names");
        commandLine.write(" - Player X name: ", false);
        playerX = commandLine.read();
        commandLine.write(" - Player O name: ", false);
        playerO = commandLine.read();
    }

    public boolean getRunning() {
        return false;
    }
}
