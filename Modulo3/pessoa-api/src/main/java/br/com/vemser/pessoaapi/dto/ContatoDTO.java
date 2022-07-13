package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

@Data
public class ContatoDTO extends ContatoCreateDTO {
   @Schema(description = "id do contato")
   private Integer idContato;
}
