package entities;

import org.w3c.dom.ranges.Range;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class HeartRates {
    String nome, sobrenome;
    LocalDate dataDeNascimento;

    public HeartRates(String nome, String sobrenome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }


    public int retornaIdade(LocalDate dataDeNascimento){
        this.dataDeNascimento = dataDeNascimento;
        final LocalDate now = LocalDate.now();
        Period idade = Period.between(getDataDeNascimento(), now);
        return idade.getYears();
    }

    public int retornaFrequenciaMaxima(){
        return 220 - retornaIdade(getDataDeNascimento());
    }

    public void retornaFrequenciaAlvo(){
        int x = retornaFrequenciaMaxima() * 50 / 100;
        int y = retornaFrequenciaMaxima() * 80 / 100;

        System.out.printf("\nFrequencia Alvo de %d a %d\n", x, y);
    }

}
