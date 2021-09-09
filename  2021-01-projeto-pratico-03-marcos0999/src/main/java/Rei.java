public class Rei extends Unidade{

    @Override
    public boolean movimento(int x, int y) {
        //verificando se o movimento é limitado a 1
        if (x == this.xAtual+1 || y == this.yAtual+1){
            //verificando se é linear ou diagonal
            if(((x-this.xAtual) == 0 & (y-this.yAtual) != 0) || ((x-this.xAtual) != 0 & (y-this.yAtual) == 0) ||
                    Math.abs(x - xAtual) == Math.abs(y - yAtual)){
                this.xAtual = x;
                this.yAtual = y;
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean ataque(int x, int y) {
        return false;
    }

    public Rei(int xOrigem, int yOrigem) {
        super(xOrigem, yOrigem);
    }

}