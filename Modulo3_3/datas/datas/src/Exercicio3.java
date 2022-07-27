import java.time.LocalDateTime;

public class Exercicio3 {
    public static void main(String[] args) {

        LocalDateTime dataAtual = LocalDateTime.now();
        LocalDateTime dataPosterior = dataAtual.plusDays(15).plusHours(10);

        System.out.println("Dia da semana daqui 15 dias: " + dataPosterior.getDayOfWeek());
        System.out.println("Dia no ano corrido: " + dataPosterior.getDayOfYear());

    }
}
