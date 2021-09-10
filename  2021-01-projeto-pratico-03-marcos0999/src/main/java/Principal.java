import edu.princeton.cs.algs4.Draw;
import edu.princeton.cs.algs4.DrawListener;

import java.awt.*;

/**
 * Pequeno exemplo para ilustrar a captura
 * de evento de clique do mouse
 */
public class Principal implements DrawListener {
    private final int dimensao;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Draw draw;

    public Principal(int dimensao) {
        // Objeto responsável por fazer a área de desenho (canvas)
        draw = new Draw();

        // Criando peças para o tabuleiro
        tabuleiro.novoJogo();

        // Adicionando objeto desta classe como o
        // objeto que ficará ouvindo por eventos do mouse ou teclado
        draw.addListener(this);

        // Indicando o número de casas da área de desenho
        this.dimensao = dimensao;
        draw.setXscale(0, dimensao);
        draw.setYscale(0, dimensao);
        draw.enableDoubleBuffering();

        // Desenhando os objetos na tela
        desenharTela();
    }

    /**
     * Desenha a grade do tabuleiro
     */
    public void desenharTabuleiro(){
        draw.setPenColor(Color.BLUE);
        for (int i = 0; i <= dimensao; i++) draw.line(i, 0, i, dimensao);
        for (int j = 0; j <= dimensao; j++) draw.line(0, j, dimensao, j);
    }

    /**
     * Faz o objeto círculo se desenhar na tela
     */
    public void desenharUnidades(){
        for (Unidade branc: tabuleiro.getBrancas()){
            branc.desenhar(draw);
        }
        for (Unidade pret: tabuleiro.getPretas()){
            pret.desenhar(draw);
        }
    }

    /**
     * Limpa a tela, desenha o tabuleiro e os círculos
     */
    public void desenharTela(){
        draw.clear(Color.LIGHT_GRAY);
        this.desenharTabuleiro();
        this.desenharUnidades();
        draw.show();
    }

    /**
     * Captura o evento de botão pressionado do mouse
     * @param x coordenada X do cursor do mouse quando o botão foi pressionado
     * @param y coordenada Y do cursor do mouse quando o botão foi pressionado
     */
    public void mousePressed(double x, double y) {
        // Se o usuário clicou dentro da casa do tabuleiro onde está a peça
        for (Unidade branca : tabuleiro.getBrancas()){
            if ((Math.floor(x) == branca.getxAtual()) && (Math.floor(y) == branca.getyAtual())){
                branca.marcaDesmarca();
                System.out.println(branca.xAtual + " " + branca.yAtual +" "+ branca.getClass().getSimpleName() + " " + branca.isCor());
            }else{
                if (branca.isSelecionado()){
                    tabuleiro.movimentar(branca, x, y);
                    branca.setSelecionado(false);
                }
            }
            // Limpa a tela e desenha tudo novamente (tabuleiro e peças)
            desenharTela();
        }


        // Limpa a tela e desenha tudo novamente (tabuleiro e peças)
        desenharTela();
        // Se o usuário clicou dentro da casa do tabuleiro onde está a peça
        for (Unidade preta : tabuleiro.getPretas()){
            if ((Math.floor(x) == preta.getxAtual()) && (Math.floor(y) == preta.getyAtual())){
                preta.marcaDesmarca();
                System.out.println(preta.xAtual + " " + preta.yAtual +" "+ preta.getClass().getSimpleName() + " " + preta.isCor());
            }else{
                if (preta.isSelecionado()){
                    tabuleiro.movimentar(preta, x, y);
                    preta.setSelecionado(false);
                }
            }
            // Limpa a tela e desenha tudo novamente (tabuleiro e peças)
            desenharTela();
        }
    }


    public static void main(String[] args) {
        Principal p = new Principal(8);
    }


    // Métodos da interface DrawListener que não serão usados neste exemplo
    @Override
    public void mouseDragged(double v, double v1) {}
    @Override
    public void mouseReleased(double v, double v1) {}
    @Override
    public void mouseClicked(double v, double v1) {}
    @Override
    public void keyTyped(char c) {}
    @Override
    public void keyPressed(int i) {}
    @Override
    public void keyReleased(int i) {}
}
