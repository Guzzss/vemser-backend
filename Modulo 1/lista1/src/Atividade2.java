import java.util.Scanner;

public class Atividade2 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a primeira nota: ");
        double nota1 = entrada.nextDouble();

        System.out.println("Digite a segunda nota: ");
        double nota2 = entrada.nextDouble();

        System.out.println("Digite a terceira nota: ");
        double nota3 = entrada.nextDouble();

        System.out.println("Digite a quarta nota: ");
        double nota4 = entrada.nextDouble();

        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        if (media >= 7) {
            System.out.printf("Sua nota foi: %.1f = aprovado!", media);
        } else if (media >= 5.1 && media <= 6.9) {
            System.out.printf("Sua nota foi: %.1f = em exame!", media);
        }else if (media >= 0  && media < 5) {
            System.out.printf("Sua nota foi: %.1f = reprovado!", media);
        }

        entrada.close();
    }
}
