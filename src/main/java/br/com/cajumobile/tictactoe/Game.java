package br.com.cajumobile.tictactoe;

class Game {

    private CommandLine commandLine;

    Game() {
        this.commandLine = new CommandLine();
    }

    void showWelcomeMessage() {
        commandLine.write("-----------------------------------");
        commandLine.write("--- Welcome to TIC TAC TOE Game ---");
        commandLine.write("-----------------------------------");
    }
}
