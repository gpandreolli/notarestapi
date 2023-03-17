package com.evggpa.notarestapi.dto;

import com.evggpa.notarestapi.model.Nota;
import com.evggpa.notarestapi.model.Produto;
import jakarta.persistence.*;

import java.util.Date;

public class ItemNotaDTO {


    private Long id;

    private Double qtde;

    private Double valorUn;

    private Double valorTotal;

    private Long nota;

    private Date dataEmissao;

    private String produto;

    private String estabelecimento;

    public ItemNotaDTO() {
    }

    public ItemNotaDTO(Long id, Double qtde, Double valorUn, Double valorTotal, Long nota, Date dataEmissao, String produto, String estabelecimento) {
        this.id = id;
        this.qtde = qtde;
        this.valorUn = valorUn;
        this.valorTotal = valorTotal;
        this.nota = nota;
        this.dataEmissao = dataEmissao;
        this.produto = produto;
        this.estabelecimento = estabelecimento;
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

    public Long getNota() {
        return nota;
    }

    public void setNota(Long nota) {
        this.nota = nota;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}
