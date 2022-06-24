package conta_corrente2.models;

public class Endereco {

    private int tipo; // (1- residencial / 2- comercial);
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco() {

    }

    public Endereco(int tipo, String cep,  String pais, String estado, String cidade,String logradouro , int numero, String complemento) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
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

    public void imprimirEndereco() {
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
        return "\ntipo=" + tipo +
                "\n cep= " + cep +
                "\n pais= " + pais +
                "\n estado= " + estado +
                "\n cidade= " + cidade +
                "\n logradouro= " + logradouro +
                "\n numero= " + numero +
                "\n complemento= " + complemento;
    }
}

