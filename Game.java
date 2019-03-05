package BatalhaNaval;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private Random generate = new Random();

    public void iniciaJogo(int[][] vetor) {

        int linha = generate.nextInt(10);
        int coluna = generate.nextInt(10);
        boolean cabe = false;
        System.out.println(linha);

        ArrayList<Navio> navios = new ArrayList<>();

        navios.add((Navio) new submarino());
        navios.add((Navio) new contratorpedeiro());
        navios.add((Navio) new navio_tanque());
        navios.add((Navio) new porta_aviao());

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                vetor[i][j] = 0;
            }
        }

        for (int cont = 0; cont < navios.size(); cont++) {
            int contador = 0;
            while (navios.get(cont).getQtdDeNavios() > contador) {
                int orientacao = generate.nextInt(2);
                cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
                if (cabe == false) {
                    while (cabe == false) {
                        linha = generate.nextInt(10);
                        coluna = generate.nextInt(10);
                        cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
                    }
                }

                if (orientacao == 0) {
                    for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++) {
                        vetor[linha][coluna] = 1;
                        linha++;
                    }
                } else if (orientacao == 1) {
                    for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++) {
                        vetor[linha][coluna] = 1;
                        coluna++;
                    }
                }
                contador++;
            }
        }
    }

    public boolean cabeNavio(int linha, int coluna, int orientacao, int tamanho, int vetor[][]) {

        if (orientacao == 0) {
            if (linha > (9 - tamanho)) {
                return false;
            }
            for (int row = 0; row < tamanho; row++) {
                if (vetor[linha][coluna] == 0) {
                    linha++;
                } else {
                    return false;
                }
            }
            return true;
        }

        if (orientacao == 1) {
            if (coluna > (9 - tamanho)) {
                return false;
            }
            for (int col = 0; col < tamanho; col++) {
                if (vetor[linha][coluna] == 0) {
                    coluna++;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
