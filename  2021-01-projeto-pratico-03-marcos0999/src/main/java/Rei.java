import edu.princeton.cs.algs4.Draw;

import java.awt.*;

/**
 * Classe Rei
 * herda de Unidade
 */
public class Rei extends Unidade{


    public Rei(double xOrigem, double yOrigem, boolean cor, String imagem) {
        super(xOrigem, yOrigem, cor, imagem);
    }

    /**
     * movimento do Rei
     * qualquer direção, mas limitado a 1
     * @param x coodenada X
     * @param y coodenada Y
     * @return true or false
     */
    @Override
    public boolean movimento(double x, double y) {
        //verificando se é linear ou diagonal
        if((Math.abs(Math.floor(y) - this.yAtual)) == movUnico & Math.abs(this.xAtual - Math.floor(x)) == movUnico ||
        Math.abs(Math.floor(x) - this.xAtual) == movUnico && Math.floor(y) == this.yAtual || Math.abs(Math.floor(y) - this.yAtual) == movUnico && Math.floor(x) == this.xAtual){
            this.xAtual = Math.floor(x);
            this.yAtual = Math.floor(y);
            return true;
        }
        return false;
    }

    @Override
    public void desenhar(Draw desenho){
        if (selecionado){
            Color cor = Color.RED;
            desenho.setPenColor(cor);
            desenho.square(xAtual + 0.5, yAtual + 0.5, .500);
        }
        desenho.picture(xAtual+0.5,yAtual+0.5,imagem);
    }
}