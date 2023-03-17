package com.evggpa.notarestapi.service;

import com.evggpa.notarestapi.model.Produto;
import com.evggpa.notarestapi.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    IProdutoRepository repository;

    public Optional<Produto> findById(Long id){
        return repository.findById(id);
    }

    public List<Produto> findByName(String name){
        return repository.findByName(name);
    }
}
