public class Main {

    public static void main(String[] args) {

        Cliente paulo = new Cliente();
        paulo.nome = "Paulo";
        paulo.cpf = "731.189.980-08";

        Contato contatoPaulo1 = new Contato();

        contatoPaulo1.tipo = 1;
        contatoPaulo1.telefone = "05198986034";
        contatoPaulo1.descricao = "Ola world";

        Contato contatoPaulo2 = new Contato();

        contatoPaulo2.tipo = 2;
        contatoPaulo2.telefone = "05198987324";
        contatoPaulo2.descricao = "Ola marte";

        Endereco enderecoPaulo1 = new Endereco();

        enderecoPaulo1.tipo = 1;
        enderecoPaulo1.cep = "90640-110";
        enderecoPaulo1.pais = "Brasil";
        enderecoPaulo1.estado = "RS";
        enderecoPaulo1.cidade = "Porto Alegre";
        enderecoPaulo1.logradouro = "Rua Dona Alice";
        enderecoPaulo1.numero = 123;
        enderecoPaulo1.complemento = "Bairro Petrópolis";

        Endereco enderecoPaulo2 = new Endereco();

        enderecoPaulo2.tipo = 2;
        enderecoPaulo2.cep = "91760-631";
        enderecoPaulo2.pais = "Brasil";
        enderecoPaulo2.estado = "RS";
        enderecoPaulo2.cidade = "Porto Alegre";
        enderecoPaulo2.logradouro = "Beco Dois";
        enderecoPaulo2.numero = 414;
        enderecoPaulo2.complemento = "Bairro Ipanema";

        paulo.enderecos[0] = enderecoPaulo1;
        paulo.enderecos[1] = enderecoPaulo2;

        paulo.contatos[0] = contatoPaulo1;
        paulo.contatos[1] = contatoPaulo2;

        ///////////////////////////////////////////

        Cliente marcos = new Cliente();
        marcos.nome = "Marcos";
        marcos.cpf = "230.239.236-30";

        Contato contatoMarcos1 = new Contato();

        contatoMarcos1.tipo = 1;
        contatoMarcos1.telefone = "05198971212";
        contatoMarcos1.descricao = "Ausente";

        Contato contatoMarcos2 = new Contato();

        contatoMarcos2.tipo = 2;
        contatoMarcos2.telefone = "05199608023";
        contatoMarcos2.descricao = "Ocupado";

        Endereco enderecoMarcos1 = new Endereco();

        enderecoMarcos1.tipo = 1;
        enderecoMarcos1.cep = "94100-040";
        enderecoMarcos1.pais = "Brasil";
        enderecoMarcos1.estado = "RS";
        enderecoMarcos1.cidade = "Gravataí";
        enderecoMarcos1.logradouro = "Rua Paquetá";
        enderecoMarcos1.numero = 23;
        enderecoMarcos1.complemento = "Bairro Neópolis";

        Endereco enderecoMarcos2 = new Endereco();

        enderecoMarcos2.tipo = 2;
        enderecoMarcos2.cep = "94198-304";
        enderecoMarcos2.pais = "Brasil";
        enderecoMarcos2.estado = "RS";
        enderecoMarcos2.cidade = "Gravataí";
        enderecoMarcos2.logradouro = "Rua Cantagalo";
        enderecoMarcos2.numero = 472;
        enderecoMarcos2.complemento = "Vila Imperial";

        marcos.enderecos[0] = enderecoMarcos1;
        marcos.enderecos[1] = enderecoMarcos2;

        marcos.contatos[0] = contatoMarcos1;
        marcos.contatos[1] = contatoMarcos2;

        ///////////////////////////////////////

        ContaCorrente contaPaulo = new ContaCorrente();

        contaPaulo.cliente = paulo;
        contaPaulo.numeroConta = "137896-1";
        contaPaulo.agencia = 7160;
        contaPaulo.saldo = 500.00;
        contaPaulo.chequeEspecial = 1000.00;

        ContaCorrente contaMarcos = new ContaCorrente();

        contaMarcos.cliente = marcos;
        contaMarcos.numeroConta = "102468-2";
        contaMarcos.agencia = 3749;
        contaMarcos.saldo = 300.00;
        contaMarcos.chequeEspecial = 600.00;

        //Testes do metodos da classe Cliente
        paulo.imprimirCliente();
        paulo.imprimirContatos();
        paulo.imprimirEnderecos();

        System.out.println("______________________");

        marcos.imprimirCliente();
        marcos.imprimirContatos();
        marcos.imprimirEnderecos();
//
//        //Testes do metodos da classe Contato
//        System.out.println("______________________");
//
//        contatoPaulo1.imprimirContato();
//        contatoPaulo2.imprimirContato();
//
//        System.out.println("______________________");
//
//        contatoMarcos1.imprimirContato();
//        contatoMarcos2.imprimirContato();
//
//        //Testes do metodos da classe Endereco
//        System.out.println("______________________");
//
//        enderecoPaulo1.imprimirEndereco();
//        enderecoPaulo2.imprimirEndereco();
//
//        System.out.println("______________________");
//
//        enderecoMarcos1.imprimirEndereco();
//        enderecoMarcos2.imprimirEndereco();
//
//        //Testes do metodos da classe ContaCorrente
//        System.out.println("______________________");
//
//        contaMarcos.imprimirContaCorrente();
//        contaPaulo.imprimirContaCorrente();
//
//        System.out.println("______________________");
//
//        System.out.println("Saldo: R$" + contaMarcos.saldo);
//        contaMarcos.sacar(20);
//        System.out.println("Saldo: R$" + contaMarcos.saldo);
//        contaMarcos.depositar(20);
//        System.out.println("Saldo: R$" + contaMarcos.saldo);
//
//        System.out.println("______________________");
//
//        System.out.println("Saldo: R$" + contaMarcos.saldo);
//        System.out.println("Cheque especial: R$" + contaMarcos.chequeEspecial);
//        System.out.println("Saldo com cheque especial: R$" + contaMarcos.retornarSaldoComChequeEspecial());
//
//        System.out.println("______________________");
//
//        System.out.println("Saldo: R$" + contaMarcos.saldo);
//        System.out.println("Saldo: R$" + contaPaulo.saldo);
//        contaPaulo.transferir(contaMarcos, 50);
//        System.out.println("Saldo: R$" + contaMarcos.saldo);
//        System.out.println("Saldo: R$" + contaPaulo.saldo);












//        Contato[] contatosPaulo = new Contato[2];
//
//        Contato pauloContato1 = new Contato();
//        pauloContato1.tipo = 1;
//        pauloContato1.telefone = "05198986034";
//        pauloContato1.descricao = "Ola world";
//        contatosPaulo[0] = pauloContato1;
//
//        Contato pauloContato2 = new Contato();
//        pauloContato2.tipo = 2;
//        pauloContato2.telefone = "05198987324";
//        pauloContato2.descricao = "Ola marte";
//        contatosPaulo[1] = pauloContato2;
//
//        paulo.contatos = contatosPaulo;
//
//        Endereco[] enderecosPaulo = new Endereco[2];
//
//        Endereco pauloEndereco1 = new Endereco();
//        pauloEndereco1.tipo = 1;
//        pauloEndereco1.cep = "90640-110";
//        pauloEndereco1.pais = "Brasil";
//        pauloEndereco1.estado = "RS";
//        pauloEndereco1.cidade = "Porto Alegre";
//        pauloEndereco1.logradouro = "Rua Dona Alice";
//        pauloEndereco1.numero = 123;
//        pauloEndereco1.complemento = "Bairro Petrópolis";
//
//        enderecosPaulo[0] = pauloEndereco1;
//
//        Endereco pauloEndereco2 = new Endereco();
//        pauloEndereco2.tipo = 2;
//        pauloEndereco2.cep = "91760-631";
//        pauloEndereco2.pais = "Brasil";
//        pauloEndereco2.estado = "RS";
//        pauloEndereco2.cidade = "Porto Alegre";
//        pauloEndereco2.logradouro = "Beco Dois";
//        pauloEndereco2.numero = 414;
//        pauloEndereco2.complemento = "Bairro Ipanema";
//
//        enderecosPaulo[1] = pauloEndereco2;
//
//        paulo.enderecos = enderecosPaulo;
//
//        ///////////////////////////////////////////////
//
//        Cliente marcos = new Cliente();
//        marcos.nome = "Marcos";
//        marcos.cpf = "230.239.236-30";
//
//        Contato[] contatosMarcos = new Contato[2];
//
//        Contato marcosContato1 = new Contato();
//        marcosContato1.tipo = 1;
//        marcosContato1.telefone = "05198971212";
//        marcosContato1.descricao = "Ocupado";
//
//        contatosMarcos[0] = marcosContato1;
//
//        Contato marcosContato2 = new Contato();
//        marcosContato2.tipo = 2;
//        marcosContato2.telefone = "05199608023";
//        marcosContato2.descricao = "ausente";
//
//        contatosMarcos[1] = marcosContato2;
//
//        marcos.contatos = contatosMarcos;
//
//        Endereco[] enderecosMarcos = new Endereco[2];
//
//        Endereco marcosEndereco1 = new Endereco();
//        marcosEndereco1.tipo = 1;
//        marcosEndereco1.cep = "94100-040";
//        marcosEndereco1.pais = "Brasil";
//        marcosEndereco1.estado = "RS";
//        marcosEndereco1.cidade = "Gravataí";
//        marcosEndereco1.logradouro = "Rua Paquetá";
//        marcosEndereco1.numero = 23;
//        marcosEndereco1.complemento = "Bairro Neópolis";
//
//        enderecosMarcos[0] = marcosEndereco1;
//
//        Endereco marcosEndereco2 = new Endereco();
//        marcosEndereco2.tipo = 2;
//        marcosEndereco2.cep = "94198-304";
//        marcosEndereco2.pais = "Brasil";
//        marcosEndereco2.estado = "RS";
//        marcosEndereco2.cidade = "Gravataí";
//        marcosEndereco2.logradouro = "Rua Cantagalo";
//        marcosEndereco2.numero = 44;
//        marcosEndereco2.complemento = "Vila Imperial";
//
//        enderecosMarcos[1] = marcosEndereco2;
//
//        marcos.enderecos = enderecosMarcos;
//
//        ContaCorrente contaPaulo = new ContaCorrente();
//
//        contaPaulo.clinte = paulo;
//        contaPaulo.numeroConta = "137896-1";
//        contaPaulo.agencia = 7160;
//        contaPaulo.saldo = 500;
//        contaPaulo.chequeEspecial = 1000;
//
//        ContaCorrente contaMarcos = new ContaCorrente();
//
//        contaMarcos.clinte = marcos;
//        contaMarcos.numeroConta = "102468-2";
//        contaMarcos.agencia = 3749;
//        contaMarcos.saldo = 300;
//        contaMarcos.chequeEspecial = 600;

//        System.out.println(contaMarcos.saldo);
//        marcos.imprimirEnderecos();
//        contaMarcos.depositar(20);
//        System.out.println(contaMarcos.saldo);

        //Testeando metodos classe Cliente
//        marcos.imprimirContatos();
//        paulo.imprimirContatos();
//
//        marcos.imprimirEnderecos();
//        paulo.imprimirEnderecos();
//
//        marcos.imprimirCliente();
//        paulo.imprimirCliente();

        //Testeando metodos classe Contato
//        pauloContato1.imprimirContato();
//        pauloContato2.imprimirContato();
//
//        marcosContato1.imprimirContato();
//        marcosContato2.imprimirContato();

        //Testeando metodos classe Endereco
//        marcosEndereco1.imprimirEndereco();
//        marcosEndereco2.imprimirEndereco();
//
//        pauloEndereco1.imprimirEndereco();
//        pauloEndereco2.imprimirEndereco();

//        //Testeando metodos classe ContaCorrente
//        System.out.println(contaMarcos.saldo);
//        contaMarcos.depositar(20);
//        System.out.println(contaMarcos.saldo);
//
//        contaMarcos.sacar(20);
//        System.out.println(contaMarcos.saldo);

//        System.out.println(contaMarcos.saldo);
//        System.out.println(contaMarcos.chequeEspecial);
//        System.out.println( contaMarcos.retornarSaldoComChequeEspecial());
//          System.out.println(contaMarcos.saldo);
//        System.out.println(contaPaulo.saldo);
//          contaPaulo.transferir(contaMarcos, 50);
//          System.out.println(contaMarcos.saldo);
//        System.out.println(contaPaulo.saldo);





    }
}
