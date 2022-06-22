import java.util.Scanner;

public class Atividade8 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o valor da base: ");
        double base = entrada.nextDouble();

        System.out.println("Digite o valor da altura: ");
        double altura = entrada.nextDouble();

        double Area = base * altura;

        System.out.println(Area);


    }
}
