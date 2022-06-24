package conta_corrente2.models;

import conta_corrente2.abstracts.Conta;
import conta_corrente2.interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao {

private Double chequeEspecial;

    public ContaCorrente(){
        super();
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void setChequeEspecial(double chequeEspecial){
        this.chequeEspecial = chequeEspecial;
    }

    public Double retornarSaldoComChequeEspecial() {
        return this.getSaldo() + this.chequeEspecial;
    }

    @Override
    public void imprimir() {
        System.out.println("\nCliente: " + this.getCliente()
                + "\nnumero da conta: " + this.getNumeroConta()
                + "\nagência: " + this.getAgencia()
                + "\nsaldo: R$" + this.getSaldo()
                + "\nchequeEspecial: R$" + this.chequeEspecial);
    }

    @Override
    public Boolean sacar(double sacar) {
        if (retornarSaldoComChequeEspecial() >= sacar && sacar > 0) {
            setSaldo(getSaldo() - sacar);
            return true;
        }
        System.out.println("Erro ao sacar");
        return false;
    }
}
