package br.com.vemser.pessoaapi.mapper;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    @Autowired
    private ObjectMapper objectMapper;

    public EnderecoDTO toDTO(EnderecoEntity enderecoEntity) {
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public EnderecoEntity fromCreateDTO(EnderecoCreateDTO enderecoCreateDTO) {
        return objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
    }
}


