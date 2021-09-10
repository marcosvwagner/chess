public class Rei extends Unidade{


    public Rei(double xOrigem, double yOrigem, boolean cor) {
        super(xOrigem, yOrigem, cor);
    }

    @Override
    public boolean movimento(double x, double y) {
        //verificando se é linear ou diagonal
        if((Math.abs(Math.floor(y) - this.yAtual)) == 1 & Math.abs(this.xAtual - Math.floor(x)) == 1 ||
        Math.abs(Math.floor(x) - this.xAtual) == 1 && Math.floor(y) == this.yAtual || Math.abs(Math.floor(y) - this.yAtual) == 1 && Math.floor(x) == this.xAtual){
            this.xAtual = Math.floor(x);
            this.yAtual = Math.floor(y);
            return true;
        }
        return false;
    }

    @Override
    public boolean ataque(double x, double y) {
        return false;
    }



}