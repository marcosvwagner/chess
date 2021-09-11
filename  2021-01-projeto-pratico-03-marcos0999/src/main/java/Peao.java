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
                if ((Math.floor(x) == this.xAtual) & (Math.floor(y) == this.yAtual+movUnico) || (Math.floor(x) == this.xAtual) & (Math.floor(y) == this.yAtual+2)){
                    this.yAtual =Math.floor(y);
                    usado = true;
                    return true;
                }
            }
            else {
                if (Math.floor(x) == this.xAtual & Math.floor(y) == this.yAtual-movUnico || Math.floor(x) == this.xAtual & Math.floor(y) == this.yAtual-2){
                    this.yAtual = Math.floor(y);
                    usado = true;
                    return true;
                }
            }
            return false;
        }
        else {
            if (!cor){
                if (Math.floor(x) == this.xAtual & Math.floor(y) == this.yAtual+movUnico){
                    this.yAtual =Math.floor(y);
                    return true;
                }
            }
            else {
                if (Math.floor(x) == this.xAtual & Math.floor(y) == this.yAtual-movUnico){
                    this.yAtual = Math.floor(y);
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * @param x coordenada x
     * @param y coordenada y
     * @return true or false
     */
    public boolean ataque(double x, double y) {
        if (!cor){
            if (Math.abs(Math.floor(x) - xAtual) == Math.abs(Math.floor(y) - yAtual)){
                if ((Math.floor(x) == xAtual + movUnico || Math.floor(x) == xAtual - movUnico) & (Math.floor(y) == yAtual + movUnico)){
                    this.xAtual = Math.floor(x);
                    this.yAtual = Math.floor(y);
                    if (!usado) usado = true;
                    return true;
                }
            }
        }else {
            if (Math.abs(Math.floor(x) - xAtual) == Math.abs(Math.floor(y) - yAtual)){
                if ((Math.floor(x) == xAtual + movUnico || Math.floor(x) == xAtual - movUnico) & (Math.floor(y) == yAtual - movUnico)) {
                    this.xAtual = Math.floor(x);
                    this.yAtual = Math.floor(y);
                    if (!usado) usado = true;
                    return true;
                }
            }
        }

        return false;
    }
}
