package br.com.cajumobile.tictactoe;

class Game {

    String[][] board = new String[3][3];

    private CommandLine commandLine;

    private String playerX;
    private String playerO;

    private Player playerTurn;

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

    public void playerMove() {

        if (playerTurn == null){
            playerTurn = Player.X;
        }

        switch (playerTurn) {
            case X:
                makeMove(playerX, playerTurn);
                playerTurn = Player.O;
                break;
            case O:
                makeMove(playerO, playerTurn);
                playerTurn = Player.X;
                break;
        }
        showBoard();
    }

    private void makeMove(String playerName, Player player) {
        commandLine.write("It's " + playerName + "time!");
        Coordenate coordenate = commandLine.getCoordenate();
        board[coordenate.getI()][coordenate.getJ()] = player.toString();
    }

    public void showBoard() {
        commandLine.clear();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                commandLine.write(getCellValue(board[i][j]), false);
                if (j == (board[i].length - 1)) {
                    commandLine.write("");
                } else {
                    commandLine.write("|", false);
                }
            }
            if (i != (board.length - 1)) {
                commandLine.write("------------");
            }
        }
    }

    private String getCellValue(String s) {
        if (s == null){
            return "   ";
        }else {
            return " "+s+" ";
        }
    }
}
