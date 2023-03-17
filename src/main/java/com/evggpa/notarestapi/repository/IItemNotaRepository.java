package com.evggpa.notarestapi.repository;

import com.evggpa.notarestapi.dto.ItemNotaDTO;
import com.evggpa.notarestapi.model.ItemNota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IItemNotaRepository extends JpaRepository<ItemNota,Long> {


    @Query(value = "from ItemNota i join i.nota n join i.produto p where p.nome like :name% group by i, n.dataEmissao order by n.dataEmissao desc")
    public List<ItemNota> findItemNotaByProdutobyName(@Param("name") String name);


    @Query(value = "select p.nome, n.data_emissao, i.valor_un from nota n " +
            "inner join item_nota i on i.id_nota = n.id " +
            "inner join produto p on p.id = i.id_produto " +
            "where p.nome like '%:name%' "+
            "Group by p.nome, n.data_emissao, i.valor_un " +
            "order by n.data_emissao  desc ", nativeQuery = true)
    public List<ItemNotaDTO> findItemNotaDTOByProdutoName(@Param("name") String name);

}
