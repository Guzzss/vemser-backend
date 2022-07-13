package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {

    @Schema(description = "id da pessoa")
    private Integer idPessoa;

    @NotNull(message = "O tipo do endereço não pode ser nulo")
    @Schema(description = "Tipo do endereço")
    private TipoEndereco tipo;

    @NotBlank(message = "O logradouro não pode ser vazio")
    @Size(message = "O logradouro não pode ter mais de 250 caracteres", max = 250)
    @Schema(description = "Logradouro")
    private String logradouro;

    @NotNull(message = "O número não pode ser nulo")
    @Schema(description = "Número do endereço")
    private Integer numero;

    @Schema(description = "Complemento")
    private String complemento;

    @NotEmpty(message = "O CEP não pode ser vazio, ou nulo")
    @Schema(description = "CEP")
    private String cep;

    @NotEmpty(message = "A cidade não pode ser vazia, ou nula")
    @Size(message = "A cidade não pode ter mais de 250 caracteres", max = 250)
    @Schema(description = "Cidade")
    private String cidade;

    @NotNull(message = "O estado não pode ser nulo")
    @Schema(description = "Estado")
    private String estado;

    @NotNull(message = "O país não pode ser nulo")
    @Schema(description = "Pais")
    private String pais;

}
