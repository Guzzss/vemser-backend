package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoContato;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    private Integer idPessoa;

    @NotNull(message = "O tipo do não pode ser nulo")
    private TipoContato tipoContato; //RESIDENCIAL(1)

    @NotEmpty(message = "O Número não pode ser vazio, ou nulo")
    @Size(message = "O Número não pode ter mais de 13 caracteres", max = 13)
    private String numero;

    @NotEmpty(message = "À descrição não pode ser vazia, ou nula")
    private String descricao;
}
