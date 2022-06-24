package conta_corrente2.interfaces;

import conta_corrente2.abstracts.Conta;

public interface Movimentacao {

    public Boolean sacar (double sacar);

    public Boolean depositar(double depositar);

    public Boolean transferir(Conta conta, double valor);

}