package com.evggpa.notarestapi.service;

import com.evggpa.notarestapi.dto.NotaDTO;
import com.evggpa.notarestapi.model.Nota;
import com.evggpa.notarestapi.repository.INotaRepository;
import com.evggpa.notarestapi.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private INotaRepository notaRepository;


    public List<Nota> findNotaByDataEmissao(String dataInicial, String dataFinal) throws ParseException {
        List<Nota> notas = new ArrayList<>();
        Date initialDate = new Date();
        Date finalDate = new Date();
        initialDate = Util.formataData(dataInicial);
        finalDate = Util.formataData(dataFinal);
        notaRepository.encontraNotaPorPeriodo(initialDate, finalDate);
        return notas;
    }

    public Optional<Nota> findNotaByNumeNota(Long numNota){
        return notaRepository.findNotaByNumNota(numNota);

    }

}
