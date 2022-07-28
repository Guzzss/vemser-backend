package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.mapper.UsuarioMapper;
import br.com.vemser.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioMapper usuarioMapper;

    private final UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha){
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login){
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO create(LoginDTO loginDTO){
        UsuarioEntity usuarioEntity = usuarioMapper.toDTO(loginDTO);
        usuarioEntity.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));
        usuarioRepository.save(usuarioEntity);
        return loginDTO;
    }

    
}
