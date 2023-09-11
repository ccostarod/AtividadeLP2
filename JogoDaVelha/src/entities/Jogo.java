package entities;

public class Jogo {


    public void jogadaFeita(Jogador jogador,Tabuleiro tabuleiro){
        tabuleiro.getTabuleiro()[jogador.getLinha()][jogador.getColuna()] = jogador.getName();
    }

    public void imprimirTabuleiro(Tabuleiro tabuleiro) {
        System.out.println("   0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro.getTabuleiro()[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  ---+---+---");
            }
        }
    }

    public boolean jogadaInvalida(Tabuleiro tabuleiro, int i, int j){
        if ((i < 0 || i > 2) || (j < 0 || j > 2)){
            System.out.println("Entrada invalidas, coloque entradas entre 0 e 2!");
            return true;
        }
        else {
            if (tabuleiro.consultarTabuleiro(i, j) != ' '){
                System.out.println("Essa LINHA x COLUNA já foi jogada! Jogue novamente!");
                return true;
            }
            return false;
        }
    }


    public boolean existeVencedor(Tabuleiro tabuleiro, Jogador jogador){
        //Verticalmente:
        if (tabuleiro.getTabuleiro()[0][0] == jogador.getName() && tabuleiro.getTabuleiro()[1][0] == jogador.getName()
        && tabuleiro.getTabuleiro()[2][0] == jogador.getName()){
            System.out.println(jogador.getName() + " VENCEU!");
            return true;
        }
        else if(tabuleiro.getTabuleiro()[0][1] == jogador.getName() && tabuleiro.getTabuleiro()[1][1] == jogador.getName() &&
                tabuleiro.getTabuleiro()[2][1] == jogador.getName()){
            System.out.println(jogador.getName() + " VENCEU!");
            return true;
        }
        else if(tabuleiro.getTabuleiro()[0][2] == jogador.getName() && tabuleiro.getTabuleiro()[1][2] == jogador.getName() &&
                tabuleiro.getTabuleiro()[2][2] == jogador.getName()){
            System.out.println(jogador.getName() + " VENCEU!");
            return true;
        }

        //Horizontalmente
        else if(tabuleiro.getTabuleiro()[0][0] == jogador.getName() && tabuleiro.getTabuleiro()[0][1] == jogador.getName() &&
                tabuleiro.getTabuleiro()[0][2] == jogador.getName()){
            System.out.println(jogador.getName() + " VENCEU!");
            return true;
        }

        else if(tabuleiro.getTabuleiro()[1][0] == jogador.getName() && tabuleiro.getTabuleiro()[1][1] == jogador.getName() &&
                tabuleiro.getTabuleiro()[1][2] == jogador.getName()){
            System.out.println(jogador.getName() + " VENCEU!");
            return true;
        }
        else if(tabuleiro.getTabuleiro()[2][0] == jogador.getName() && tabuleiro.getTabuleiro()[2][1] == jogador.getName() &&
                tabuleiro.getTabuleiro()[2][2] == jogador.getName()){
            System.out.println(jogador.getName() + " VENCEU!");
            return true;
        }

        //Diagonal:
        else if(tabuleiro.getTabuleiro()[0][0] == jogador.getName() && tabuleiro.getTabuleiro()[1][1] == jogador.getName() &&
                tabuleiro.getTabuleiro()[2][2] == jogador.getName()){
            System.out.println(jogador.getName() + " VENCEU!");
            return true;
        }
        else if(tabuleiro.getTabuleiro()[0][2] == jogador.getName() && tabuleiro.getTabuleiro()[1][1] == jogador.getName() &&
                tabuleiro.getTabuleiro()[2][0] == jogador.getName()){
            System.out.println(jogador.getName() + "VENCEU!");
            return true;
        }
        return false;
    }
}
