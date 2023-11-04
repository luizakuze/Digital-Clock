/**
 * A classe RelogioDigital representa um relógio digital que exibe a hora atual em displays de sete segmentos.
 */
package engtelecom.poo;

import java.util.ArrayList;
import edu.princeton.cs.algs4.Draw;
import java.awt.Color;

public class RelogioDigital {
    private Horario horario;
    private double coordenadaX;
    private double coordenadaY;
    private Color cor;
    private int tamanho; // 1, 2 e 3
    private ArrayList<Display> displays; // conjunto de 6 displays

    public static final int MIN_TAM = 1;
    public static final int MAX_TAM = 3;
    public static final double MAX_COORD = 900;
    public static final double MIN_COORD = 0;

    public RelogioDigital(double coordenadaX, double coordenadaY, int horas, int minutos, int segundos, String cor,
            int tamanho) {
        this.horario = new Horario(horas, minutos, segundos);

        if (setCoordenadas(coordenadaX, coordenadaY)) {
            this.coordenadaX = coordenadaX;
            this.coordenadaY = coordenadaY;
        }

        if (setTamanho(tamanho)) {
            this.tamanho = tamanho;
        }

        selecionaCor(cor);
        atualizaDisplays();
    }

    private boolean setCoordenadas(double coordenadaX, double coordenadaY) {
        if (coordenadaX >= MIN_COORD && coordenadaX <= MAX_COORD && coordenadaY >= MIN_COORD
                && coordenadaY <= MAX_COORD) {
            return true;
        }
        return false;
    }

    private boolean setTamanho(int tamanho) {
        if (!(tamanho >= MIN_TAM) && !(tamanho <= MAX_TAM)) {
            this.tamanho = 2;
            return false;
        }
        return true;
    }

    /**
     * Seleciona a cor do relógio com base em uma string de cor fornecida.
     *
     * @param cor A cor do relógio (pode ser "rosa", "azul", "verde" ou qualquer
     *            outra cor).
     */
    private void selecionaCor(String cor) {
        // Considera a escrita maiúscula correta
        cor = cor.toLowerCase();

        // Verifica se foi informada uma cor válida
        if (cor.equals("rosa")) {
            this.cor = Color.PINK;
        } else if (cor.equals("azul")) {
            this.cor = Color.BLUE;
        } else if (cor.equals("verde")) {
            this.cor = Color.GREEN;
        } else {
            // Qualquer outra cor é considerada "inválida" e seleciona branco
            this.cor = Color.WHITE;
        }
    }

    /**
     * Atualiza cada dígito do horário atual em diferentes displays.
     */
    private void atualizaDisplays() {
        displays = new ArrayList<Display>();

        // Converte horário em dígitos separados
        int horasDezena = horario.getHoras() / 10;
        int horasUnidade = horario.getHoras() % 10;
        int minutosDezena = horario.getMinutos() / 10;
        int minutosUnidade = horario.getMinutos() % 10;
        int segundosDezena = horario.getSegundos() / 10;
        int segundosUnidade = horario.getSegundos() % 10;

        // Adiciona a cada display o dígito atual de exibição
        displays.add(new Display(horasDezena));
        displays.add(new Display(horasUnidade));
        displays.add(new Display(minutosDezena));
        displays.add(new Display(minutosUnidade));
        displays.add(new Display(segundosDezena));
        displays.add(new Display(segundosUnidade));
    }

    /**
     * Atualiza em um segundo o horário do relógio.
     */
    public void incrementaSegundo() {
        this.horario.atualizaUmSegundo();
        atualizaDisplays();
    }

    /**
     * Calcula o fator de escala com base no tamanho do relógio para desenho
     */
    private int calculaFator() {
        if (this.tamanho == 1) {
            return 25;
        } else if (this.tamanho == 2) {
            return 45;
        } else {
            return 75;
        }
    }

    /**
     * Desenha os 6 displays do relógio na tela.
     *
     * @param desenho O objeto Draw usado para desenhar o relógio.
     */
    public void desenhaRelogio(Draw desenho) {
        double coordenadaInicialX = this.coordenadaX;

        // Fator que auxilia na escala do desenho
        int fator = calculaFator();

        int sep = 1;
        for (Display display : displays) {
            // Desenhando cada um dos displays
            display.desenharDisplay(desenho, this.coordenadaX, this.coordenadaY, this.cor, this.tamanho, fator);
            this.coordenadaX += fator / 0.8;

            // Desenha dois pontos de separação entre segundos, minutos e horas
            if (sep % 2 == 0 && sep != 6) {
                this.coordenadaX += fator / 2.5;
                desenho.setPenColor(cor);

                // Especificações dos pontos
                double quadradoX = coordenadaX - fator / 5.0;
                double quadradoY1 = coordenadaY + fator + fator / 3.0;
                double quadradoY2 = coordenadaY + fator;
                double quadradoTamanho = tamanho + fator / 25.0;

                // Desenha os dois pontos
                desenho.filledSquare(quadradoX, quadradoY1, quadradoTamanho);
                desenho.filledSquare(quadradoX, quadradoY2, quadradoTamanho);
            }
            sep++;
        }

        this.coordenadaX = coordenadaInicialX;
    }
}
