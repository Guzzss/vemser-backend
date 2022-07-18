package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {
    @Schema(description = "id do endereço")
    private Integer idEndereco;
}

