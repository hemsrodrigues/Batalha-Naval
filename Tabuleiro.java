package BatalhaNaval;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabuleiro extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    JPanel grid = new JPanel();
    JPanel jContentPane = new JPanel();
    Container cp;
    JButton[][] Botoes = new JButton[10][10];
    JButton novo = new JButton("Novo Jogo");
    JButton voltar = new JButton("Voltar");
    JLabel naviosRestantes = new JLabel("Navios Restantes");
    JLabel tirosRestantes = new JLabel("Tiros Restantes");
    JLabel contNavios = new JLabel("");
    JLabel contTiros = new JLabel("");
    int contadorNavio = 19;
    int contadorTiro = 30;
    int vetor[][] = new int[10][10];
    int pontuacao = 0;
    String nomeJogador;
    Game jogo = new Game();
    jogador jogador = new jogador();

    public Tabuleiro(String nomeJogador) {

        setTitle("Batalha Naval");
        setSize(507, 415);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setContentPane(jContentPane);
        cp = getContentPane();
        cp.setLayout(null);
        grid.setBounds(3, 58, 497, 325);
        grid.setLayout(new GridLayout(10, 10, 2, 2));

        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {
                Botoes[linha][coluna] = new JButton("");
                Botoes[linha][coluna].addActionListener(this);
                Botoes[linha][coluna].setFocusable(false);
                grid.add(Botoes[linha][coluna]);
            }
        }

        novo.setBounds(7, 14, 96, 35);
        novo.setFocusable(false);
        novo.addActionListener(this);
        voltar.setBounds(398, 14, 96, 35);
        voltar.setFocusable(false);
        voltar.addActionListener(this);
        naviosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
        naviosRestantes.setBounds(120, 10, 120, 18);
        tirosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
        tirosRestantes.setBounds(272, 10, 118, 18);
        contNavios.setFont(new Font("Roboto", Font.BOLD, 18));
        contNavios.setBounds(170, 28, 20, 26);
        contNavios.setText("" + contadorNavio);
        contTiros.setFont(new Font("Roboto", Font.BOLD, 18));
        contTiros.setBounds(320, 28, 20, 26);
        contTiros.setText("" + contadorTiro);
        cp.add(grid);
        cp.add(novo);
        cp.add(voltar);
        cp.add(naviosRestantes);
        cp.add(tirosRestantes);
        cp.add(contNavios);
        cp.add(contTiros);
        jogo.iniciaJogo(vetor);
        jogador.setNome(nomeJogador);
    }

    public void actionPerformed(ActionEvent e) {

        // Função do botão Voltar
        if (e.getSource() == voltar) {
            this.dispose();

        }

        for (int linha = 0; linha < 10; linha++) {
            for (int coluna = 0; coluna < 10; coluna++) {

                if (e.getSource() == Botoes[linha][coluna]) {
                    --contadorTiro;
                    contTiros.setText("" + contadorTiro);

                    if (vetor[linha][coluna] == 0) {
                        Botoes[linha][coluna].setEnabled(false);
                    } else if (vetor[linha][coluna] != 0) {
                        Botoes[linha][coluna].setEnabled(false);
                        contNavios.setText("" + --contadorNavio);
                        pontuacao++;
                    }

                    if (contadorTiro == 0) {

                        JOptionPane.showMessageDialog(this, "Fim de Jogo. Sua pontuação: " + pontuacao, "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);

                        Tabuleiro tabuleiro = new Tabuleiro(jogador.getNome());
                        tabuleiro.setVisible(true);
                    }
                }
            }
        }

        if (e.getSource() == novo) {

            this.dispose();

            Tabuleiro tabuleiro = new Tabuleiro(jogador.getNome());
            tabuleiro.setVisible(true);

            JOptionPane.showMessageDialog(this, "Jogo reiniciado!", "Novo Jogo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
