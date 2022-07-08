package br.com.vemser.pessoaapi.entity;

import javax.validation.constraints.*;

public class Endereco {

    private Integer idEndereco;
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

    public Endereco(Integer idEndereco, Integer idPessoa, TipoEndereco tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public TipoEndereco getTipo() {
        return tipo;
    }

    public void setTipo(TipoEndereco tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
