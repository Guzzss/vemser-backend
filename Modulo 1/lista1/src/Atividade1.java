import java.util.Scanner;

public class Atividade1 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = entrada.nextInt();

        entrada.nextLine();

        System.out.print("Qual sua cidade: ");
        String cidade = entrada.nextLine();


        System.out.print("Situada no estado de: ");
        String estado = entrada.nextLine();

        System.out.printf("Olá seu nome é %s, você tem %d anos, é da cidade de %s, situada no estado de %s.", nome, idade, cidade, estado);

        entrada.close();



    }
}
