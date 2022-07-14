package br.com.vemser.pessoaapi.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDadosPessoaisDTO{

    private Integer idPessoa;
    private String cnh;
    private String cpf;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String rg;
    private Sexo sexo;
    private String tituloEleitor;
    private String email;
    private LocalDate dataNascimento;

}
