import java.util.Arrays;

public class Cliente {

    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

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

    void imprimirCliente() {
        System.out.println("Cliente: " + this.nome + "\ncpf: " + this.cpf);
    }
}
