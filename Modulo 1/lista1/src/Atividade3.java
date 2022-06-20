import java.util.Scanner;

public class Atividade3 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Valor total Consumido: ");
        double valorTotal = entrada.nextDouble();

        System.out.println("Valor pago: ");
        double valorPago = entrada.nextDouble();

        double trocoCliente = (valorTotal - valorPago) * -1;

        if (valorPago < valorTotal) {
            System.out.println("O valor pago deve ser maior ou igual ao valor consumido");
        } else if (valorPago >= valorTotal) {
            System.out.println("troco: " + trocoCliente);
        }

    entrada.close();
    }
}
