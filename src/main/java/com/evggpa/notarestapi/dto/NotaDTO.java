package com.evggpa.notarestapi.dto;

import com.evggpa.notarestapi.model.Estabelecimento;
import com.evggpa.notarestapi.model.Produto;


import java.util.Date;
import java.util.List;

public class NotaDTO {

    private Long id;

    private int numNota;

    private Date dataEmissao;

    private String estabelecimento;

    private Double valorTotal;


    public NotaDTO() {
    }

    public NotaDTO(Long id, int numNota, Date dataEmissao, String estabelecimento, Double valorTotal) {
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

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
