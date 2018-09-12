package br.com.cajumobile.tictactoe;

class Game {

    String[][] board = new String[3][3];

    private CommandLine commandLine;

    private String playerX;
    private String playerO;

    private Player playerTurn;

    private Player winner;

    private boolean running = true;

    Game() {
        this.commandLine = new CommandLine(this);
    }

    String[][] getBoard(){
        return board;
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
        return running;
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
        commandLine.write("It's " + playerName + " turn!");
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
        commandLine.write("\n\n");
    }

    private String getCellValue(String s) {
        if (s == null){
            return "   ";
        }else {
            return " "+s+" ";
        }
    }

    void verifyVictory() {
        switch (playerTurn){
            case O:
                verifyVictory(Player.X);
                break;
            case X:
                verifyVictory(Player.O);
                break;
        }
    }

    private void verifyVictory(Player player) {
        if (board[0][0].equals(player.toString())){
            verifyVictoryLine(0, player);
            verifyVictoryColumn(0, player);
            verifyVictoryDiagonal(0, player);
        }
        if (winner != null){
            showWinnerMessage(player);
        }
    }

    private void showWinnerMessage(Player player) {
        switch (player){
            case X:
                commandLine.write("########################################");
                commandLine.write("Congratulations");
                commandLine.write(playerX + " is the winner!");
                commandLine.write("########################################");
                break;
            case O:
                commandLine.write("########################################");
                commandLine.write("Congratulations");
                commandLine.write(playerO + " is the winner!");
                commandLine.write("########################################");
        }
    }

    private void verifyVictoryDiagonal(int i, Player player) {

        switch (i){
            case 0:
                if (board[0][0] == null || board[1][1] == null || board[2][2] == null){
                    return;
                }
                if (board[0][0].equals(player.toString()) && board[1][1].equals(player.toString()) && board[2][2].equals(player.toString())){
                    running = false;
                    winner = player;
                }
                break;
            case 2:
                if ( board[1][1] == null || board[0][2] == null || board[2][0] == null){
                    return;
                }
                if (board[0][2].equals(player.toString()) && board[1][1].equals(player.toString()) && board[2][0].equals(player.toString())){
                    running = false;
                    winner = player;
                }
                break;
        }
    }

    private void verifyVictoryColumn(int j, Player player) {
        if (board[0][j] == null || board[1][j] == null || board[2][j] == null){
            return;
        }
        if (board[0][j].equals(player.toString()) && board[1][j].equals(player.toString()) && board[2][j].equals(player.toString())){
            running = false;
            winner = player;
        }
    }

    private void verifyVictoryLine(int i, Player player) {
        if (board[i][0] == null || board[i][1] == null || board[i][2] == null){
            return;
        }

        if (board[i][0].equals(player.toString()) && board[i][1].equals(player.toString()) && board[i][2].equals(player.toString())){
            running = false;
            winner = player;
        }
    }

    public String getValueAtCoordenate(Coordenate coordenate) {
        return board[coordenate.getI()][coordenate.getJ()];
    }
}
