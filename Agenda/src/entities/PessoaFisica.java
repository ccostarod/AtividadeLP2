package entities;

import java.time.LocalDate;
import java.util.Objects;

public class PessoaFisica {
    private String cpf;
    private String name;
    private String address;

    private LocalDate dataDeNascimento;

    private String email;

    private String estadoCivil;

    public PessoaFisica(String name, String cpf, String address, LocalDate dataDeNascimento, String email, String estadoCivil) {
        this.cpf = cpf;
        this.name = name;
        this.address = address;
        this.dataDeNascimento = dataDeNascimento;
        this.email = email;
        this.estadoCivil = estadoCivil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaFisica that = (PessoaFisica) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return cpf + ", " + name + ", " + email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
}
