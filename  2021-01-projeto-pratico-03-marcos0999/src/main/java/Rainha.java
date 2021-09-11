public class Rainha extends Unidade{


    public Rainha(double xOrigem, double yOrigem, boolean cor) {
        super(xOrigem, yOrigem, cor);
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
}
