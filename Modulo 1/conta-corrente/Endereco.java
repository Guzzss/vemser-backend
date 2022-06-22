public class Endereco {

    int tipo; // (1- residencial / 2- comercial);
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    void imprimirEndereco() {
        System.out.println("\ntipo do endereço: " + this.tipo
                + "\nlogradouro: " + this.logradouro
                + "\nnúmero: " + this.numero
                + "\ncomplemento: " + this.complemento
                + "\ncep: " + this.cep
                + "\ncidade: " + this.cidade
                + "\nestado: " + this.estado
                + "\npais: " + this.pais);
    }

    public String toString() {
        return "tipo=" + tipo +
                "\n cep= " + cep +
                "\n pais= " + pais +
                "\n estado= " + estado +
                "\n cidade= " + cidade +
                "\n logradouro= " + logradouro +
                "\n numero= " + numero +
                "\n complemento= " + complemento;
    }
}

