import java.util.Scanner;

public class Exercicio6 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o número que deseja buscar no vetor: ");
        int numero = entrada.nextInt();

        int vetor[] =  {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int busca: vetor) {

            if (busca == numero) {
                System.out.println("O número " + numero + " foi encontrado");
                return;
            }
        }
        System.out.println("Não existe o número digitado");

        entrada.close();
    }
}
