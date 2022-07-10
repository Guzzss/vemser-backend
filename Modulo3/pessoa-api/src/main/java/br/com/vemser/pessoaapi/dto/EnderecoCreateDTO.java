package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoEndereco;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    private Integer idPessoa;

    @NotNull(message = "O tipo do endereço não pode ser nulo")
    private TipoEndereco tipo;

    @NotBlank(message = "O logradouro não pode ser vazio")
    @Size(message = "O logradouro não pode ter mais de 250 caracteres", max = 250)
    private String logradouro;

    @NotNull(message = "O número não pode ser nulo")
    private Integer numero;

    private String complemento;

    @NotEmpty(message = "O CEP não pode ser vazio, ou nulo")
    private String cep;

    @NotEmpty(message = "A cidade não pode ser vazia, ou nula")
    @Size(message = "A cidade não pode ter mais de 250 caracteres", max = 250)

    private String cidade;

    @NotNull(message = "O estado não pode ser nulo")
    private String estado;

    @NotNull(message = "O país não pode ser nulo")
    private String pais;

}
