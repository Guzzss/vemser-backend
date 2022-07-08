package br.com.vemser.pessoaapi.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Pessoa {


    private Integer idPessoa;
    @NotEmpty(message = "Nome não pode ser vazio, ou nulo")
    private String nome;
     @NotNull(message = "Informe a data de nasc")
     @Past(message = "a data deve estar no passado")
    private LocalDate dataNascimento;

     @NotEmpty(message = "Informe o cpf")
     @CPF(message = "Ocorreu um erro ao cadastrar cpf")
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
