package com.evggpa.notarestapi.repository;

import com.evggpa.notarestapi.dto.NotaDTO;
import com.evggpa.notarestapi.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface INotaRepository extends JpaRepository<Nota,Long> {

    @Query("FROM Nota n WHERE n.dataEmissao BETWEEN :dataInicial AND :dataFinal ")
    //@Query(value = "SELECT * FROM NOTA N WHERE N.DATA_EMISSAO BETWEEN '2023-03-01' AND '2023-03-31'",nativeQuery = true)
    //@Query(value = "SELECT * FROM NOTA N ",nativeQuery = true)
    public List<Nota> encontraNotaPorPeriodo(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);

   // @Query("FROM Nota n WHERE n.numNota = :numNota ")
    public Optional<Nota> findNotaByNumNota(@Param("numNota") Long numNota);



}
