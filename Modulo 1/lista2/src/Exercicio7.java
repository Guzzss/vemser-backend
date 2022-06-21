import java.util.Scanner;

public class Exercicio7 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

       int[][] matriz = new int[4][4];
       int contador = 0;

       for (int i = 0; i < 4; i++) {
           for (int a = 0; a < 4; a++) {
               System.out.println("Digite o valor: ");
               matriz[i][a] = entrada.nextInt();
               if (matriz[i][a] > 10) {
                   contador++;
               }
           }
       }

        System.out.println("A quantidade de valores maior que 10 foi: " + contador);

       entrada.close();
    }
}
