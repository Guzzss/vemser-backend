package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PessoaComTudoDTO {

    @Schema(description = "id da pessoa")
    private Integer idPessoa;

    @Schema(description = "Retorna uma lista de enderecos")
    private List<EnderecoDTO> enderecoDTOS;

    @Schema(description = "Retorna uma lista de contatos")
    private List<ContatoDTO> contatoDTOS;

    @Schema(description = "Retorna uma lista de pets")
    private PetDTO petDTO;
}
