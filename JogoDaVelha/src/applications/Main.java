package applications;

import entities.Jogador;
import entities.Jogo;
import entities.Tabuleiro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] matrix = new char[3][3];

        //Inicialização do tabuleiro e inicializando ele como empty
        Tabuleiro tabuleiro = new Tabuleiro(matrix);
        tabuleiro.construirTabuleiroEmpty();
        
        System.out.print("Player 1 (X or O): ");
        char player = sc.next().charAt(0);
        sc.nextLine();
        Jogador player1 = new Jogador(player);
        if (player == 'X'){
            player = 'O';
        }
        else player = 'X';
        Jogador player2 = new Jogador(player);

        System.out.println("Jogo da Velha: ");
        int cont = 0;
        Jogo jogo = new Jogo();
        jogo.imprimirTabuleiro(tabuleiro);
        int key = 0;
        while (cont < 9 ){
            if (cont % 2 == 0) System.out.println("Sua vez jogador " + player1.getName());
            else System.out.println("Sua vez jogador " + player2.getName());
            System.out.print("Digite a linha: ");
            int linha = sc.nextInt();
            System.out.print("Digite a coluna: ");
            int coluna = sc.nextInt();

            while (jogo.jogadaInvalida(tabuleiro, linha, coluna)){
                System.out.print("Digite a linha: ");
                linha = sc.nextInt();
                System.out.print("Digite a coluna: ");
                coluna = sc.nextInt();
            }

            if (cont % 2 == 0) {
                player1.escolha(linha, coluna);
                jogo.jogadaFeita(player1, tabuleiro);
                jogo.imprimirTabuleiro(tabuleiro);
            }

            else {
                player2.escolha(linha, coluna);
                jogo.jogadaFeita(player2, tabuleiro);
                jogo.imprimirTabuleiro(tabuleiro);
            }

            cont++;
            if (jogo.existeVencedor(tabuleiro, player1)){
                key = 1;
                break;
            }



            if (jogo.existeVencedor(tabuleiro, player2)){
                key = 1;
                break;
            }
        }
        if (key == 0){
            System.out.println("Deu velha!");
        }

    }
}