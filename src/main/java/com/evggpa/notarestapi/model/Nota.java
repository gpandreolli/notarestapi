package com.evggpa.notarestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private int numNota;

    @Column
    @Temporal( TemporalType.DATE)
    private Date dataEmissao;

    @ManyToOne
    @JoinColumn(name = "id_estabelecimento")
    private Estabelecimento estabelecimento;


    @Column
    private Double valorTotal;


    @ManyToMany
    @JoinTable(name = "item_nota",
                joinColumns = @JoinColumn(name = "id_nota"),
                inverseJoinColumns = @JoinColumn(name = "id_produto"))
    private List<Produto> produtos;

    public Nota() {
    }

    public Nota(Long id, int numNota, Date dataEmissao, Estabelecimento estabelecimento, Double valorTotal, List<Produto> produtos) {
        this.id = id;
        this.numNota = numNota;
        this.dataEmissao = dataEmissao;
        this.estabelecimento = estabelecimento;
        this.valorTotal = valorTotal;
        this.produtos = produtos;
    }

    public Nota(Long id, int numNota, Date dataEmissao, Estabelecimento estabelecimento, Double valorTotal) {
        this.id = id;
        this.numNota = numNota;
        this.dataEmissao = dataEmissao;
        this.estabelecimento = estabelecimento;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumNota() {
        return numNota;
    }

    public void setNumNota(int numNota) {
        this.numNota = numNota;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
