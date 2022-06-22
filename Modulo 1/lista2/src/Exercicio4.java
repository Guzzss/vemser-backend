import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {

        int[] numeros = new int[3];

        Scanner entrada = new Scanner(System.in);

        for(int i = 0; i < 3; i ++){
            System.out.println("Digite o " + (i + 1) + "º numero: ");
            numeros[i] = entrada.nextInt();
        }

        int menor = 0;
        int posicaoMenor = 0;

        for(int i = 0; i < 3; i ++){
            if(i == 0){
                menor = numeros[i];
            } else {
                if(menor > numeros[i]){
                    menor = numeros[i];
                    posicaoMenor = i;
                };
            }
        }

        System.out.println("A posição do menor número digitado é: " + posicaoMenor);

        entrada.close();
    }
}
