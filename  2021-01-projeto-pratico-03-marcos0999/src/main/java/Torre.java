public class Torre extends Unidade{
    public Torre(int xOrigem, int yOrigem) {
        super(xOrigem, yOrigem);
    }

    @Override
    public boolean movimento(int x, int y) {
        //verificando se o movimento é linear
        if (((x-this.xAtual) == 0 & (y-this.yAtual) != 0) || ((x-this.xAtual) != 0 & (y-this.yAtual) == 0)){
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
