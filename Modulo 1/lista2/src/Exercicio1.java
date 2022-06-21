import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        String produto = entrada.next();

        System.out.println("Digite o valor do produto: ");
        double valorProduto = entrada.nextDouble();

        double[] vetor = new double[10];
        double desconto = 0.05;

        for(int i = 0; i < vetor.length; i++){
            double calculoDesconto = 0.05;
            vetor[i] = valorProduto - (valorProduto * desconto);
            desconto += calculoDesconto;
            System.out.println((i + 1) + " x R$" + String.format("%.2f", vetor[i]) + " = R$" + String.format("%.2f",(vetor[i] * (i +1))));
        }

        entrada.close();

    }
}
