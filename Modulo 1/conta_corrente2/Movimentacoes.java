package conta_corrente2;

public interface Movimentacoes {

    public Boolean sacar (double sacar);

    public Boolean depositar(double depositar);

    public Boolean transferir(Conta conta, double valor);




}