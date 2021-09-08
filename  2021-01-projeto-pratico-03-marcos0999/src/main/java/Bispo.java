public class Bispo extends Unidade{


    public Bispo(int xOrigem, int yOrigem) {
        super(xOrigem, yOrigem);
    }

    @Override
    public boolean movimento(int x, int y) {
        //conferindo se o numero absoluto das cordenadas é o mesmo
        if (Math.abs(x - xAtual) == Math.abs(y - yAtual)){
            this.xAtual = x;
            this.yAtual = y;
            return true;
        }
        return false;
    }

    @Override
    public boolean ataque(int x, int y) {
        return false;
    }
}
