package entities;

import java.util.Objects;

public class PessoaJuridica {

    private final String name, address, cnpj, email, inscricaoEstadual, razaoSocial;

    public PessoaJuridica(String name, String address, String cnpj, String email, String inscricaoEstadual, String razaoSocial) {
        this.name = name;
        this.address = address;
        this.cnpj = cnpj;
        this.email = email;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaJuridica that = (PessoaJuridica) o;
        return Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public String toString() {
        return cnpj + ", " + razaoSocial + ", " + email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }
}


