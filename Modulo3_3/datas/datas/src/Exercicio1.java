import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a data do seu aniversario no formato dd/mm/yyyy: ");
        String dataAniversario = scanner.nextLine();
        LocalDate dataFormatada = LocalDate.parse(dataAniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy")).withYear(LocalDate.now().getYear());
        LocalDate dataAtual = LocalDate.now();

        Period periodo = Period.between(dataAtual, dataFormatada.plusYears(1));

        System.out.println("Faltam " + periodo.getMonths() + " meses e " + periodo.getDays() +  " dias até seu aniversario ");

    }
}

