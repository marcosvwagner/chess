public class Cavalo extends Unidade {

    public Cavalo(int xOrigem, int yOrigem) {
        super(xOrigem, yOrigem);
    }

    @Override
    public boolean movimento(int x, int y) {
        //verificando a movimentação em "L", vendo se uma cordenada varia 2 e outra 1
        if ((Math.abs(x - this.xAtual) == 2 & Math.abs(y- this.yAtual) == 1) || (Math.abs(x - this.xAtual) == 1 & Math.abs(y- this.yAtual) == 2)){
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
