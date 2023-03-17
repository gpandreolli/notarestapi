package com.evggpa.notarestapi.service;

import com.evggpa.notarestapi.dto.ItemNotaDTO;
import com.evggpa.notarestapi.model.ItemNota;
import com.evggpa.notarestapi.model.Produto;
import com.evggpa.notarestapi.repository.IItemNotaRepository;
import com.evggpa.notarestapi.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemNotaService {

    @Autowired
    IItemNotaRepository repository;


    public List<ItemNota> findByNameProduto(String name) {
        List<ItemNota> itemNotas = new ArrayList<>();
        itemNotas = repository.findItemNotaByProdutobyName(name);
        return itemNotas;
    }

    public List<ItemNotaDTO> findByNameProdutoGrafico(String name) {
        List<ItemNotaDTO> itemNotaDTOS = new ArrayList<>();
        itemNotaDTOS = repository.findItemNotaDTOByProdutoName(name);
        return itemNotaDTOS;
    }

}
