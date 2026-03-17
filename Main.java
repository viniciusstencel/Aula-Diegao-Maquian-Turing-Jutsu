import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String entrada = "TTNNGG";
        char[] fita = entrada.toCharArray();

        int i = 0;
        int estado = 0;
        int n = fita.length;

        System.out.println("Validando: " + entrada);

        while (true) {

            if (i < 0 || i >= n) {
                if (estado == 0) break;
                else {
                    System.out.println("ERRO: Cadeia incompleta.");
                    return;
                }
            }

            char atual = fita[i];

            switch (estado) {
                case 0:
                    if (atual == 'T') {
                        fita[i] = 'X';
                        estado = 1;
                        i++;
                    } else if (atual == 'X' || atual == 'Y' || atual == 'Z') {
                        i++;
                    } else {

                        i++;
                    }
                    break;

                case 1:
                    if (atual == 'N') {
                        fita[i] = 'Y';
                        estado = 2;
                        i++;
                    } else if (atual == 'T' || atual == 'Y') {
                        i++;
                    } else {
                        System.out.println("REJEITADO: Falta o Ninjutsu (N)");
                        return;
                    }
                    break;

                case 2:
                    if (atual == 'G') {
                        fita[i] = 'Z';
                        estado = 3;
                    } else if (atual == 'N' || atual == 'Z') {
                        i++;
                    } else {
                        System.out.println("REJEITADO: Falta o Genjutsu (G)");
                        return;
                    }
                    break;

                case 3:
                    if (i > 0) {
                        i--;
                    } else {
                        estado = 0;
                    }
                    break;
            }


            System.out.println(new String(fita) + " | i=" + i + " | est=" + estado);
        }


        boolean ok = true;
        for (char c : fita) {
            if (c == 'T' || c == 'N' || c == 'G') {
                ok = false;
                break;
            }
        }

        if (ok) System.out.println("\n>>> EXAME APROVADO!");
        else System.out.println("\n>>> REJEITADO: Quantidades desiguais.");
    }
}