/**
 * classe Torre
 * herda de Unidade
 */
public class Torre extends Unidade{


    public Torre(double xOrigem, double yOrigem, boolean cor, String imagem) {
        super(xOrigem, yOrigem, cor, imagem);
    }

    /**
     * Movimento da Torre
     * movimento linear sem limites
     * @param x coodenada X
     * @param y coodenada Y
     * @return true or false
     */
    @Override
    public boolean movimento(double x, double y) {
        //verificando se o movimento é linear
        if (((Math.floor(x)-this.xAtual) == movNulo & (Math.floor(y)-this.yAtual) != movNulo) || ((Math.floor(x)-this.xAtual) != movNulo & (Math.floor(y)-this.yAtual) == movNulo)){
            this.xAtual = Math.floor(x);
            this.yAtual = Math.floor(y);
            return true;
        }
        return false;
    }


}
