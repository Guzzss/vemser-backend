public class Contato {

    String descricao;
    String telefone;
    int tipo; // (1- residencial / 2- comercial);

    void imprimirContato() {
        System.out.println("descricão: " + this.descricao + ", telefone: " + this.telefone + ", tipo de contato " + this.tipo);
    }

    public String toString() {
        return  telefone;
    }
}
