package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotEmpty
    @NotBlank
    @Schema(description = "Email da pessoa")
    private String email;

    @Schema(description = "Nome da pessoa")
    @NotEmpty(message = "Nome não pode ser vazio, ou nulo")
    private String nome;

    @NotNull(message = "Informe a data de nasc")
    @Past(message = "a data deve estar no passado")
    @Schema(description = "Data de nascimento da pessoa")
    private LocalDate dataNascimento;

    @NotEmpty(message = "Informe o cpf")
    @Size(max = 11, message = "Ocorreu um erro ao cadastrar cpf")
    @Schema(description = "CPF da pessoa")
    private String cpf;

}
