import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Bispo extends Unidade{


    public Bispo(double xOrigem, double yOrigem, boolean cor, String imagem) {
        super(xOrigem, yOrigem, cor, imagem);
    }

    @Override
    public boolean movimento(double x, double y) {
        //conferindo se o numero absoluto das cordenadas é o mesmo
        if (Math.abs(Math.floor(x) - xAtual) == Math.abs(Math.floor(y) - yAtual)){
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
        desenho.picture(xAtual+0.5,yAtual+0.53,imagem);
    }
}
