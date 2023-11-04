/**
 * A classe Display representa um display de sete segmentos que pode exibir números de 0 a 9.
 * Cada dígito é representado pelos segmentos A, B, C, D, E, F e G.
 */
package engtelecom.poo;

import java.util.ArrayList;

import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class Display {
    private ArrayList<Segmento> segmentos; // segmentos A, B, C, D, E, F e G
    private int numero; // número que está aparecendo

    public Display(int numero) {
        this.numero = numero;

        segmentos = new ArrayList<>();
        orientaDisplay();
        atualizaDisplay();
    }

    /**
     * Inicializa os segmentos A, B, C, D, E, F e G no display.
     */
    private void orientaDisplay() {
        segmentos.add(new Segmento(true)); // Segmento A - 0
        segmentos.add(new Segmento(false)); // Segmento B - 1
        segmentos.add(new Segmento(false)); // Segmento C - 2
        segmentos.add(new Segmento(true)); // Segmento D - 3
        segmentos.add(new Segmento(false)); // Segmento E - 4
        segmentos.add(new Segmento(false)); // Segmento F - 5
        segmentos.add(new Segmento(true)); // Segmento G - 6
    }

    /**
     * Atualiza o estado dos segmentos de acordo com o número exibido no display.
     */
    private void atualizaDisplay() {
        for (Segmento segmento : segmentos) {
            segmento.reset(); // Zera todos os segmentos
        }

        switch (numero) {
            case 0:
                segmentos.get(0).trocaEstado(); // Segmento A
                segmentos.get(1).trocaEstado(); // Segmento B
                segmentos.get(2).trocaEstado(); // Segmento C
                segmentos.get(3).trocaEstado(); // Segmento D
                segmentos.get(4).trocaEstado(); // Segmento E
                segmentos.get(5).trocaEstado(); // Segmento F
                break;
            case 1:
                segmentos.get(1).trocaEstado(); // Segmento B
                segmentos.get(2).trocaEstado(); // Segmento C
                break;
            case 2:
                segmentos.get(0).trocaEstado(); // Segmento A
                segmentos.get(1).trocaEstado(); // Segmento B
                segmentos.get(3).trocaEstado(); // Segmento D
                segmentos.get(4).trocaEstado(); // Segmento E
                segmentos.get(6).trocaEstado(); // Segmento G
                break;
            case 3:
                segmentos.get(0).trocaEstado(); // Segmento A
                segmentos.get(1).trocaEstado(); // Segmento B
                segmentos.get(2).trocaEstado(); // Segmento C
                segmentos.get(3).trocaEstado(); // Segmento D
                segmentos.get(6).trocaEstado(); // Segmento G
                break;
            case 4:
                segmentos.get(1).trocaEstado(); // Segmento B
                segmentos.get(2).trocaEstado(); // Segmento C
                segmentos.get(5).trocaEstado(); // Segmento F
                segmentos.get(6).trocaEstado(); // Segmento G
                break;
            case 5:
                segmentos.get(0).trocaEstado(); // Segmento A
                segmentos.get(2).trocaEstado(); // Segmento C
                segmentos.get(3).trocaEstado(); // Segmento D
                segmentos.get(5).trocaEstado(); // Segmento F
                segmentos.get(6).trocaEstado(); // Segmento G
                break;
            case 6:
                segmentos.get(0).trocaEstado(); // Segmento A
                segmentos.get(2).trocaEstado(); // Segmento C
                segmentos.get(3).trocaEstado(); // Segmento D
                segmentos.get(4).trocaEstado(); // Segmento E
                segmentos.get(5).trocaEstado(); // Segmento F
                segmentos.get(6).trocaEstado(); // Segmento G
                break;
            case 7:
                segmentos.get(0).trocaEstado(); // Segmento A
                segmentos.get(1).trocaEstado(); // Segmento B
                segmentos.get(2).trocaEstado(); // Segmento C
                break;
            case 8:
                for (Segmento segmento : segmentos) { // Segmentos A, B, C, D, E, F, e G
                    segmento.trocaEstado();
                }
                break;
            case 9:
                segmentos.get(0).trocaEstado(); // Segmento A
                segmentos.get(1).trocaEstado(); // Segmento B
                segmentos.get(2).trocaEstado(); // Segmento C
                segmentos.get(5).trocaEstado(); // Segmento F
                segmentos.get(6).trocaEstado(); // Segmento G
        }
    }

    /**
     * Desenha o display de sete segmentos na área de desenho especificada.
     *
     * @param desenho  A instância da classe Draw onde o display será desenhado.
     * @param xInicial A coordenada x inicial para o desenho do display.
     * @param yInicial A coordenada y inicial para o desenho do display.
     * @param cor      A cor do display.
     * @param tamanho  O tamanho do display.
     * @param fator    O fator de escala do display.
     */
    public void desenharDisplay(Draw desenho, double xInicial, double yInicial, Color cor, int tamanho, int fator) {
        // Segmento D
        double xD = xInicial;
        double yD = yInicial;
        segmentos.get(3).desenharSegmento(desenho, cor, xD, yD, fator);

        // Segmento E
        double xE = xInicial;
        double yE = yInicial;
        segmentos.get(4).desenharSegmento(desenho, cor, xE, yE, fator);

        // Segmento G
        double xG = xInicial;
        double yG = yD + fator;
        segmentos.get(6).desenharSegmento(desenho, cor, xG, yG, fator);
        // segmento F
        double xF = xInicial;
        double yF = yG;
        segmentos.get(5).desenharSegmento(desenho, cor, xF, yF, fator);

        // segmento A
        double xA = xInicial;
        double yA = yG + fator;
        segmentos.get(0).desenharSegmento(desenho, cor, xA, yA, fator);

        // segmento C
        double xC = xInicial + fator;
        double yC = yInicial;
        segmentos.get(2).desenharSegmento(desenho, cor, xC, yC, fator);

        // segmento B
        double xB = xC;
        double yB = yInicial + fator;
        segmentos.get(1).desenharSegmento(desenho, cor, xB, yB, fator);
    }

}