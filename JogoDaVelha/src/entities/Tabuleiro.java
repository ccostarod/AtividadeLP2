package entities;

public class Tabuleiro {

    private char[][] tabuleiro = new char[3][3];

    public Tabuleiro(char[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public char[][] getTabuleiro() {
        return tabuleiro;
    }

    public void construirTabuleiroEmpty(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                tabuleiro[i][j] = ' ';
            }
        }
    }
    public char consultarTabuleiro(int i,int j){
        return tabuleiro[i][j];
    }
}
