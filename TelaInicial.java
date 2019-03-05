package BatalhaNaval;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane = new JPanel();
    private JTextField caixaDeTexto = new JTextField(20);
    private JButton iniciarJogo = new JButton("Iniciar Jogo");
    private JButton fecharJogo = new JButton("Fechar Jogo");
    private JButton ranking = new JButton("Ranking");
    private JLabel labelBatalhaNaval = new JLabel("Batalha Naval");
    private JLabel labelUsuario = new JLabel("Insira o usu\u00E1rio:");

    public TelaInicial() {

        setTitle("Batalha Naval");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 507, 409);
        contentPane.setBorder(null);
        contentPane.setLayout(null);
        setContentPane(contentPane);
        caixaDeTexto.setBounds(133, 141, 223, 29);
        contentPane.add(caixaDeTexto);
        labelBatalhaNaval.setFont(new Font("Roboto", Font.BOLD, 18));
        labelBatalhaNaval.setBounds(182, 11, 120, 29);
        contentPane.add(labelBatalhaNaval);
        labelUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
        labelUsuario.setBounds(135, 116, 105, 14);
        contentPane.add(labelUsuario);
        iniciarJogo.setBounds(182, 238, 111, 36);
        iniciarJogo.setFont(new Font("Verdana", Font.PLAIN, 12));
        iniciarJogo.addActionListener(this);
        contentPane.add(iniciarJogo);

        fecharJogo.setBounds(327, 238, 120, 36);
        fecharJogo.setFont(new Font("Verdana", Font.PLAIN, 12));
        fecharJogo.setFocusable(false);
        fecharJogo.addActionListener(this);
        contentPane.add(fecharJogo);

        setLocationRelativeTo(null);

        getRootPane().setDefaultButton(iniciarJogo);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == iniciarJogo) {

            String nomeJogador = caixaDeTexto.getText();

            if (nomeJogador.equals("")) {
                JOptionPane.showMessageDialog(null, "Insira um usuário válido");
            }

            if (!(nomeJogador.equals(""))) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        Tabuleiro tabuleiro = new Tabuleiro(nomeJogador);
                        tabuleiro.setVisible(true);
                    }
                });

                caixaDeTexto.setText("");
            }
        }

        if (e.getSource() == fecharJogo) {
            System.exit(0);
        }

    }
}
