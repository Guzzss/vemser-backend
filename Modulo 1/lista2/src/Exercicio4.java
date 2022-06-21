import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        int n1 = entrada.nextInt();

        System.out.println("Digite o segundo número: ");
        int n2 = entrada.nextInt();

        System.out.println("Digite o terceiro número: ");
        int n3 = entrada.nextInt();

        int vetor[]  = {n1, n2, n3};

        int indice = 0;

        if (n1 < n2 && n1 < n3) {
            indice = 0;
        } else if (n2 < n1 && n2 < n3) {
            indice = 1;
        } else if (n3 < n1 && n3 < n2) {
            indice = 2;
        }
        System.out.println("O menor valor está no indice: " + indice);

        entrada.close();
    }
}
