public abstract class Unidade {
    protected int xAtual;
    protected final int xOrigem;
    protected int yAtual;
    protected final int yOrigem;
    protected boolean selecionado;

    public abstract boolean movimento(int x, int y);

    public abstract boolean ataque(int x, int y);

    public int getxAtual() {
        return xAtual;
    }

    public int getyAtual() {
        return yAtual;
    }

    public Unidade(int xOrigem, int yOrigem) {
        this.xOrigem = xOrigem;
        this.yOrigem = yOrigem;
        this.xAtual = xOrigem;
        this.yAtual = yOrigem;
    }
}
