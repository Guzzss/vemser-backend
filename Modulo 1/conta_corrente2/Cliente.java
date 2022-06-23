package conta_corrente2;

import java.util.Arrays;

public class Cliente {

    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf, Endereco[] enderecos, Contato[] contatos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
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

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    void imprimirContatos() {
        if (contatos != null) {
            System.out.println("contatos de " + this.nome + ": " + Arrays.toString(contatos));
        }
    }

    void imprimirEnderecos() {
        if (enderecos != null) {
        System.out.println("endereços de " + this.nome + ": " + Arrays.toString(enderecos));
        }
    }


    @Override
    public String toString() {
        return  nome + "\ncpf: " + cpf;
    }

    void imprimirCliente() {
        System.out.println("Cliente: " + this.nome + "\ncpf: " + this.cpf);
    }
}


