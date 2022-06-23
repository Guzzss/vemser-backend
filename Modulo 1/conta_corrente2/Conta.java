package conta_corrente2;

public abstract class Conta implements Movimentacoes {

    private  Cliente cliente;
    private  String numeroConta;
    private String agencia;
    private  Double saldo;

    public Conta() {
    }

    public Conta(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Boolean sacar(double sacar) {
        if (saldo >= sacar && sacar >= 0){
            this.saldo -= sacar;
            return true;
        }
        System.out.println("Erro ao sacar");
        return false;
    }

    @Override
    public Boolean depositar(double depositar) {
        if (depositar > 0) {
            this.saldo += depositar;
            return true;
        }
        System.out.println("Erro ao depositar");
        return false;
    }

    @Override
    public Boolean transferir(Conta conta, double valor) {
        if (this.saldo >= valor && valor > 0) {
            this.saldo -= valor;
            conta.depositar(valor);
            return true;
        }
        System.out.println("Erro na transferência");
        return false;
    }
}

