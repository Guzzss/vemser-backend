import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int vetor[]  = new int[20];

        for(int i = 0; i < vetor.length; i++){
            System.out.println("Digite o " + (i + 1) + "º numero: ");
            vetor[i] = entrada.nextInt();
        }

        System.out.println("Em ordem contrária: ");
        for(int i = vetor.length - 1; i >= 0; i--){
            System.out.println(vetor[i]);
        }

        entrada.close();
    }
}
