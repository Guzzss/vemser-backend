package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PessoaDTO extends PessoaCreateDTO{

    @Schema(description = "id da pessoa")
    private Integer idPessoa;

}
