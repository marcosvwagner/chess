public class Rei extends Unidade{


    public Rei(double xOrigem, double yOrigem, boolean cor) {
        super(xOrigem, yOrigem, cor);
    }

    @Override
    public boolean movimento(double x, double y) {
        //verificando se é linear ou diagonal
        if((Math.abs(Math.floor(y) - this.yAtual)) == movUnico & Math.abs(this.xAtual - Math.floor(x)) == movUnico ||
        Math.abs(Math.floor(x) - this.xAtual) == movUnico && Math.floor(y) == this.yAtual || Math.abs(Math.floor(y) - this.yAtual) == movUnico && Math.floor(x) == this.xAtual){
            this.xAtual = Math.floor(x);
            this.yAtual = Math.floor(y);
            return true;
        }
        return false;
    }
}