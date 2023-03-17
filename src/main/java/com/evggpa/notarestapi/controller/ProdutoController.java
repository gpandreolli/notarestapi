package com.evggpa.notarestapi.controller;


import com.evggpa.notarestapi.dto.ProdutoDTO;
import com.evggpa.notarestapi.model.Produto;
import com.evggpa.notarestapi.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/produto/")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;
    @Autowired
    private ModelMapper modelMapper;

    public ProdutoController() {
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET , produces="application/json")
    public ProdutoDTO findProdutoById(@PathVariable("id") Long id){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO = convertToDTO(produtoService.findById(id));
        return produtoDTO;
    }

    @RequestMapping(value = "nome/{name}",method = RequestMethod.GET , produces="application/json")
    public List<ProdutoDTO> findProdutoByName(@PathVariable("name") String name){
        List<Produto> produtos = new ArrayList<>();
        produtos = produtoService.findByName(name);
        return produtos.stream()
                .map(this::convertToDTOList)
                .collect(Collectors.toList());

    }






    private ProdutoDTO convertToDTO(Optional<Produto> produto){
        ProdutoDTO produtoDTO = modelMapper.map(produto.get(),ProdutoDTO.class);
        produtoDTO.setId_estabelecimento(produto.get().getEstabelecimento().getId());
        produtoDTO.setNomeEstabelecimento(produto.get().getEstabelecimento().getRazaoSocial());
        return produtoDTO;
    }

    private ProdutoDTO convertToDTOList(Produto produto){
        ProdutoDTO produtoDTO = modelMapper.map(produto,ProdutoDTO.class);
        produtoDTO.setId_estabelecimento(produto.getEstabelecimento().getId());
        produtoDTO.setNomeEstabelecimento(produto.getEstabelecimento().getRazaoSocial());
        return produtoDTO;
    }

}
