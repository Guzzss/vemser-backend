import java.util.Scanner;

public class Atividade6 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite a palavra gostaria de traduzir:\n"
                + "(Cachorro)\n"
                + "(Tempo)\n"
                + "(Amor)\n"
                + "(Cidade)\n"
                + "(Feliz)\n"
                + "(Triste)\n"
                + "(Deveria)\n"
                + "(Poderia)\n"
                + "(Dog)\n"
                + "(Time)\n"
                + "(Love)\n"
                + "(city)\n"
                + "(Happy)\n"
                + "(Sad)\n"
                + "(Shoud)\n"
                + "(Could)\n");
        String palavra = entrada.nextLine().toLowerCase();

        switch (palavra) {
            case "dog": palavra = "Cachorro";
                System.out.println(palavra);
                break;
                case "cachorro": palavra = "Dog";
                System.out.println(palavra);
                break;
            case "tempo": palavra = "Time";
                System.out.println(palavra);
                break;
            case "time": palavra = "Tempo";
                System.out.println(palavra);
                break;
            case "amor": palavra = "Love";
                System.out.println(palavra);
                break;
            case "love": palavra = "Amor";
                System.out.println(palavra);
                break;
            case "cidade": palavra = "City";
                System.out.println(palavra);
                break;
            case "city": palavra = "Cidade";
                System.out.println(palavra);
                break;
            case "feliz": palavra = "Happy";
                System.out.println(palavra);
                break;
            case "happy": palavra = "Feliz";
                System.out.println(palavra);
                break;
            case "triste": palavra = "Sad";
                System.out.println(palavra);
                break;
            case "sad": palavra = "Triste";
                System.out.println(palavra);
                break;
            case "deveria": palavra = "Shoud";
                System.out.println(palavra);
                break;
            case "shoud": palavra = "Deveria";
                System.out.println(palavra);
                break;
            case "poderia": palavra = "Could";
                System.out.println(palavra);
                break;
            case "could": palavra = "Poderia";
                System.out.println(palavra);
                break;
            default:
                System.out.println("Essa palavra não é valida");
        }

        entrada.close();
    }
}
