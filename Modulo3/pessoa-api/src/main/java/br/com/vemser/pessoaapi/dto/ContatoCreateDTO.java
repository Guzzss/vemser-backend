package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    @Schema(description = "id da pessoa")
    private Integer idPessoa;

    @NotNull(message = "O tipo do não pode ser nulo")
    @Schema(description = "Tipo do contato")
    private TipoContato tipoContato; //RESIDENCIAL(1)

    @NotEmpty(message = "O Número não pode ser vazio, ou nulo")
    @Size(message = "O Número não pode ter mais de 13 caracteres", max = 13)
    @Schema(description = "Número do telefone")
    private String numero;

    @NotEmpty(message = "À descrição não pode ser vazia, ou nula")
    @Schema(description = "Descrição")
    private String descricao;
}
