package entorno;

import javax.swing.JProgressBar;
import logica.MaquinaTamagochi;

/**
 *
 * @author Timoteo Latisnere
 */
public class BarraSueno extends JProgressBar implements Runnable {

    MaquinaTamagochi tama;
    Thread hilo;

    public BarraSueno(MaquinaTamagochi tama) {
        super();
        this.tama = tama;
        hilo = new Thread(this);
        hilo.start();
    }

    public void run() {
        while (true) {
            setValue(tama.getSueno());
        }
    }
}
