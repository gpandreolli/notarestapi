package com.evggpa.notarestapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String nome;

    @Column
    private String razaoSocial;

    @Column
    private Long cnpj;

    @OneToMany(mappedBy = "estabelecimento")
    private List<Nota> notas;

    @OneToMany(mappedBy = "estabelecimento")
    private List<Produto> produtos;

    public Estabelecimento() {
    }

    public Estabelecimento(Long id, String nome, String razaoSocial, Long cnpj, List<Nota> notas, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.notas = notas;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
