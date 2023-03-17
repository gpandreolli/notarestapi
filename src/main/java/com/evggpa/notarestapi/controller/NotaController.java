package com.evggpa.notarestapi.controller;


import com.evggpa.notarestapi.dto.GenericDTO;
import com.evggpa.notarestapi.dto.NotaDTO;
import com.evggpa.notarestapi.dto.ProdutoDTO;
import com.evggpa.notarestapi.model.Nota;
import com.evggpa.notarestapi.model.Produto;
import com.evggpa.notarestapi.service.NotaService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/nota/")
public class NotaController {

    @Autowired
    private NotaService notaService;
    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(method = RequestMethod.POST,produces="application/json")
    private List<NotaDTO> findNotaByDataEmissao(@RequestBody String jsonData) throws ParseException, JsonProcessingException {
        List<NotaDTO> notaDTOS = new ArrayList<>();
        List<Nota> notas = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        GenericDTO atributos ;
        Map<String, String> valores = null;
        atributos = mapper.readValue(jsonData, GenericDTO.class);
        valores = atributos.getCamposGenericos();
        String dataInicial = valores.get("dataInicial");
        String dataFinal = valores.get("dataFinal");
        notas = notaService.findNotaByDataEmissao(dataInicial,dataFinal);
        notaDTOS =  notas.stream()
                .map(this::convertToDTOList)
                .collect(Collectors.toList());
        return  notaDTOS.isEmpty() ? null : notaDTOS;
    }

    @RequestMapping(path = "numero",method = RequestMethod.POST)
    private NotaDTO findNotaByNumNota(@RequestBody String jsonData) throws JsonProcessingException {
        NotaDTO notaDTO = new NotaDTO();

        ObjectMapper mapper = new ObjectMapper();
        GenericDTO atributos ;
        Map<String, String> valores = null;
        atributos = mapper.readValue(jsonData, GenericDTO.class);
        valores = atributos.getCamposGenericos();
        Long numNota = Long.valueOf(valores.get("numeroNota"));

        notaDTO = convertToDTO(notaService.findNotaByNumeNota(numNota));
        return notaDTO;
    }


    private NotaDTO convertToDTO(Optional<Nota> nota){
        NotaDTO notaDTO = modelMapper.map(nota.get(),NotaDTO.class);
        notaDTO.setEstabelecimento(nota.get().getEstabelecimento().getRazaoSocial());
        return notaDTO;
    }

    private NotaDTO convertToDTOList(Nota nota){
        NotaDTO notaDTO = modelMapper.map(nota,NotaDTO.class);
        notaDTO.setEstabelecimento(nota.getEstabelecimento().getRazaoSocial());
        return notaDTO;
    }


}
