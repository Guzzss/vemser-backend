import java.util.Scanner;

public class Atividade4 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Digite qual estado deseja: 1- RS, 2- SC, 3- PR");
        int estado = entrada.nextInt();

        switch (estado){
            case 1:
                System.out.println("Escolha a cidade: (1 - Gravataí / 2 - Pelotas)");
                int cidadeRS = entrada.nextInt();
                switch (cidadeRS){
                    case 1:
                        System.out.println("População: 283.620\n"
                                + "Principal festa: Festa de Nossa Senhora dos Navegantes\n"
                                + "IDH: 0.736");
                        break;
                    case 2:
                        System.out.println("População: 343.132\n"
                                + "Principal festa: Feira Nacional do Doce\n"
                                + "IDH: 0,739");
                        break;
                }
                break;
            case 2:
                System.out.println("Escolha a cidade: (1 - Agrolândia / 2 - Florianópolis)");
                int cidadeSC = entrada.nextInt();
                switch (cidadeSC){
                    case 1:
                        System.out.println("População: 11.160\n"
                                + "Principal festa: Festa da colheita\n"
                                + "IDH: 0,725");
                        break;
                    case 2:
                        System.out.println("População: 516.524\n"
                                + "Principal festa : Fenaostra\n"
                                + "IDH: 0,847");
                        break;
                }
                break;
            case 3:
                System.out.println("Escolha a cidade: (1 - Curitiba / 2 - Porto Amazonas)");
                int cidadePR = entrada.nextInt();
                switch (cidadePR){
                    case 1:
                        System.out.println("População: 1.981.895\n"
                                + "Principal festa: Festa do Frango, Polenta e Vinho\n"
                                + "IDH: 0,733");
                        break;
                    case 2:
                        System.out.println("População: 4.848\n"
                                + "Principal festa: Festa da maçã\n"
                                + "IDH: 0,700");
                        break;
                }
                break;
        }

    }
}
