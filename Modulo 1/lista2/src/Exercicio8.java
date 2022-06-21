import java.util.Scanner;

public class Exercicio8 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int matriz[][] = new int[5][4];

        for (int i = 0; i < 5; i++) {
            for (int a = 0; a < 4; a++) {
                System.out.println("Linha: " + (i + 1) + " e coluna " + (a + 1));
                matriz[i][a] = entrada.nextInt();
            }
        }

        double maiorNota = 0;
        double melhorMatricula = 0;
        double media = 0;

        for (int i=0; i<5; i++) {
            do {
                int mediaDasProvas = matriz[(i)][1];
                int mediaDosTrabalhos = matriz[(i)][2];

                double trabalhoFinal = (double) mediaDasProvas * 0.6 + (double) mediaDosTrabalhos * 0.4;
                media += trabalhoFinal;

                if (trabalhoFinal > maiorNota) {
                    maiorNota = trabalhoFinal;
                    melhorMatricula = i;
                }
                i++;

            } while (i<5);
        }

        System.out.println("Numero da matricula que obteve a maior nota: " + ((int) melhorMatricula+1));

        media /= 5;

        System.out.println("A Média das notas finais foi: " + media );

        entrada.close();

    }

    }

