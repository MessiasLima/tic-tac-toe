package br.com.cajumobile.tictactoe;

import java.util.Scanner;

class CommandLine {

    private final Scanner scanner;

    CommandLine() {
        scanner = new Scanner(System.in);
    }

    void write(String text) {
        write(text, true);
    }

    void write(String text, boolean newLine) {
        if (newLine) {
            System.out.println(text);
        } else {
            System.out.print(text);
        }
    }

    void clear() {
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    String read() {
        return scanner.next();
    }

    public Coordenate getCoordenate() {

        Integer entry = 0;
        do{
            write("Select a valid board position: ", false);
            entry = readInt();
        }while (!isEntryValid(entry));

        switch (entry) {
            case 1:
                return new Coordenate(0, 0);
            case 2:
                return new Coordenate(0, 1);
            case 3:
                return new Coordenate(0, 2);
            case 4:
                return new Coordenate(1, 0);
            case 5:
                return new Coordenate(1, 1);
            case 6:
                return new Coordenate(1, 2);
            case 7:
                return new Coordenate(2, 0);
            case 8:
                return new Coordenate(2, 1);
            case 9:
                return new Coordenate(2, 2);
            default:
                return null;
        }
    }

    private boolean isEntryValid(Integer entry) {
        if (entry > 0 && entry < 10){
            return true;
        }else {
            write("Invalid entry");
            return false;
        }
    }

    private Integer readInt() {
        while (true) {
            String entry = read();
            try {
                return Integer.parseInt(entry);
            } catch (Exception e) {
                write("Invalid value, please insert a integer value: ", false);
            }
        }
    }
}
