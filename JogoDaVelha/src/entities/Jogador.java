package entities;

public class Jogador {
    private char name;
    private int linha;
    private int coluna;

    public Jogador(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void escolha(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }
}
