package br.com.vemser.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pessoa {

    private Integer idPessoa;

    private String email;
//    @NotEmpty(message = "Nome não pode ser vazio, ou nulo")
    private String nome;
//
//    @NotNull(message = "Informe a data de nasc")
//    @Past(message = "a data deve estar no passado")
    private LocalDate dataNascimento;

//    @NotEmpty(message = "Informe o cpf")
//    @CPF(message = "Ocorreu um erro ao cadastrar cpf")
    private String cpf;

}
