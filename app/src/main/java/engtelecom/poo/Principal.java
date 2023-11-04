/**
 * A classe Principal é responsável por criar uma interface gráfica simples que exibe
 * relógios digitais e atualiza seus horários em intervalos regulares.
 */
package engtelecom.poo;

import edu.princeton.cs.algs4.Draw;
import java.util.ArrayList;

public class Principal {
    private ArrayList<RelogioDigital> relogios;
    private Draw desenho;

    /**
     * A dimensão máxima da área de desenho.
     */
    public static final int DIMENSAO = 1000;

    public Principal() {
        this.relogios = new ArrayList<>();

        this.desenho = new Draw();
        this.desenho.setXscale(0, DIMENSAO);
        this.desenho.setYscale(0, DIMENSAO);
        this.desenho.setDefaultCloseOperation(3);
        this.desenho.enableDoubleBuffering();
    }

    /**
     * Desenha todos os relógios na área de desenho.
     */
    public void desenhaRelogios() {
        for (RelogioDigital relogio : relogios) {
            relogio.desenhaRelogio(desenho);
        }
        desenho.show();
    }

    /**
     * O método principal da aplicação que cria uma instância da classe Principal,
     * adiciona relógios à lista e atualiza os relógios a cada segundo,
     * exibindo-os na área de desenho.
     * 
     * @param args Os argumentos da linha de comando (não são usados neste caso).
     * @throws InterruptedException se ocorrer um erro na interrupção da thread.
     */
    public static void main(String[] args) throws InterruptedException {
        Principal p = new Principal();

        RelogioDigital r = new RelogioDigital(100, 100, 12, 34, 56, "ROSA", 1);
        RelogioDigital r2 = new RelogioDigital(100, 300, 12, 34, 56, "verde", 2);
        RelogioDigital r3 = new RelogioDigital(100, 600, 12, 34, 56, "azul", 3);

        p.relogios.add(r);
        p.relogios.add(r2);
        p.relogios.add(r3);

        for (int i = 1; i <= 10; i++) {
            // limpando a área de desenho
            p.desenho.clear(Draw.BLACK);

            // desenhando cada um dos relógios
            p.desenhaRelogios();

            // incrementando 1 segundo nos relógios
            for (RelogioDigital relogio : p.relogios) {
                relogio.incrementaSegundo();
            }

            // dormindo por 1 segundo
            Thread.sleep(1000);

        }
    }
}
