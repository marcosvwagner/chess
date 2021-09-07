public class Rei extends Unidade{

    @Override
    public boolean movimento(int x, int y) {
        return false;
    }

    @Override
    public boolean ataque() {
        return false;
    }

    public Rei(int xOrigem, int yOrigem) {
        super(xOrigem, yOrigem);
    }

}