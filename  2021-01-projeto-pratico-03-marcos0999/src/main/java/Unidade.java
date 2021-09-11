import edu.princeton.cs.algs4.Draw;

import java.awt.*;

/**
 * Classe que vai ser herdada por todas as peças de Xadrez
 *
 * @author Marcos Vinicius Wagner
 */
public abstract class Unidade {
    protected double xAtual;
    protected double yAtual;
    protected boolean selecionado;
    protected boolean cor;    //false para branco, true para preto
    protected final double movUnico =1;
    protected final int movNulo =0;
    protected String imagem;

    /**
     * Metodo abstrato movimento
     * movimentos são diferentes para cada peça que herda de Unidade
     * @param x coordenada X
     * @param y coordenada Y
     * @return true or false
     */
    public abstract boolean movimento(double x, double y);

    public double getxAtual() {
        return xAtual;
    }

    public double getyAtual() {
        return yAtual;
    }

    //as classes Rei, Rainha e bispo possuem o proprio metodo "desenhar" para centralizar melhor no tabuleiro, pois a figura tem tamanho diferente
    public void desenhar(Draw desenho){
        if (selecionado){
            Color cor = Color.RED;
            desenho.setPenColor(cor);
            desenho.square(xAtual + 0.5, yAtual + 0.5, .500);
        }
        desenho.picture(xAtual+0.5,yAtual+0.65,imagem);
    }

    public boolean isCor() {
        return cor;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void marcaDesmarca() {
        this.selecionado = ! this.selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public Unidade(double xOrigem, double yOrigem, boolean cor, String imagem) {
        this.xAtual = Math.floor(xOrigem);
        this.yAtual = Math.floor(yOrigem);
        this.cor = cor;
        this.imagem = imagem;
    }
}
