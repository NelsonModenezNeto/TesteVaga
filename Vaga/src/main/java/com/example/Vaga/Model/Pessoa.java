package com.example.Vaga.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PessoaAPI")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //Resolve o problema de serialização
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idP;

    @Column
    private String nome;

    @Column
    private String dataNac;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true) //Cria o relacionamento da tabela Pessoa e Endereco de muitos enderecos para uma pessoa
    @JsonIgnore //Não é necessário declarar um endereco no Json de /Cadastro de Pessoa
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa(String nome, String dataNac, List<Endereco> enderecos) {
        this.nome = nome;
        this.dataNac = dataNac;
        this.enderecos = enderecos;
    }

    public Pessoa(int idP, String nome, String dataNac) {
        this.idP = idP;
        this.nome = nome;
        this.dataNac = dataNac;
    }

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNac() {
        return dataNac;
    }

    public void setDataNac(String dataNac) {
        this.dataNac = dataNac;
    }

    public int getId() {
        return idP;
    }

    public void setId(int idP) {
        this.idP = idP;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
