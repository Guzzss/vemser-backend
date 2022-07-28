package br.com.vemser.pessoaapi.mapper;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    @Autowired
    private ObjectMapper objectMapper;

    public UsuarioEntity toDTO(LoginDTO loginDTO) {
        return objectMapper.convertValue(loginDTO, UsuarioEntity.class);
    }

}
