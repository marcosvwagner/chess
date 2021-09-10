public class Peao extends Unidade{

    //atributo para conferir se o peão ja foi usado no jogo, se não foi, ele pode movimentar 2 casas em seu primeiro movimento
    private boolean usado = false;

    public Peao(double xOrigem, double yOrigem, boolean cor) {
        super(xOrigem, yOrigem, cor);
    }


    @Override
    public boolean movimento(double x, double y) {
        if (!this.usado){
            if (!cor){
                if ((Math.floor(x) == this.xAtual) & (Math.floor(y) == this.yAtual+1) || (Math.floor(x) == this.xAtual) & (Math.floor(y) == this.yAtual+2)){
                    this.yAtual =Math.floor(y);
                    usado = true;
                    return true;
                }
            }
            else {
                if (Math.floor(x) == this.xAtual & Math.floor(y) == this.yAtual-1 || Math.floor(x) == this.xAtual & Math.floor(y) == this.yAtual-2){
                    this.yAtual = Math.floor(y);
                    usado = true;
                    return true;
                }
            }
            return false;
        }
        else {
            if (!cor){
                if (Math.floor(x) == this.xAtual & Math.floor(y) == this.yAtual+1){
                    this.yAtual =Math.floor(y);
                    return true;
                }
            }
            else {
                if (Math.floor(x) == this.xAtual & Math.floor(y) == this.yAtual-1){
                    this.yAtual = Math.floor(y);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public boolean ataque(double x, double y) {
        return false;
    }
}
