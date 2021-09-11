import edu.princeton.cs.algs4.Draw;

import java.awt.*;

/**
 * Classe que vai ser herdada por todas as peças de Xadrez
 */
public abstract class Unidade {
    protected double xAtual;
    protected final double xOrigem;
    protected double yAtual;
    protected final double yOrigem;
    protected boolean selecionado;
    //false para branco, true para preto
    protected boolean cor;
    protected final double movUnico =1;

    public abstract boolean movimento(double x, double y);


    public double getxAtual() {
        return xAtual;
    }

    public double getyAtual() {
        return yAtual;
    }

    public void desenhar(Draw desenho){
        Color cor = (selecionado) ? Color.RED : Color.BLUE;
        desenho.setPenColor(cor);
        desenho.filledCircle(xAtual + 0.5, yAtual + 0.5, .375);
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


    public Unidade(double xOrigem, double yOrigem, boolean cor) {
        this.xOrigem = Math.floor(xOrigem);
        this.yOrigem = Math.floor(yOrigem);
        this.xAtual = xOrigem;
        this.yAtual = yOrigem;
        this.cor = cor;
    }
}
