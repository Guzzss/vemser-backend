import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do jogador: ");
        String nome = entrada.nextLine();

        int qtdeJogador = 0;
        double alturaMaiorJogador = 0;
        int jogadorMaisVelho = 0;
        double jogadorMaisPesado = 0;
        double mediaAltura = 0;

        while (!"SAIR".equalsIgnoreCase(nome)) {

            System.out.println("Digite a altura do jogador: ");
            double altura = entrada.nextDouble();
            entrada.nextLine();

            if (altura > alturaMaiorJogador) {
                alturaMaiorJogador = altura;
            }

            System.out.println("Digite a idade do jogador: ");
            int idade = entrada.nextInt();

            if (idade > jogadorMaisVelho) {
                jogadorMaisVelho = idade;
            }

            System.out.println("Digite o peso do jogador: ");
            int peso = entrada.nextInt();

            if (peso > jogadorMaisPesado) {
                jogadorMaisPesado = peso;
            }

            qtdeJogador++;
            mediaAltura += altura;

            entrada.nextLine();

            System.out.println("Digite o nome do jogador: ");
            nome = entrada.nextLine();
        }

        double somaMediaAltura = 0;

        if (qtdeJogador > 0) {
            somaMediaAltura = mediaAltura / qtdeJogador;
        }

        System.out.println("Quantidade de jogadores cadastrados: " + qtdeJogador);
        System.out.printf("Altura do maior jogador %.2f mts ", alturaMaiorJogador);
        System.out.println("\nJogador mais pesado: " + jogadorMaisPesado + "Kg");
        System.out.printf("Média das alturas %.2f mts", somaMediaAltura);

        entrada.close();
    }
}
