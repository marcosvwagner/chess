import java.util.ArrayList;

/**
 * Classe que controla as peças do jogo, cria peças do jogo e confere e legalidade dos movimentos
 */
public class Tabuleiro {
    private ArrayList<Unidade> pretas = new ArrayList<>();
    private ArrayList<Unidade> brancas = new ArrayList<>();


    public ArrayList<Unidade> getPretas() {
        return pretas;
    }

    public ArrayList<Unidade> getBrancas() {
        return brancas;
    }

    public Tabuleiro() {
        novoJogo();
    }

    /**
     * Metodo que limpa todas as peças atuais e cria novas peças
     */
    public void novoJogo(){
        //limpando caso haja peças no jogo
        pretas.clear();
        brancas.clear();

        //brancas
        //primeira linha
        brancas.add(new Torre(0,0,false));
        brancas.add(new Cavalo(1,0,false));
        brancas.add(new Bispo(2,0,false));
        brancas.add(new Rainha(3,0,false));
        brancas.add(new Rei(4,0,false));
        brancas.add(new Bispo(5,0,false));
        brancas.add(new Cavalo(6,0,false));
        brancas.add(new Torre(7,0,false));

        //peões
        brancas.add(new Peao(0,1,false));
        brancas.add(new Peao(1,1,false));
        brancas.add(new Peao(2,1,false));
        brancas.add(new Peao(3,1,false));
        brancas.add(new Peao(4,1,false));
        brancas.add(new Peao(5,1,false));
        brancas.add(new Peao(6,1,false));
        brancas.add(new Peao(7,1,false));

        //pretas
        //primeira linha
        pretas.add(new Torre(0,7,true));
        pretas.add(new Cavalo(1,7,true));
        pretas.add(new Bispo(2,7,true));
        pretas.add(new Rainha(3,7,true));
        pretas.add(new Rei(4,7,true));
        pretas.add(new Bispo(5,7,true));
        pretas.add(new Cavalo(6,7,true));
        pretas.add(new Torre(7,7,true));

        //peões
        pretas.add(new Peao(0,6,true));
        pretas.add(new Peao(1,6,true));
        pretas.add(new Peao(2,6,true));
        pretas.add(new Peao(3,6,true));
        pretas.add(new Peao(4,6,true));
        pretas.add(new Peao(5,6,true));
        pretas.add(new Peao(6,6,true));
        pretas.add(new Peao(7,6,true));
    }

    /**
     * Metodo chamado para movimentar uma peça
     * verifica se o movimento é legal e usa a movimentação da peça
     * @param p peça a ser movimentada
     * @param x posição destino em X
     * @param y posição destino em Y
     */
    public void movimentar(Unidade p, double x, double y){

        if (p instanceof Cavalo){
            if (movimentoValido(x, y)) p.movimento(x, y);
        }
        //chama o metodo para verificar a movimentação
        if (verificaMov(p.getxAtual(), x, p.getyAtual(), y)) {
            //chama o metodo da classe da peça para sua movimentação
            p.movimento(x,y);
        }
    }

    /**
     * Metodo que confere se há alguma unidade na posição que foi passada
     * @param x coordenada X
     * @param y coordenada Y
     * @return true or false
     */
    public boolean movimentoValido (double x, double y){
        //TODO diferenciar peças aliadas e adversarias
        for (Unidade it: brancas) {
            if (x== it.xAtual & y== it.yAtual)return false;
        }
        for (Unidade it: pretas) {
            if (x== it.xAtual & y== it.yAtual)return false;
        }
        return true;
    }

    /**
     * Metodo para verificar a validade do movimento passado
     * @param xOrig posição original em X
     * @param xDes posição de destino em X
     * @param yOrig posição original em Y
     * @param yDes posição de destino em Y
     * @return false or true
     */
    public boolean verificaMov(double xOrig, double xDes, double yOrig, double yDes){
        double difX = (Math.floor(xDes)-xOrig);
        double difY = (Math.floor(yDes)-yOrig);

        //verificando se há movimento
        if (difX ==0 & difY ==0) return false;

        //se o movimento for diagonal
        if (Math.abs(Math.floor(xDes) - xOrig) == Math.abs(Math.floor(yDes) - yOrig)){
            return movdiagonal(xOrig, difX, yOrig, difY);
        }

        //se o movimento for linear
        else {
            //se for movimento em x
            if (difX != 0){
                return movX(xOrig, difX, yOrig);
            }

            //se for movimento em y
            return movY(yOrig, difY, xOrig);

        }
    }


    /**
     * Metodo para movimentação de uma peça em direção X
     * @param xOrig posição original em X
     * @param difX diferença entre a nova posição e a posição original em X
     * @param yOrig posioção original em Y
     * @return false or true
     */
    private boolean movX(double xOrig, double difX, double yOrig) {
        //variavel para saber a quantidade de movimentos da peça
        double quantMovX = Math.abs(difX);
        //variavel que vê a direção do movimento
        double dirX = difX/quantMovX;
        //laço para conmandar cada casa de movimentação para o metodo movimentoValido
        for (int i = 0; i < quantMovX; i++) {
            if (!movimentoValido(xOrig + dirX, yOrig)) return false;
            xOrig += dirX;
        }
        return true;
    }

    /**
     * Metodo para movimentação de uma peça em direção Y
     * @param yOrig posição original em Y
     * @param difY dposição original em Y
     * @param xOrig posioção original em X
     * @return false or true
     */
    private boolean movY(double yOrig, double difY, double xOrig) {
        //variavel para saber a quantidade de movimentos da peça
        double quantMovY = Math.abs(difY);
        //variavel que vê a direção do movimento
        double dirY = difY/quantMovY;
        //laço para conmandar cada casa de movimentação para o metodo movimentoValido
        for (int i = 0; i < quantMovY; i++) {
            if (!movimentoValido(xOrig,yOrig + dirY)) return false;
            yOrig += dirY;
        }
        return true;
    }

    /**
     * Metodo para movimentação de uma peça em diagonal
     * @param xOrig posição original em Y
     * @param difX posição original em X
     * @param yOrig posioção original em X
     * @param difY posição original em Y
     * @return false or true
     */
    public boolean movdiagonal(double xOrig, double difX, double yOrig, double difY ) {

        //variavel para saber a quantidade de movimentos da peça
        double quantMov = Math.abs(difX);

        //variavel que vê a direção dos movimentos em X e Y
        double dirX = difX / quantMov;
        double dirY = difY / quantMov;

        //laço para conmandar cada casa de movimentação para o metodo movimentoValido
        for (int i = 0; i < quantMov; i++) {
            if (!movimentoValido(xOrig + dirX, yOrig + dirY)) return false;
            xOrig = xOrig + dirX;
            yOrig = yOrig + dirY;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tabuleiro{\n" +
                "pretas=" + pretas +
                "\nbrancas=" + brancas +
                "\n}";
    }
}
