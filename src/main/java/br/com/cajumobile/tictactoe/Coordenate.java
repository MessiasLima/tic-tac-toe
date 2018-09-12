package br.com.cajumobile.tictactoe;

public class Coordenate {
    private int i;
    private int j;

    public Coordenate(){}

    public Coordenate(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
