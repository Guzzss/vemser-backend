package br.com.vemser.pessoaapi.entity;

import javax.validation.constraints.*;

public class Contato {

    private Integer idContato;
//    @NotNull(message = "Não existe um pessoa com este id")
    private Integer idPessoa;
    @NotNull(message = "O tipo do não pode ser nulo")
    private TipoContato tipoContato; //RESIDENCIAL(1)
    @NotEmpty(message = "O Número não pode ser vazio, ou nulo")
    @Size(message = "O Número não pode ter mais de 13 caracteres", max = 13)
    private String numero;
    @NotEmpty(message = "À descrição não pode ser vazia, ou nula")
    private String descricao;

    public Contato(Integer idContato, Integer idPessoa, TipoContato tipoContato, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.tipoContato = tipoContato;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", tipoContato=" + tipoContato +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
