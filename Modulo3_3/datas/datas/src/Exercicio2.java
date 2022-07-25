import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a primeira data: ");
        LocalDate primeiraData = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Informe a segunda data: ");
        LocalDate segundaData = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Period periodo = Period.between(primeiraData, segundaData);
        System.out.println("Diferença de " + periodo.getDays() + " dias, " + periodo.getMonths() + " meses e " + periodo.getYears() + " anos.");
    }
}
