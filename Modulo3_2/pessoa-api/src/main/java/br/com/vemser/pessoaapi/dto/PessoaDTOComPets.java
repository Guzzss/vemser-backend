package br.com.vemser.pessoaapi.dto;

import lombok.Data;

import java.util.List;
@Data
public class PessoaDTOComPets extends PessoaDTO{
    private PetDTO pet;
}
