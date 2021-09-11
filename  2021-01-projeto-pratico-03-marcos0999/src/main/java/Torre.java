public class Torre extends Unidade{


    public Torre(double xOrigem, double yOrigem, boolean cor, String imagem) {
        super(xOrigem, yOrigem, cor, imagem);
    }

    @Override
    public boolean movimento(double x, double y) {
        //verificando se o movimento é linear
        if (((Math.floor(x)-this.xAtual) == 0 & (Math.floor(y)-this.yAtual) != 0) || ((Math.floor(x)-this.xAtual) != 0 & (Math.floor(y)-this.yAtual) == 0)){
            this.xAtual = Math.floor(x);
            this.yAtual = Math.floor(y);
            return true;
        }
        return false;
    }


}
