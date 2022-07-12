package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Contato {

    private Integer idContato;

    private Integer idPessoa;

//    @NotNull(message = "O tipo do não pode ser nulo")
    private TipoContato tipoContato; //RESIDENCIAL(1)

//    @NotEmpty(message = "O Número não pode ser vazio, ou nulo")
//    @Size(message = "O Número não pode ter mais de 13 caracteres", max = 13)
    private String numero;

//    @NotEmpty(message = "À descrição não pode ser vazia, ou nula")
    private String descricao;
}
