package com.evggpa.notarestapi.repository;

import com.evggpa.notarestapi.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IProdutoRepository extends JpaRepository<Produto,Long> {


    public Optional<Produto> findById(Long id);

    @Query(value = "from Produto p where p.nome like %:name%")
    public List<Produto> findByName(@Param("name") String name);


}
