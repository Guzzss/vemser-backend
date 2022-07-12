package br.com.vemser.pessoaapi.mapper;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContatoMapper {

    @Autowired
    private ObjectMapper objectMapper;

    public ContatoDTO toDTO(Contato contato) {
        return objectMapper.convertValue(contato, ContatoDTO.class);
    }

    public Contato fromCreateDTO(ContatoCreateDTO contatoCreateDTO) {
        return objectMapper.convertValue(contatoCreateDTO, Contato.class);
    }
}
