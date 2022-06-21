import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Nesse jogo você tentara acertar o número escolhido :)");

        System.out.println("Digite um número: ");
        int numeroEscolhido = entrada.nextInt();

        while (numeroEscolhido != 15) {

            if (numeroEscolhido < 15 ) {
                System.out.println("Numero errado, o numero a ser encontrado é maior do que você digitou.");
            } else if (numeroEscolhido > 15) {
                System.out.println("Numero errado, o numero a ser encontrado é menor do que você digitou.");
            }
            System.out.println("Digite outro número: ");
            numeroEscolhido = entrada.nextInt();
        }

        System.out.println("Parabéns, você acertou o número!");

        entrada.close();
    }
}
