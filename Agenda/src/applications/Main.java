package applications;

import entities.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo a sua Agenda Eletronica");
        Agenda agenda = new Agenda();
        boolean x = true;
        while (x) {
            System.out.println("O que deseja fazer?\n[1] - Adicionar Contato\n[2] - Pesquisar contato\n[3] - Listar " +
                    "contatos\n[4] - Remover Contato\n[5] - Sair");
            System.out.print("Escolha: ");
            int escolha = sc.nextInt();
            agenda.testeEntrandaPrincipal(escolha);
            System.out.println();
            if (escolha == 1) { // Adicionar contato
                System.out.println("Qual o tipo desse contato?\n[1] - Pessoa Fisica\n[2] - Pessoa Juridica");
                System.out.print("Digite sua escolha: ");
                int escolhaTipo = sc.nextInt();
                agenda.testeValidez(escolhaTipo);
                if (escolhaTipo == 1) {
                    agenda.adicionarContatoPF();}
                else {
                    agenda.adicionarContatoPJ();}
            }
            else if (escolha == 2) {
                if (agenda.agendaVazia()) System.out.println("Nao ha contatos na agenda!");
                else {
                    System.out.print("Como deseja buscar?\n[1] - Nome\n[2] - CPF\nEscolha: ");
                    int escolhaPesquisa = sc.nextInt();
                    agenda.testeValidez(escolhaPesquisa);
                    if (escolhaPesquisa == 1) {
                        agenda.pesquisarPorNome();}
                    else {
                        agenda.pesquisarPorDado();}
                }
                System.out.println();
            }
            else if (escolha == 3) {
                if (agenda.agendaVazia()) System.out.println("Nao ha contatos na agenda!");
                else{
                    System.out.println("Lista de contatos: "); agenda.listarAgenda();
                    System.out.println();
                }
                System.out.println();
            }
            else if (escolha == 4) {
                if (agenda.agendaVazia()) System.out.println("Nao ha contatos na agenda!\n");
                else agenda.removerPessoa();
            }
            else{
                x = false;
            }
        }
    }
}
