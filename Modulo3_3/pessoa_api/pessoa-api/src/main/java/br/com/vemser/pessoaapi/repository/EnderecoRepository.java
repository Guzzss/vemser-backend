package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import feign.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query(" select e " +
            " from ENDERECO_PESSOA e " +
            " where e.pais = :pais")
    List<EnderecoEntity> listEnderecoByPais(@Param("pais")String pais);


    @Query(" select e " +
            " from ENDERECO_PESSOA e " +
            " where e.pais = :pais")
    Page<EnderecoEntity> listEnderecoByPaisPaginacao(@Param("pais")String pais, Pageable pageable);

    @Query(" select e " +
            " from ENDERECO_PESSOA e ")
    Page<EnderecoEntity> listEnderecoPaginado(Pageable pageable);

}

