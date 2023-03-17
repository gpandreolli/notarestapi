package com.evggpa.notarestapi.dto;

import com.evggpa.notarestapi.model.Estabelecimento;
import com.evggpa.notarestapi.model.Nota;
import jakarta.persistence.*;

import java.util.List;

public class ProdutoDTO {


    private Long id;
    private String nome;
    private Long ncm;
    private String codProdEst;
    private String unidComercial;
    private Long id_estabelecimento;
    private String nomeEstabelecimento;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String nome, Long ncm, String codProdEst, String unidComercial, Long id_estabelecimento, String nomeEstabelecimento) {
        this.id = id;
        this.nome = nome;
        this.ncm = ncm;
        this.codProdEst = codProdEst;
        this.unidComercial = unidComercial;
        this.id_estabelecimento = id_estabelecimento;
        this.nomeEstabelecimento = nomeEstabelecimento;
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

    public Long getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(Long id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }
}
