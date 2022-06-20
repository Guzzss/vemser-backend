import java.util.Scanner;

public class Atividade9 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite sua idade: ");
        int idadeEmAnos = entrada.nextInt();

        System.out.println("E quantos meses? ");
        int idadeEmMeses = entrada.nextInt();

        System.out.println("Por ultimo digite os dias: ");
        int idadeEmDias = entrada.nextInt();

        int calculoIdadeEmDias = idadeEmAnos * 365 + idadeEmMeses * 30 + idadeEmDias;
        System.out.println(calculoIdadeEmDias);


        entrada.close();
    }
}
