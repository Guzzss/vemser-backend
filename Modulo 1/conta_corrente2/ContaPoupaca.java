package conta_corrente2;

public class ContaPoupaca extends Conta implements Impressoes {

    static final double JUROS_MENSAL = 1.01;

    public ContaPoupaca() {
        super();
    }

    public ContaPoupaca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        if (getCliente() != null) {
            setSaldo(getSaldo() * JUROS_MENSAL);
        }
    }

    @Override
    public void imprimir() {
        if (getCliente() != null) {
            System.out.println("\nCliente: " + this.getCliente()
                    + "\nnumero da conta: " + this.getNumeroConta()
                    + "\nagência: " + this.getAgencia()
                    + "\nsaldo: R$" + this.getSaldo());
        }
    }
}