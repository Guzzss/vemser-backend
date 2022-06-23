package conta_corrente2;

public class Main {

    public static void main(String[] args) {

        Endereco enderecoPaulo1 = new Endereco(1
                , "90640-110"
                , "Brasil"
                , "RS"
                , "Porto Alegre"
                , "Rua Dona Alice"
                , 123
                , "Bairro Petrópolis");

        Endereco enderecoPaulo2 = new Endereco(2
                , "91760-631"
                , "Brasil"
                , "RS"
                , "Porto Alegre"
                , "Beco Dois"
                , 414
                , "Bairro Ipanema");

        Contato contatoPaulo1 = new Contato("Ola world","05198986034",1);

        Contato contatoPaulo2 = new Contato("Ola marte", "05198987324", 2);

        Cliente paulo = new Cliente("Paulo"
                , "731.189.980-08"
                , new Endereco[]{enderecoPaulo1,enderecoPaulo2}
                , new Contato[]{contatoPaulo1,contatoPaulo2});

        ////////////////////////////////////////////////////////////////

        Endereco enderecoMarcos1 = new Endereco(1
                , "94100-040"
                , "Brasil"
                , "RS"
                , "Gravataí"
                , "Rua Paquetá"
                , 23
                , "Bairro Neópolis");

        Endereco enderecoMarcos2 = new Endereco(2
                , "94198-304"
                , "Brasil"
                , "RS"
                , "Gravataí"
                , "Rua Cantagalo"
                , 472
                , "Vila Imperial");

        Contato contatoMarcos1 = new Contato("Ausente", "05198971212", 1);
        Contato contatoMarcos2 = new Contato("Ocupado", "05199608023", 2);

        Cliente marcos = new Cliente("Marcos"
                , "230.239.236-30"
                , new Endereco[]{enderecoMarcos1, enderecoMarcos2}
                , new Contato[]{contatoMarcos1, contatoMarcos2});

        ContaCorrente contaPaulo = new ContaCorrente(paulo,"137896-1", "7160", 500.00);

        ContaPoupaca contaMarcos = new ContaPoupaca(marcos, "102468-2", "3749", 300.00);

        //Testes dos metodos da classe Cliente
        paulo.imprimirCliente();
        paulo.imprimirContatos();
        paulo.imprimirEnderecos();

        System.out.println("______________________");

        marcos.imprimirCliente();
        marcos.imprimirContatos();
        marcos.imprimirEnderecos();
        System.out.println("______________________");

        //Testes dos metodos da classe Contato
        contatoPaulo1.imprimirContato();
        contatoPaulo2.imprimirContato();

        System.out.println("______________________");

        contatoMarcos1.imprimirContato();
        contatoMarcos2.imprimirContato();
        System.out.println("______________________");

        //Testes do metodos da classe Endereco
        enderecoPaulo1.imprimirEndereco();
        enderecoPaulo2.imprimirEndereco();

        System.out.println("______________________");

        enderecoMarcos1.imprimirEndereco();
        enderecoMarcos2.imprimirEndereco();
        System.out.println("______________________");

       //Testes do metodos da classe ContaCorrente/
        contaPaulo.setChequeEspecial(500);
        System.out.println("Saldo com cheque especial: R$" + contaPaulo.retornarSaldoComChequeEspecial());

        System.out.println("______________________");

        System.out.println("Saldo Marcos: R$" + contaMarcos.getSaldo());
        System.out.println("Saldo Paulo: R$" + contaPaulo.getSaldo());
        contaPaulo.transferir(contaMarcos, 100);
        System.out.println("Saldo Marcos: R$" + contaMarcos.getSaldo());
        System.out.println("Saldo Paulo: R$" + contaPaulo.getSaldo());

        System.out.println("______________________");

        System.out.println("Saldo Marcos: R$" + contaMarcos.getSaldo());
        contaMarcos.sacar(200);
        System.out.println("Saldo Marcos: R$" + contaMarcos.getSaldo());
        System.out.println("______________________");

        //Testes do metodos da classe ContaPoupança
        System.out.println("Saldo: R$" + contaMarcos.getSaldo());
        contaMarcos.creditarTaxa();
        System.out.println("Saldo: R$" + contaMarcos.getSaldo());
        System.out.println("______________________");

        //Testes Interfaces
        contaPaulo.imprimir();
        contaMarcos.imprimir();

        System.out.println("______________________");

        System.out.println("Saldo: R$" + contaPaulo.getSaldo());
        contaPaulo.depositar(500);
        System.out.println("Saldo: R$" + contaPaulo.getSaldo());

        System.out.println("______________________");

        System.out.println("Saldo: R$" + contaMarcos.getSaldo());
        contaMarcos.sacar(400);
        System.out.println("Saldo: R$" + contaMarcos.getSaldo());

        System.out.println("______________________");

        System.out.println("Saldo Marcos: R$" + contaMarcos.getSaldo());
        System.out.println("Saldo Paulo: R$" + contaPaulo.getSaldo());
        contaMarcos.transferir(contaPaulo, 50);
        System.out.println("Saldo Marcos: R$" + contaMarcos.getSaldo());
        System.out.println("Saldo Paulo: R$" + contaPaulo.getSaldo());
        }
    }

