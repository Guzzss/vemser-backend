package conta_corrente3.interfaces;

import conta_corrente3.abstracts.Conta;

public interface Movimentacao {

    public Boolean sacar (double sacar);

    public Boolean depositar(double depositar);

    public Boolean transferir(Conta conta, double valor);

}