import java.util.ArrayList;

public class Tabuleiro {
    ArrayList<Unidade> pretas = new ArrayList<>();
    ArrayList<Unidade> brancas = new ArrayList<>();


    public void novoJogo(){
        //limpando caso haja peças no jogo
        pretas.clear();
        brancas.clear();

        //brancas
        //primeira linha
        brancas.add(new Torre(0,0));
        brancas.add(new Cavalo(1,0));
        brancas.add(new Bispo(2,0));
        brancas.add(new Rainha(3,0));
        brancas.add(new Rei(4,0));
        brancas.add(new Bispo(5,0));
        brancas.add(new Cavalo(6,0));
        brancas.add(new Torre(7,0));

        //peões
        brancas.add(new Peao(0,1,false));
        brancas.add(new Peao(1,1,false));
        brancas.add(new Peao(2,1,false));
        brancas.add(new Peao(3,1,false));
        brancas.add(new Peao(4,1,false));
        brancas.add(new Peao(5,1,false));
        brancas.add(new Peao(6,1,false));
        brancas.add(new Peao(7,1,false));

        //pretas
        //primeira linha
        pretas.add(new Torre(0,7));
        pretas.add(new Cavalo(1,7));
        pretas.add(new Bispo(2,7));
        pretas.add(new Rainha(3,7));
        pretas.add(new Rei(4,7));
        pretas.add(new Bispo(5,7));
        pretas.add(new Cavalo(6,7));
        pretas.add(new Torre(7,7));

        //peões
        pretas.add(new Peao(0,6,true));
        pretas.add(new Peao(1,6,true));
        pretas.add(new Peao(2,6,true));
        pretas.add(new Peao(3,6,true));
        pretas.add(new Peao(4,6,true));
        pretas.add(new Peao(5,6,true));
        pretas.add(new Peao(6,6,true));
        pretas.add(new Peao(7,6,true));

    }

    public void movimentar(Unidade p, int x, int y){
        if (verificaMov(p.getxAtual(), x, p.getyAtual(), y)) p.movimento(x,y);
    }

    public boolean movimentoValido (int x, int y){
        //TODO diferenciar peças aliadas e adversarias
        for (Unidade it: brancas) {
            if (x== it.xAtual & y== it.yAtual)return false;
        }
        for (Unidade it: pretas) {
            if (x== it.xAtual & y== it.yAtual)return false;
        }
        return true;
    }

    public boolean verificaMov(int xOrig,int xDes,int yOrig,int yDes){
        int difX = (xDes-xOrig);
        int difY = (yDes-yOrig);

        //verificando se há movimento
        if (difX ==0 & difY ==0) return false;

        //se o movimento for diagonal
        if (Math.abs(xDes - xOrig) == Math.abs(yDes - yOrig)) movdiagonal(xOrig, difX, yOrig, difY);

        //se o movimento for linear
        else {
            //se for movimento em x
            if (difX != 0) movX(xOrig, difX, yOrig);
            //se for movimento em y
            if (difY != 0) movY(yOrig, difY, xOrig);
        }
        return true;
    }



    private boolean movX(int xOrig, int difX, int yOrig) {
        int quantMovX = Math.abs(difX);
        int dirX = difX/quantMovX;
        for (int i = 0; i < quantMovX; i++) {
            if (movimentoValido(xOrig + dirX, yOrig)) return false;
            xOrig += dirX;
        }
        return true;
    }

    private boolean movY(int yOrig, int difY, int xOrig) {
        int quantMovY = Math.abs(difY);
        int dirY = difY/quantMovY;
        for (int i = 0; i < quantMovY; i++) {
            if (movimentoValido(yOrig + dirY, xOrig)) return false;
            yOrig += dirY;
        }
        return true;
    }

    public boolean movdiagonal(int xOrig, int difX, int yOrig, int difY ) {

        //verificando se há movimento
        if (difX == 0 & difY == 0) return false;


        int quantMov = Math.abs(difX);

        int dirX = difX / quantMov;
        int dirY = difY / quantMov;

        for (int i = 0; i < quantMov; i++) {
            if (movimentoValido(xOrig + dirX, yOrig + dirY)) return false;
            xOrig = xOrig + dirX;
            yOrig = yOrig + dirY;
        }
        return true;
    }
}
