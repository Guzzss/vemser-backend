import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Nesse jogo um jogador tentara acertar o número escolhido pelo outro jogador :)");

        System.out.println("Digite o número escolhido: ");
        int numeroCerto = entrada.nextInt();

        System.out.println("Tente acertar o número escolhido: ");
        int numeroEscolhido = entrada.nextInt();

        while (numeroEscolhido != numeroCerto) {

            if (numeroEscolhido < numeroCerto ) {
                System.out.println("Numero errado, o numero a ser encontrado é maior do que você digitou.");
            } else if (numeroEscolhido > numeroCerto) {
                System.out.println("Numero errado, o numero a ser encontrado é menor do que você digitou.");
            }
            System.out.println("Digite outro número: ");
            numeroEscolhido = entrada.nextInt();
        }

        System.out.println("Parabéns, você acertou o número!");

        entrada.close();
    }
}
