package com.example.Vaga.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="EnderecoAPI")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String logradouro;

    @Column
    private String cep;

    @Column
    private int numero;

    @Column
    private String cidade;

    @ManyToOne(fetch = FetchType.LAZY) //Cria o relacionamento da tabela Pessoa e Endereco de que o Endereco pertence a apenas uma Pessoa
    @JoinColumn(name="idP")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pessoa pessoa;

    @Column
    private boolean primaryAddress;

    public Endereco ()
    {

    }

    public int getIdEndereco() {
        return id;
    }

    public void setIdEndereco(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public boolean isPrimaryAddress() {
        return primaryAddress;
    }

    public void setPrimaryAddress(boolean primaryAddress) {
        this.primaryAddress = primaryAddress;
    }
}
