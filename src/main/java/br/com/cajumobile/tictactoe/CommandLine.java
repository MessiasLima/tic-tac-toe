package br.com.cajumobile.tictactoe;

import java.io.IOException;
import java.util.Scanner;

class CommandLine {

    private final Scanner scanner;
    private OS system;

    public CommandLine() {
        system = getOS();
        scanner = new Scanner(System.in);
    }

    private OS getOS() {
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
            return OS.LINUX;
        } else if (osName.contains("win")) {
            return OS.WINDOWS;
        } else {
           return OS.UNKNOWN;
        }
    }

    public void write(String text) {
        write(text, true);
    }

    public void write(String text, boolean newLine) {
        if (newLine) {
            System.out.println(text);
        } else {
            System.out.print(text);
        }
    }

    public void clear() {
        try {
            switch (system) {
                case LINUX:
                    Runtime.getRuntime().exec("clear");
                    break;
                case WINDOWS:
                    Runtime.getRuntime().exec("cls");
                    break;
                default:
                    clearByNewLine();
            }
        } catch (IOException ioe) {
            clearByNewLine();
        }
    }

    private void clearByNewLine() {
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        write("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public String read() {
        return scanner.next();
    }
}
