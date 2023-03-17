package com.evggpa.notarestapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "item_nota")
public class ItemNota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double qtde;

    @Column
    private Double valorUn;

    @Column
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "id_nota")
    private Nota nota;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public ItemNota() {
    }

    public ItemNota(Long id, Double qtde, Double valorUn, Double valorTotal, Nota nota, Produto produto) {
        this.id = id;
        this.qtde = qtde;
        this.valorUn = valorUn;
        this.valorTotal = valorTotal;
        this.nota = nota;
        this.produto = produto;
    }

    public ItemNota(Double qtde, Double valorUn, Double valorTotal, Nota nota, Produto produto) {
        this.qtde = qtde;
        this.valorUn = valorUn;
        this.valorTotal = valorTotal;
        this.nota = nota;
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getQtde() {
        return qtde;
    }

    public void setQtde(Double qtde) {
        this.qtde = qtde;
    }

    public Double getValorUn() {
        return valorUn;
    }

    public void setValorUn(Double valorUn) {
        this.valorUn = valorUn;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
