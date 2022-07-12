package br.com.vemser.pessoaapi.dto;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotEmpty
    @NotBlank
    private String email;

    @NotEmpty(message = "Nome não pode ser vazio, ou nulo")
    private String nome;

    @NotNull(message = "Informe a data de nasc")
    @Past(message = "a data deve estar no passado")
    private LocalDate dataNascimento;

    @NotEmpty(message = "Informe o cpf")
    @CPF(message = "Ocorreu um erro ao cadastrar cpf")
    private String cpf;

}
