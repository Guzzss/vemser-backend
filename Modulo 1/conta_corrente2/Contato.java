package conta_corrente2;

public class Contato {

    private String descricao;
    private String telefone;
    private int tipo; // (1- residencial / 2- comercial);

    public Contato(){

    }

    public Contato(String descricao, String telefone, int tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    void imprimirContato() {
        System.out.println("descricão: " + this.descricao + ", telefone: " + this.telefone + ", tipo de contato " + this.tipo);
    }

    public String toString() {
        return  telefone;
    }
}
