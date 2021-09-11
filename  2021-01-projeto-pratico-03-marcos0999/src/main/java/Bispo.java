public class Bispo extends Unidade{


    public Bispo(double xOrigem, double yOrigem, boolean cor) {
        super(xOrigem, yOrigem, cor);
    }

    @Override
    public boolean movimento(double x, double y) {
        //conferindo se o numero absoluto das cordenadas é o mesmo
        if (Math.abs(Math.floor(x) - xAtual) == Math.abs(Math.floor(y) - yAtual)){
            this.xAtual = Math.floor(x);
            this.yAtual = Math.floor(y);
            return true;
        }
        return false;
    }
}
