public class Rainha extends Unidade{

    public Rainha(int xOrigem, int yOrigem) {
        super(xOrigem, yOrigem);
    }

    @Override
    public boolean movimento(int x, int y) {
        return false;
    }

    @Override
    public boolean ataque(int x, int y) {
        return false;
    }
}
