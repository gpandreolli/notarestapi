package com.evggpa.notarestapi.controller;

import com.evggpa.notarestapi.dto.ItemNotaDTO;
import com.evggpa.notarestapi.dto.ProdutoDTO;
import com.evggpa.notarestapi.model.ItemNota;
import com.evggpa.notarestapi.model.Produto;
import com.evggpa.notarestapi.service.ItemNotaService;
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
@RequestMapping("/v1/itemnota/")
public class ItemNotaController {


    @Autowired
    ItemNotaService itemNotaService;
    @Autowired
    private ModelMapper modelMapper;

    public ItemNotaController() {
    }

    @RequestMapping(value = "produto/{name}",method = RequestMethod.GET , produces="application/json")
    public List<ItemNotaDTO> findItemNotaByProdutoName(@PathVariable("name") String name){
        List<ItemNota> itemNotas = new ArrayList<>();
        itemNotas = itemNotaService.findByNameProduto(name);
        return itemNotas.stream()
                .map(this::convertToDTOList)
                .collect(Collectors.toList());

    }

    @RequestMapping (value = "produtopreco/{name}",method = RequestMethod.GET , produces="application/json")
    public List<ItemNotaDTO> listItemNotaByProdutoName(@PathVariable("name") String name){
        List<ItemNotaDTO> itemNotaDTO = new ArrayList<>();
        itemNotaDTO = itemNotaService.findByNameProdutoGrafico(name);
        return itemNotaDTO;
    }


    private ItemNotaDTO convertToDTO(Optional<ItemNota> itemNota){
        ItemNotaDTO itemNotaDTO = modelMapper.map(itemNota.get(),ItemNotaDTO.class);
        return itemNotaDTO;
    }

    private ItemNotaDTO convertToDTOList(ItemNota itemNota){
        ItemNotaDTO itemNotaDTO = modelMapper.map(itemNota,ItemNotaDTO.class);
        itemNotaDTO.setEstabelecimento(itemNota.getNota().getEstabelecimento().getRazaoSocial());
        itemNotaDTO.setProduto(itemNota.getProduto().getNome());
        itemNotaDTO.setDataEmissao(itemNota.getNota().getDataEmissao());
        return itemNotaDTO;
    }
}
