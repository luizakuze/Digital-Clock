/**
 * A classe Segmento representa um segmento de um display de sete segmentos, que pode estar ligado (aceso) ou desligado.
 * Cada segmento pode ser orientado na horizontal ou vertical.
 */
package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class Segmento {
    private boolean estado; // ligado (true) ou desligado (false)
    private boolean orientacao; // horizontal (true) ou vertical (false)

    /**
     * Construtor da classe Segmento que inicializa um segmento com a orientação
     * especificada.
     *
     * @param orientacao Define a orientação do segmento (true para horizontal,
     *                   false para vertical).
     */
    public Segmento(boolean orientacao) {
        this.orientacao = orientacao;
    }

    /**
     * Obtém o estado do segmento (ligado/desligado).
     *
     * @return true se o segmento estiver ligado, false se estiver desligado.
     */
    public boolean getEstado() {
        return estado;
    }

    /**
     * Inverte o estado do segmento (liga se estiver desligado, desliga se estiver
     * ligado).
     */
    public void trocaEstado() {
        this.estado = !this.estado;
    }

    /**
     * Desliga o segmento, definindo seu estado como desligado.
     */
    public void reset() {
        this.estado = false;
    }

    /**
     * Seleciona a cor do segmento com base em seu estado (ligado ou desligado) e
     * desenha o segmento na tela.
     *
     * @param desenho O objeto Draw usado para desenhar.
     * @param cor     A cor do segmento.
     */
    private void selecionaCorEstado(Draw desenho, Color cor) {
        double fatorCor = 0.2;
        if (this.estado) {
            desenho.setPenColor(cor); // segmento ligado
        } else {
            desenho.setPenColor(new Color((int) (cor.getRed() * fatorCor), (int) (cor.getGreen() * fatorCor),
                    (int) (cor.getBlue() * fatorCor))); // segmento desligado
        }
    }

    /**
     * Desenha o segmento na tela com base em sua orientação e cor.
     *
     * @param desenho  O objeto Draw usado para desenhar.
     * @param cor      A cor do segmento.
     * @param xInicial A coordenada X inicial do segmento.
     * @param yInicial A coordenada Y inicial do segmento.
     * @param fator    O fator de escala usado para determinar o tamanho do
     *                 segmento.
     */
    public void desenharSegmento(Draw desenho, Color cor, double xInicial, double yInicial, int fator) {
        // Seleciona cor do polígono dependendo do estado
        selecionaCorEstado(desenho, cor);

        // Se estiver na horizontal
        if (this.orientacao) {
            // Montando vetores X e Y para segmento horizontal
            double[] xHorizontal = { 0.1 * fator + xInicial, 0.2 * fator + xInicial,
                    1.0 * fator + xInicial, 1.1 * fator + xInicial,
                    1.0 * fator + xInicial, 0.2 * fator + xInicial };
            double[] yHorizontal = { 0.2 * fator + yInicial, 0.3 * fator + yInicial,
                    0.3 * fator + yInicial, 0.2 * fator + yInicial,
                    0.1 * fator + yInicial, 0.1 * fator + yInicial };

            desenho.filledPolygon(xHorizontal, yHorizontal);
        } else {
            // Montando vetores X e Y para segmento vertical
            double[] xVertical = { 0.1 * fator + xInicial, 0.2 * fator + xInicial,
                    0.2 * fator + xInicial, 0.1 * fator + xInicial,
                    0 * fator + xInicial, 0 * fator + xInicial };
            double[] yVertical = { 0.2 * fator + yInicial, 0.3 * fator + yInicial,
                    1.0 * fator + yInicial, 1.1 * fator + yInicial,
                    1.0 * fator + yInicial, 0.3 * fator + yInicial };

            desenho.filledPolygon(xVertical, yVertical);
        }
    }
}
