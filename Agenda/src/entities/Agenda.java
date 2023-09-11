package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Agenda {
    Scanner sc = new Scanner(System.in);
    private final List<PessoaFisica> contatosPF = new ArrayList<>();
    private final List<PessoaJuridica> contatosPJ = new ArrayList<>();

    public void adicionarContatoPF(){
        String cpf, nome, address, email, estadocivil;
        LocalDate dataDeNascimento;
        System.out.print("Nome: "); nome = sc.nextLine();
        System.out.print("CPF: "); cpf = sc.nextLine();
        System.out.print("Endereço: "); address = sc.nextLine();
        System.out.print("Data de nascimento (yyyy-mm-dd): "); dataDeNascimento = LocalDate.parse(sc.nextLine());
        System.out.print("Email: "); email = sc.nextLine();
        System.out.print("Estado Civil: "); estadocivil = sc.nextLine();

        PessoaFisica pessoaFisica = new PessoaFisica(nome, cpf, address, dataDeNascimento, email, estadocivil);
        if (contatosPF.contains(pessoaFisica)){
            System.out.println("Essa Pessoa Fisica já está na sua agenda!");
        }
        else {
            contatosPF.add(pessoaFisica);
            System.out.println("Contato adicionado com Sucesso!");
        }
    }
    public void adicionarContatoPJ(){
        String cnpj, nome, address, email, inscEstadual, razaoSocial;

        System.out.print("Nome: "); nome = sc.nextLine();
        System.out.print("CNPJ: "); cnpj = sc.nextLine();
        System.out.print("Endereço: "); address = sc.nextLine();
        System.out.print("Email: "); email = sc.nextLine();
        System.out.print("Inscrição Estadual: "); inscEstadual = sc.nextLine();
        System.out.print("Razão Social: "); razaoSocial = sc.nextLine();

        PessoaJuridica pessoaJuridica = new PessoaJuridica(nome, address , cnpj, email, inscEstadual, razaoSocial);
        if (contatosPJ.contains(pessoaJuridica)){
            System.out.println("Essa Pessoa Juridica já está na sua agenda!");
        }
        else{
            contatosPJ.add(pessoaJuridica);
            System.out.println("Contato adicionado com Sucesso!");
        }
    }

    public void pesquisarPorNome() {
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        List<PessoaFisica> resultpf = contatosPF.stream().filter(x -> Objects.equals(x.getName(), nome)).collect(Collectors.toList());
        List<PessoaJuridica> resultpj = contatosPJ.stream().filter(x -> Objects.equals(x.getName(), nome)).collect(Collectors.toList());
        if (resultpf.isEmpty() && resultpj.isEmpty()){
            System.out.println("Esse nome nao foi encontrado na agenda! ");
        }
        else if (!resultpf.isEmpty() && resultpj.isEmpty()){
            for (PessoaFisica x : resultpf){
                System.out.println(x);
                return;
            }
        }
        else{
            for (PessoaJuridica x : resultpj){
                System.out.println(x);
                return;
            }
        }
    }



    public void pesquisarPorDado(){
        System.out.print("Digite o CPF ou CNPJ: ");
        String dado = sc.nextLine();
        List<PessoaFisica> resultpf = contatosPF.stream().filter(x -> Objects.equals(x.getCpf(), dado)).collect(Collectors.toList());
        List<PessoaJuridica> resultpj = contatosPJ.stream().filter(x-> Objects.equals(x.getCnpj(), dado)).collect(Collectors.toList());
        if (resultpf.isEmpty() && resultpj.isEmpty()){
            System.out.println("Esse CPF ou CNPJ nao foi encontrado na agenda! ");
        }
        else if (!resultpf.isEmpty() && resultpj.isEmpty()) {
            for (PessoaFisica x : resultpf) {
                System.out.println(x);
                return;
            }
        }
        else if (resultpf.isEmpty())   {
            for (PessoaJuridica x : resultpj){
                System.out.println(x);
                return;
            }
        }

    }


    public void listarAgenda(){
        if (!contatosPF.isEmpty()) for (PessoaFisica x : contatosPF) System.out.println(x);

        if (!contatosPJ.isEmpty()) for (PessoaJuridica x : contatosPJ) System.out.println(x);
    }

    public void removerPessoa() {
        String name, dado;
        System.out.println("Deseja remover uma pessoa\n[1] - Fisica\n[2] - Juridica");
        System.out.print("Digite sua escolha: ");
        int escolhaRemover = sc.nextInt();
        testeValidez(escolhaRemover);
        System.out.print("Digite o nome: ");
        name = sc.next();
        sc.nextLine();
        if (escolhaRemover == 1){
            System.out.print("Digite o CPF: ");
            dado = sc.next();
            sc.nextLine();
            for (PessoaFisica pessoaFisica : contatosPF) {
                if (pessoaFisica.getName().equals(name) && pessoaFisica.getCpf().equals(dado)) {
                    contatosPF.remove(pessoaFisica);
                    System.out.println(name + " com CPF: " + dado + ", foi removido da agenda.");
                    System.out.println();
                    return;
                }
            }
        }
        else {
            System.out.print("Digite o CNPJ: ");
            dado = sc.next();
            for (PessoaJuridica pessoaJuridica : contatosPJ) {
                if (pessoaJuridica.getName().equals(name) && pessoaJuridica.getCnpj().equals(dado)) {
                    contatosPJ.remove(pessoaJuridica);
                    System.out.println(name + " com CNPJ " + dado + " foi removido da agenda.\n");
                    System.out.println();
                    return;
                }
            }
        }

        System.out.println("Pessoa com nome: " + name + ", e CPF/CNPJ: " + dado + ", não encontrada na agenda.");
        System.out.println();
    }



    public boolean agendaVazia(){
        return contatosPF.isEmpty() && contatosPJ.isEmpty();
    }

    public void testeValidez(int escolha){
        Scanner sc = new Scanner(System.in);
        while (escolha != 1 && escolha != 2){
            System.out.print("Digite uma escolha valida: "); escolha = sc.nextInt();
        }
    }

    public void testeEntrandaPrincipal(int escolha){
        Scanner sc = new Scanner(System.in);
        while (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 4 && escolha != 5){
            System.out.print("Digite uma escolha valida: "); escolha = sc.nextInt();
        }
    }
}


