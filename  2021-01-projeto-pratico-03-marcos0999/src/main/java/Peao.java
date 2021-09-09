public class Peao extends Unidade{

    //atributo para conferir se o peão ja foi usado no jogo, se não foi, ele pode movimentar 2 casas em seu primeiro movimento
    private boolean usado = false;
    //false para branco, true para preto
    private boolean cor;

    public Peao(int xOrigem, int yOrigem, boolean cor) {
        super(xOrigem, yOrigem);
        this.cor = cor;

    }

    @Override
    public boolean movimento(int x, int y) {
        if (!this.usado){
            if (!cor){
                if (x == this.xAtual & y == this.yAtual+1 || x == this.xAtual & y == this.yAtual+2){
                    this.yAtual =y;
                    usado = true;
                    return true;
                }
            }
            else {
                if (x == this.xAtual & y == this.yAtual-1 || x == this.xAtual & y == this.yAtual-2){
                    this.yAtual = y;
                    usado = true;
                    return true;
                }
            }
            return false;
        }
        else {
            if (!cor){
                if (x == this.xAtual & y == this.yAtual+1){
                    this.yAtual =y;
                    return true;
                }
            }
            else {
                if (x == this.xAtual & y == this.yAtual-1){
                    this.yAtual = y;
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean ataque(int x, int y) {
        return false;
    }
}
