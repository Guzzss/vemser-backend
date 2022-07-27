package br.com.vemser.pessoaapi.security;

import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UsuarioService usuarioService;

    public String getToken(UsuarioEntity usuarioEntity) {
        String token = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha();
        String tokenFormatado = Base64.getEncoder().encodeToString(token.getBytes());
        return tokenFormatado;
    }

    public Optional<UsuarioEntity> isValid(String token) {
        if(token == null){
            return Optional.empty();
        }

        byte[] decodedBytes = Base64.getUrlDecoder().decode(token);
        String decoded = new String(decodedBytes);
        String[] split = decoded.split(";");
        Optional<UsuarioEntity> usuarioExistente = usuarioService.findByLoginAndSenha(split[0], split[1]);
        return usuarioExistente;
    }
}