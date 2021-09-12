import java.util.ArrayList;

/**
 * Classe que controla as peças do jogo, cria peças do jogo e confere e legalidade dos movimentos
 * @author Marcos Vinicius Wagner
 */
public class Tabuleiro {
    private final int movNulo = 0;
    private final ArrayList<Unidade> pretas = new ArrayList<>();
    private final ArrayList<Unidade> brancas = new ArrayList<>();
    // verificar vez de cada jogador
    private boolean vez= false;

    public boolean isVez() {
        return vez;
    }

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
     * cada peça é criada em seu devido lugar e cor de acordo com as regras do Xadrez
     */
    public void novoJogo(){
        //limpando caso haja peças no jogo
        pretas.clear();
        brancas.clear();

        //brancas
        //primeira linha
        brancas.add(new Torre(0,0,false,"torreBranca.png"));
        brancas.add(new Cavalo(1,0,false,"cavaloBranco.png"));
        brancas.add(new Bispo(2,0,false,"bispoBranco.png"));
        brancas.add(new Rainha(3,0,false,"rainhaBranca.png"));
        brancas.add(new Rei(4,0,false,"reiBranco.png"));
        brancas.add(new Bispo(5,0,false,"bispoBranco.png"));
        brancas.add(new Cavalo(6,0,false,"cavaloBranco.png"));
        brancas.add(new Torre(7,0,false,"torreBranca.png"));

        //peões
        brancas.add(new Peao(0,1,false,"peaoBranco.png"));
        brancas.add(new Peao(1,1,false,"peaoBranco.png"));
        brancas.add(new Peao(2,1,false,"peaoBranco.png"));
        brancas.add(new Peao(3,1,false,"peaoBranco.png"));
        brancas.add(new Peao(4,1,false,"peaoBranco.png"));
        brancas.add(new Peao(5,1,false,"peaoBranco.png"));
        brancas.add(new Peao(6,1,false,"peaoBranco.png"));
        brancas.add(new Peao(7,1,false,"peaoBranco.png"));

        //pretas
        //primeira linha
        pretas.add(new Torre(0,7,true,"torrePreta.png"));
        pretas.add(new Cavalo(1,7,true,"cavaloPreto.png"));
        pretas.add(new Bispo(2,7,true,"bispoPreto.png"));
        pretas.add(new Rainha(3,7,true,"rainhapreta.png"));
        pretas.add(new Rei(4,7,true,"reiPreto.png"));
        pretas.add(new Bispo(5,7,true,"bispoPreto.png"));
        pretas.add(new Cavalo(6,7,true,"cavaloPreto.png"));
        pretas.add(new Torre(7,7,true,"torrePreta.png"));

        //peões
        pretas.add(new Peao(0,6,true,"peaoPreto.png"));
        pretas.add(new Peao(1,6,true,"peaoPreto.png"));
        pretas.add(new Peao(2,6,true,"peaoPreto.png"));
        pretas.add(new Peao(3,6,true,"peaoPreto.png"));
        pretas.add(new Peao(4,6,true,"peaoPreto.png"));
        pretas.add(new Peao(5,6,true,"peaoPreto.png"));
        pretas.add(new Peao(6,6,true,"peaoPreto.png"));
        pretas.add(new Peao(7,6,true,"peaoPreto.png"));
    }

    /**
     * Metodo chamado para movimentar uma peça
     * verifica se o movimento é legal e usa a movimentação da peça
     * @param p peça a ser movimentada
     * @param x posição destino em X
     * @param y posição destino em Y
     */
    public void movimentar(Unidade p, double x, double y){

        //ordenando a vez de cada jogador
        if ((!vez & !p.isCor()) || (vez & p.isCor())){
            //Verificando se o movimento é do cavalo
            if (p instanceof Cavalo){
                if (movimentoDest(p, Math.floor(x), Math.floor(y))){
                    //chama o metodo da classe Cavalo para sua movimentação e se movimentou, passa a vez para o outro jogador
                    if (p.movimento(x, y)) vez = !vez;

                }
            }
            //chama o metodo para verificar a movimentação
            if (verificaMov(p ,p.getxAtual(), x, p.getyAtual(), y)) {
                //chama o metodo da classe da peça para sua movimentação e se movimentou, passa a vez para o outro jogador
                if (p.movimento(x,y)) vez = !vez;

            }
        }
    }

    /**
     * Metodo que confere se há alguma unidade na posição que foi passada
     * @param x coordenada X
     * @param y coordenada Y
     * @return true or false
     */
    public boolean movimentoValido (double x, double y){
        for (Unidade it: brancas) {
            if (x== it.xAtual & y== it.yAtual) return false;
        }
        for (Unidade it: pretas) {
            if (x== it.xAtual & y== it.yAtual) return false;
        }
        promoverPeao();
        return true;
    }

    /**
     * Metodo para verificar a ultima casa de um movimento
     * possibilitando a eliminação de peças adversarias
     * @param p unidade se movimentando
     * @param x coordenada X
     * @param y coordenada Y
     * @return true or false
     */
    private boolean movimentoDest(Unidade p ,double x, double y) {
        //se for peça branca
        if (!p.isCor()){
            for (Unidade it: brancas) {
                if (x== it.xAtual & y== it.yAtual)return false;
            }
            for (Unidade it: pretas) {
                //confere se há peça preta no destino
                if (x== it.xAtual & y== it.yAtual) {
                    //se it for peão, confere se ele pode usar seu ataque
                    if (p instanceof Peao){
                        if (((Peao) p).ataque(x,y)){
                            pretas.remove(it);
                            vez = !vez;
                            promoverPeao();
                            return true;
                        }else return false;
                    }
                    //se sim, remove a peça preta de jogo
                    if (p.movimento(x, y)){
                        pretas.remove(it);
                        promoverPeao();
                        return true;
                    }

                }
            }
        }

        if (p.isCor()){
            for (Unidade it: pretas) {
                if (x== it.xAtual & y== it.yAtual)return false;
            }
            for (Unidade it: brancas) {
                //confere se há peça branca no destino
                if (x== it.xAtual & y== it.yAtual) {
                    //se it for peão, confere se ele pode usar seu ataque
                    if (p instanceof Peao){
                        if (((Peao) p).ataque(x,y)){
                            brancas.remove(it);
                            vez = !vez;
                            promoverPeao();
                            return true;
                        }else return false;
                    }
                    //se sim, remove a peça branca de jogo
                    if (p.movimento(x, y)){
                        brancas.remove(it);
                        promoverPeao();
                        return true;
                    }
                }
            }
        }
        promoverPeao();
        return true;
    }

    /**
     * Metodo para pormover peão
     * se o peão esta em sua ultima casa possivel, se transoforma em uma Rainha
     * Metodo é chamada ao fim de toda movimentacao
     */
    private void promoverPeao() {
        //laço que verifica se há algum peão em sua ultima casa
        for (Unidade it: brancas){
            if (it instanceof Peao){
                if (it.getyAtual()== 7){
                    //se sim, remove o peão e adiciona uma Rainha, no mesmo lugar e cor do Peão
                    brancas.remove(it);
                    brancas.add(new Rainha(it.getxAtual(),it.getyAtual(),false,"rainhaBranca.png"));
                }
            }
        }
        for (Unidade it: pretas){
            if (it instanceof Peao){
                if (it.getyAtual()==0){
                    pretas.remove(it);
                    brancas.add(new Rainha(it.getxAtual(), it.getyAtual(), true,"rainhapreta.png"));
                }
            }
        }

    }

    /**
     * Metodo para verificar a validade do movimento passado
     * @param p unidade se movimentando
     * @param xOrig posição original em X
     * @param xDes posição de destino em X
     * @param yOrig posição original em Y
     * @param yDes posição de destino em Y
     * @return false or true
     */
    public boolean verificaMov(Unidade p,double xOrig, double xDes, double yOrig, double yDes){
        double difX = (Math.floor(xDes)-xOrig);
        double difY = (Math.floor(yDes)-yOrig);

        //verificando se há movimento
        if (difX ==movNulo & difY ==movNulo) return false;

        //se o movimento for diagonal
        if (Math.abs(Math.floor(xDes) - xOrig) == Math.abs(Math.floor(yDes) - yOrig)){
            return movDiagonal(p ,xOrig, difX, yOrig, difY);
        }

        //se o movimento for linear
        else {
            //se for movimento em x
            if (difX != movNulo){
                return movX(p, xOrig, difX, yOrig);
            }

            //se for movimento em y
            return movY(p ,yOrig, difY, xOrig);
        }
    }


    /**
     * Metodo para movimentação de uma peça em direção X
     * @param p unidade se movimentando
     * @param xOrig posição original em X
     * @param difX diferença entre a nova posição e a posição original em X
     * @param yOrig posioção original em Y
     * @return false or true
     */
    private boolean movX(Unidade p, double xOrig, double difX, double yOrig) {
        //variavel para saber a quantidade de movimentos da peça
        double quantMovX = Math.abs(difX);
        //variavel que vê a direção do movimento
        double dirX = difX/quantMovX;
        //laço para mandar cada casa de movimentação para o metodo movimentoValido
        for (int i = 0; i < quantMovX; i++) {
            if (i == quantMovX-1){
                if (!movimentoDest(p, xOrig +dirX, yOrig)) return false;
            }
            else {
                if (!movimentoValido(xOrig + dirX, yOrig)) return false;
                xOrig += dirX;
            }
        }
        return true;
    }

    /**
     * Metodo para movimentação de uma peça em direção Y
     * @param p unidade se movimentando
     * @param yOrig posição original em Y
     * @param difY dposição original em Y
     * @param xOrig posioção original em X
     * @return false or true
     */
    private boolean movY(Unidade p ,double yOrig, double difY, double xOrig) {
        //variavel para saber a quantidade de movimentos da peça
        double quantMovY = Math.abs(difY);
        //variavel que vê a direção do movimento
        double dirY = difY/quantMovY;
        //laço para mandar cada casa de movimentação para o metodo movimentoValido
        for (int i = 0; i < quantMovY; i++) {
            if (i == quantMovY-1){
                if (!movimentoDest(p, xOrig, yOrig + dirY)) return false;
            }
            else {
                if (!movimentoValido(xOrig, yOrig + dirY)) return false;
                //se a casa for permitida, incrementa para testar a proxima
                yOrig += dirY;
            }
        }
        return true;
    }

    /**
     * Metodo para movimentação de uma peça em diagonal
     * @param p unidade se movimentando
     * @param xOrig posição original em Y
     * @param difX posição original em X
     * @param yOrig posioção original em X
     * @param difY posição original em Y
     * @return false or true
     */
    public boolean movDiagonal(Unidade p, double xOrig, double difX, double yOrig, double difY ) {

        //variavel para saber a quantidade de movimentos da peça
        double quantMov = Math.abs(difX);

        //variavel que vê a direção dos movimentos em X e Y
        double dirX = difX / quantMov;
        double dirY = difY / quantMov;

        //laço para mandar cada casa de movimentação para o metodo movimentoValido
        for (int i = 0; i < quantMov; i++) {
            if (i == quantMov-1){
                if (!movimentoDest(p, xOrig +dirX, yOrig + dirY)) return false;

            }
            else {
                if (!movimentoValido(xOrig + dirX, yOrig + dirY)) return false;
                xOrig = xOrig + dirX;
                yOrig = yOrig + dirY;
            }
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
