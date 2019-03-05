package BatalhaNaval;

public class jogador {

    private String nome;
    private int pontuacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Nome: " + this.nome + " Pontuacao: " + this.pontuacao);
        return str.toString();
    }

    public int compareTo(jogador jog) {
        int compararPontos = ((jogador) jog).getPontuacao();
        return compararPontos - this.pontuacao;
    }
}
