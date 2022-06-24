package conta_corrente3.models;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();

    public Cliente () {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    void imprimirContatos() {
        if (contatos != null) {
            System.out.println("contatos de " + this.nome + ": " + (contatos));
        }
    }

    void imprimirEnderecos() {
        if (enderecos != null) {
        System.out.println("endereços de " + this.nome + ": " + (enderecos));
        }
    }

    @Override
    public String toString() {
        return this.nome + "\ncpf: " + this.cpf;
    }

    void imprimirCliente() {
        System.out.println("Cliente: " + this.nome + "\ncpf: " + this.cpf);
    }
}


