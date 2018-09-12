package br.com.cajumobile.tictactoe;

class CommandLine {

    public void write(String text) {
        write(text, true);
    }

    private void write(String text, boolean newLine) {
        if (newLine){
            System.out.println(text);
        }else {
            System.out.print(text);
        }
    }
}
