package conta_corrente3;

import conta_corrente3.models.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Contato> contatosPaulo = new ArrayList<>();
        contatosPaulo.add(new Contato("Ola world","05198986034",1));
        contatosPaulo.add(new Contato("Ola marte", "05198987324", 2));

        ArrayList<Endereco> enderecosPaulo = new ArrayList<>();
        enderecosPaulo.add(new Endereco(1
                , "90640-110"
                , "Brasil"
                , "RS"
                , "Porto Alegre"
                , "Rua Dona Alice"
                , 123
                , "Bairro Petrópolis"));
        enderecosPaulo.add(new Endereco(2
                , "91760-631"
                , "Brasil"
                , "RS"
                , "Porto Alegre"
                , "Beco Dois"
                , 414
                , "Bairro Ipanema"));

        Cliente paulo = new Cliente("Paulo", "731.189.980-08");
        paulo.setContatos(contatosPaulo);
        paulo.setEnderecos(enderecosPaulo);

//        ////////////////////////////////////////////////////////////////

        ArrayList<Contato> contatosMarcos = new ArrayList<>();
        contatosMarcos.add(new Contato("Ausente", "05198971212", 1));
        contatosMarcos.add(new Contato("Ocupado", "05199608023", 2));

        ArrayList<Endereco> enderecosMarcos = new ArrayList<>();
        enderecosMarcos.add(new Endereco(1
                , "94100-040"
                , "Brasil"
                , "RS"
                , "Gravataí"
                , "Rua Paquetá"
                , 23
                , "Bairro Neópolis"));

        enderecosMarcos.add(new Endereco(2
                , "94198-304"
                , "Brasil"
                , "RS"
                , "Gravataí"
                , "Rua Cantagalo"
                , 472
                , "Vila Imperial"));

        Cliente marcos = new Cliente("Marcos", "230.239.236-30");
        marcos.setContatos(contatosMarcos);
        marcos.setEnderecos(enderecosMarcos);

         ////////////////////////////////////////////////////////////////

        ContaCorrente contaPaulo = new ContaCorrente(paulo,"137896-1", "7160", 500.00);
        contaPaulo.setChequeEspecial(500.00);

        ContaPagamento contaPagamentoPaulo = new ContaPagamento(paulo, "134578-1", "7150", 750.00);

        ContaPoupanca contaMarcos = new ContaPoupanca(marcos, "102468-2", "3749", 300.00);

        //////////////////////////////////////////////////////////////

        System.out.println("---Testando os metodos sacar---");
        System.out.println("Saldo contaCorrente do Paulo: R$" + contaPaulo.getSaldo());
        contaPaulo.sacar(100.00);
        System.out.println("Saldo contaCorrente do Paulo: R$" + contaPaulo.getSaldo());
        contaPaulo.sacar(10000);

        System.out.println("");

        System.out.println("Saldo contaPagamento do Paulo: R$" + contaPagamentoPaulo.getSaldo());
        contaPagamentoPaulo.sacar(200.00);
        System.out.println("Saldo contaPagamento do Paulo: R$" + contaPagamentoPaulo.getSaldo());
        contaPagamentoPaulo.sacar(20000);

        System.out.println("");

        System.out.println("Saldo contaPoupança do Marcos: R$" + contaMarcos.getSaldo());
        contaMarcos.sacar(50.0);
        System.out.println("Saldo contaPoupança do Marcos: R$" + contaMarcos.getSaldo());
        contaMarcos.sacar(5000);

        System.out.println("---------------------------------------");

        System.out.println("---Testando os metodos depositar---");

        System.out.println("Saldo contaCorrente do Paulo: R$" + contaPaulo.getSaldo());
        contaPaulo.depositar(100.00);
        System.out.println("Saldo contaCorrente do Paulo: R$" + contaPaulo.getSaldo());
        contaPaulo.depositar(-100.00);

        System.out.println("");

        System.out.println("Saldo contaPagamento do Paulo: R$" + contaPagamentoPaulo.getSaldo());
        contaPagamentoPaulo.depositar(55.00);
        System.out.println("Saldo contaPagamento do Paulo: R$" + contaPagamentoPaulo.getSaldo());
        contaPagamentoPaulo.depositar(-55.00);

        System.out.println("");

        System.out.println("Saldo contaPoupança do Marcos: R$" + contaMarcos.getSaldo());
        contaMarcos.depositar(100.00);
        System.out.println("Saldo contaPoupança do Marcos: R$" + contaMarcos.getSaldo());
        contaMarcos.depositar(-100.00);

        System.out.println("---------------------------------------");

        System.out.println("---Testando os metodos transferir---");

        System.out.println("Saldo contaCorrente do Paulo: R$" + contaPaulo.getSaldo());
        System.out.println("Saldo contaPagamento do Paulo: R$" + contaPagamentoPaulo.getSaldo());
        contaPaulo.transferir(contaPagamentoPaulo, 50.00);
        System.out.println("Saldo contaCorrente do Paulo: R$" + contaPaulo.getSaldo());
        System.out.println("Saldo contaPagamento do Paulo: R$" + contaPagamentoPaulo.getSaldo());
        contaPaulo.transferir(contaPagamentoPaulo, 500000);

        System.out.println("");

        System.out.println("Saldo contaPagamento do Paulo: R$" + contaPagamentoPaulo.getSaldo());
        System.out.println("Saldo contaPoupança do Marcos: R$" + contaMarcos.getSaldo());
        contaPagamentoPaulo.transferir(contaMarcos, 01.75);
        System.out.println("Saldo contaPagamento do Paulo: R$" + contaPagamentoPaulo.getSaldo());
        System.out.println("Saldo contaPoupança do Marcos: R$" + contaMarcos.getSaldo());
        contaPagamentoPaulo.transferir(contaMarcos, 500000);

        System.out.println("");

        System.out.println("Saldo contaPoupança do Marcos: R$" + contaMarcos.getSaldo());
        System.out.println("Saldo contaCorrente do Paulo: R$" + contaPaulo.getSaldo());
        contaMarcos.transferir(contaPaulo, 00.75);
        System.out.println("Saldo contaPoupança do Marcos: R$" + contaMarcos.getSaldo());
        System.out.println("Saldo contaCorrente do Paulo: R$" + contaPaulo.getSaldo());
        contaMarcos.transferir(contaPaulo, 500000);

        System.out.println("---------------------------------------");

        System.out.println("---Imprimindo contas---");
        contaPaulo.imprimir();
        contaPagamentoPaulo.imprimir();
        contaMarcos.imprimir();

        }
    }

