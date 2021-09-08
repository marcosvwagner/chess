public abstract class Unidade {
    private int xAtual;
    private int xOrigem;
    private int yAtual;
    private int yOrigem;

    public abstract boolean movimento(int x, int y);

    public abstract boolean ataque(int x, int y);

    public Unidade(int xOrigem, int yOrigem) {
        this.xOrigem = xOrigem;
        this.yOrigem = yOrigem;
    }
}
