package conta_corrente3.models;

import conta_corrente3.abstracts.Conta;
import conta_corrente3.interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {

    static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
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
