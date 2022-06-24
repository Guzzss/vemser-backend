public class ContaCorrente {

    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    void imprimirContaCorrente() {
        System.out.println("\nCliente: " + this.cliente.nome
                + "\nnumero da conta: " + this.numeroConta
                + "\nagência: " + this.agencia
                + "\nsaldo: R$" + this.saldo
                + "\nchequeEspecial: R$" + this.chequeEspecial);
    }

    Boolean sacar(double sacar) {
        if (this.retornarSaldoComChequeEspecial() >= sacar && sacar > 0) {
            this.saldo -= sacar;
            return true;
        }
        return false;
    }

    Boolean depositar(double depositar) {
        if (depositar > 0) {
            this.saldo += depositar;
            return true;
        }
        return false;
    }

    Double retornarSaldoComChequeEspecial() {
        return this.saldo + this.chequeEspecial;
    }

    Boolean transferir(ContaCorrente conta, double valor) {
        if (this.retornarSaldoComChequeEspecial() >= valor && valor > 0) {
            this.saldo -= valor;
            conta.depositar(valor);
            return true;
        }
        System.out.println("Erro na transferência");
        return false;
    }
}
