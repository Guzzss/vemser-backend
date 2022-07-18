package br.com.vemser.pessoaapi.mapper;

import br.com.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.dto.PessoaDadosPessoaisDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaDadosPessoaisMapper {

    @Autowired
    private ObjectMapper objectMapper;

    public PessoaDadosPessoaisDTO toDTO(DadosPessoaisDTO dadosPessoaisDTO) {
        return objectMapper.convertValue(dadosPessoaisDTO, PessoaDadosPessoaisDTO.class);
    }

    public DadosPessoaisDTO fromCreateDTODados(PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) {
        return objectMapper.convertValue(pessoaDadosPessoaisDTO, DadosPessoaisDTO.class);
    }

    public PessoaDadosPessoaisDTO toDTO(PessoaDTO pessoaDTO) {
        return objectMapper.convertValue(pessoaDTO, PessoaDadosPessoaisDTO.class);
    }

    public PessoaDTO fromCreateDTOPessoa(PessoaDadosPessoaisDTO pessoaDadosPessoaisDTO) {
        return objectMapper.convertValue(pessoaDadosPessoaisDTO, PessoaDTO.class);
    }
}
