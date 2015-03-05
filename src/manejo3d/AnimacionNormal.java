package manejo3d;

import estados.Normal;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.MaquinaTamagochi;

/**
 *
 * @author Timoteo Latisnere
 */
public class AnimacionNormal implements Runnable {

    Transformaciones trans;
    MaquinaTamagochi tama;
    Thread hilo;

    public AnimacionNormal(Universo universo, MaquinaTamagochi tama) {
        this.tama = tama;
        trans = new Transformaciones(universo);
        hilo = new Thread(this);
        hilo.start();
    }

    public void run() {
        double factor = 0;
        while (true) {
            if (!(tama.getEstadoActual() instanceof Normal)) {
                hilo.suspend();
            }
            factor = factor + 0.05;
            trans.rotarRaymanY(factor);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(AnimacionNormal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void reanudarNormal() {
        hilo.resume();
    }

}
