/**
 * Classe Cavalo
 * herda de Unidade
 */
public class Cavalo extends Unidade {

    public Cavalo(double xOrigem, double yOrigem, boolean cor, String imagem) {
        super(xOrigem, yOrigem, cor, imagem);
    }

    /**
     * movimento do Cavalo
     * em 'L'
     * @param x coodenada X
     * @param y coodenada Y
     * @return true or false
     */
    @Override
    public boolean movimento(double x, double y) {
        //verificando a movimentação em "L", vendo se uma cordenada varia 2 e outra 1
        if ((Math.abs(Math.floor(x) - this.xAtual) == 2 & Math.abs(Math.floor(y)- this.yAtual) == 1) || (Math.abs(Math.floor(x) - this.xAtual) == 1 & Math.abs(Math.floor(y)- this.yAtual) == 2)){
            this.xAtual = Math.floor(x);
            this.yAtual = Math.floor(y);
            return true;
        }
        return false;
    }
}
