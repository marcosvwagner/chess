import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Rainha extends Unidade{

    public Rainha(double xOrigem, double yOrigem, boolean cor, String imagem) {
        super(xOrigem, yOrigem, cor, imagem);
    }

    @Override
    public boolean movimento(double x, double y) {
        //verificando se é linear ou diagonal
        if (((Math.floor(x)-this.xAtual) == 0 & (Math.floor(y)-this.yAtual) != 0) || ((Math.floor(x)-this.xAtual) != 0 & (Math.floor(y)-this.yAtual) == 0) ||
        Math.abs(Math.floor(x) - xAtual) == Math.abs(Math.floor(y) - yAtual)){
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
