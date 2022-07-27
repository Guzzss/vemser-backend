package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.TipoContato;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query(" select c " +
            " from CONTATO c " +
            " where c.tipoContato = :tipoContato")
    List<ContatoEntity> listEnderecoByTipo(@Param("tipoContato") TipoContato tipoContato);

    @Query(" select c " +
            " from CONTATO c ")
    Page<ContatoEntity> listContatoByDescricao(Pageable pageable);
}

