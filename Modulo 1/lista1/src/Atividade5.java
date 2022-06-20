import java.util.Scanner;

public class Atividade5 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite sua remuneração por hora: ");
        double horaEmReais = entrada.nextDouble();

        System.out.println("Digite suas horas normais trabalhadas: ");
        double horasNormaisTrabalhadas = entrada.nextDouble();

        System.out.println("Digite suas horas extras: ");
        double horasExtras = entrada.nextDouble();

        System.out.println("Digite suas horas em dobro: ");
        double horasExtrasEmDobro = entrada.nextDouble();

        double salarioBruto = (horasNormaisTrabalhadas * horaEmReais)
                + (horasExtras * horaEmReais * 1.5)
                + (horasExtrasEmDobro * horaEmReais * 2);

        System.out.println("R$" + salarioBruto);
    }
}
