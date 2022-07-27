package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.PessoaCompostaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);

    List<PessoaEntity> findByCpf(String CPF);

    @Query(" select new br.com.vemser.pessoaapi.dto.PessoaCompostaDTO(" +
            " p.idPessoa," +
            " p.nome," +
            " p.email," +
            " c.numero," +
            " e.cep," +
            " e.cidade," +
            " e.estado," +
            " e.pais," +
            " pety.nome" +
            ")" +
            " from PESSOA p " +
            " left join p.contatos c " +
            " left join p.enderecos e " +
            " left join p.pet pety " +
            " where (:idPessoa is null OR p.idPessoa = :idPessoa )")
    List<PessoaCompostaDTO> listaCompostaDTO(@Param("idPessoa") Integer idPessoa);
}

