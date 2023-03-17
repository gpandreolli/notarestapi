package com.evggpa.notarestapi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String nome;

    @Column
    private Long ncm;

    @Column
    private String codProdEst;

    @Column
    private String unidComercial;

    @ManyToMany(mappedBy = "produtos")
    private List<Nota> notas;

    @ManyToOne
    @JoinColumn(name = "id_estabelecimento")
    private Estabelecimento estabelecimento;

    public Produto() {
    }

    public Produto(Long id, String nome, Long ncm, String codProdEst, String unidComercial, List<Nota> notas) {
        this.id = id;
        this.nome = nome;
        this.ncm = ncm;
        this.codProdEst = codProdEst;
        this.unidComercial = unidComercial;
        this.notas = notas;
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

    public Long getNcm() {
        return ncm;
    }

    public void setNcm(Long ncm) {
        this.ncm = ncm;
    }

    public String getCodProdEst() {
        return codProdEst;
    }

    public void setCodProdEst(String codProdEst) {
        this.codProdEst = codProdEst;
    }

    public String getUnidComercial() {
        return unidComercial;
    }

    public void setUnidComercial(String unidComercial) {
        this.unidComercial = unidComercial;
    }

    @ElementCollection
    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }
}
