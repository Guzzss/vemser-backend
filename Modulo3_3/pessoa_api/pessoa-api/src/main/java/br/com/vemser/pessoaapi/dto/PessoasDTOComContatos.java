package br.com.vemser.pessoaapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class PessoasDTOComContatos extends PessoaDTO {
   private List<ContatoDTO> contatos;

}
