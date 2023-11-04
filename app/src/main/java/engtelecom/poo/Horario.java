/**
 * A classe Horario representa um horário no formato de horas, minutos e segundos.
 */
package engtelecom.poo;

public class Horario {
    private int horas;
    private int minutos;
    private int segundos;

    public Horario(int horas, int minutos, int segundos) {
        // verifica se foi informado um horário válido
        if (setHoras(horas) && setMinutos(minutos) && setSegundos(segundos)) {
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        }
    }

    /**
     * Obtém as horas do horário.
     *
     * @return As horas do horário.
     */
    public int getHoras() {
        return horas;
    }

    private boolean setHoras(int horas) {
        if (horas >= 0 && horas < 24) {
            this.horas = horas;
            return true;
        }
        return false;
    }

    /**
     * Obtém os minutos do horário.
     *
     * @return Os minutos do horário.
     */
    public int getMinutos() {
        return minutos;
    }

    private boolean setMinutos(int minutos) {
        if (minutos >= 0 && minutos < 60) {
            this.minutos = minutos;
            return true;
        }
        return false;
    }

    /**
     * Obtém os segundos do horário.
     *
     * @return Os segundos do horário.
     */
    public int getSegundos() {
        return segundos;
    }

    private boolean setSegundos(int segundos) {
        if (segundos >= 0 && segundos < 60) {
            this.segundos = segundos;
            return true;
        }
        return false;
    }

    /**
     * Atualiza o horário em um segundo, incrementando os segundos e ajustando
     * minutos e horas, se necessário.
     *
     * @return true se houve uma mudança na hora (por exemplo, à meia-noite), false
     *         caso contrário.
     */
    public boolean atualizaUmSegundo() {
        this.segundos++;

        if (segundos >= 60) {
            this.segundos = 0;
            this.minutos++;

            if (minutos >= 60) {
                this.minutos = 0;
                this.horas++;

                if (horas >= 24) {
                    // Zera o relógio
                    this.horas = 0;
                    this.minutos = 0;
                    this.segundos = 0;
                }
                return true;
            }
        }
        return false;
    }
}
