import java.util.Scanner;

public class Atividade10 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o total de Eleitores: ");
        int totalEleitores = entrada.nextInt();

        System.out.println("Digite a quantidade de votos em brancos: ");
        int votosEmBranco = entrada.nextInt();

        System.out.println("Digite a quantidade de votos nulos: ");
        int votosNulos = entrada.nextInt();

        System.out.println("Digite a quantidade de votos válidos: ");
        int votosValidos = entrada.nextInt();

        double votosEmBrancoPercentual = ((double) votosEmBranco / totalEleitores) * 100;
        System.out.println("Percentual de votos em brancos: " + votosEmBrancoPercentual);

        double votosNulosPercentual = ((double) votosNulos / totalEleitores) * 100;
        System.out.println("Percentual de votos nulos: " + votosNulosPercentual);

        double votosValidosPercentual = ((double) votosValidos / totalEleitores) * 100;
        System.out.println("Percentual de votos válidos: " + votosValidosPercentual);

    }
}


