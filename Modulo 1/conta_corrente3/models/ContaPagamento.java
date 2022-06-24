package conta_corrente3.models;

import conta_corrente3.abstracts.Conta;
import conta_corrente3.interfaces.Impressao;

public class ContaPagamento extends Conta implements Impressao {

    static final Double TAXA_SAQUE = 4.25;

    public ContaPagamento() {
    }

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public Boolean sacar(double sacar) {
        double saldoComTaxa = this.getSaldo() - TAXA_SAQUE;
        if (saldoComTaxa >= sacar && sacar > 0) {
            setSaldo(saldoComTaxa - sacar);
            return true;
        }
        System.out.println("Operação não realizada");
        return false;
    }

    @Override
    public void imprimir() {
        System.out.println("\nCliente: " + this.getCliente()
                + "\nnumero da conta: " + this.getNumeroConta()
                + "\nagência: " + this.getAgencia()
                + "\nsaldo: R$" + this.getSaldo());
    }
}
