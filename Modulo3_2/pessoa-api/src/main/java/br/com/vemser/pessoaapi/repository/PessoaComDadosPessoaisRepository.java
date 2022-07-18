package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PessoaComDadosPessoaisRepository {

    public List<PessoaDadosPessoaisDTO> listaPessoaDadosPessoais = new ArrayList<>();

    public List<PessoaDadosPessoaisDTO> list() {
        return listaPessoaDadosPessoais;
    }

    public PessoaDadosPessoaisDTO post(PessoaDadosPessoaisDTO pessoaComDadosPessoais) {
        listaPessoaDadosPessoais.add(pessoaComDadosPessoais);
        return pessoaComDadosPessoais;
    }

    public void delete(PessoaDadosPessoaisDTO pessoaComDadosPessoaisDTO) {
        listaPessoaDadosPessoais.remove(pessoaComDadosPessoaisDTO);
    }
}
