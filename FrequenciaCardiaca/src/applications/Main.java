package applications;

import entities.HeartRates;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu Nome: ");
        String name = sc.next(); sc.nextLine();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = sc.next(); sc.nextLine();
        System.out.print("Digite sua data de nascimento (yyyy-mm-dd): ");
        LocalDate dataDeNascimento = LocalDate.parse(sc.nextLine());
        System.out.println();

        HeartRates heartRates = new HeartRates(name, sobrenome, dataDeNascimento);
        System.out.println("Informações dadas:");
        //Imprimir as informações dessa forma (sem usar o toString) para dar uso aos metodos getters.
        System.out.println(heartRates.getNome() + " " + heartRates.getSobrenome() + ", " + heartRates.getDataDeNascimento());

        System.out.println("Sua idade é: " + heartRates.retornaIdade(dataDeNascimento));
        System.out.println();
        System.out.println("Sua Frequência Máxima é: " + heartRates.retornaFrequenciaMaxima());
        heartRates.retornaFrequenciaAlvo();
    }
}