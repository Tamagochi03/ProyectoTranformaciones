package manejo3d;

import estados.Jugando;
import logica.MaquinaTamagochi;

/**
 *
 * @author Yareli Sarahi
 */
public class AnimacionJugando implements Runnable {

    Transformaciones trans;
    Universo universo;
    Thread hilo;
    MaquinaTamagochi tama;

    public AnimacionJugando(Universo universo, MaquinaTamagochi tama) {
        this.universo = universo;
        this.tama = tama;
        trans = new Transformaciones(this.universo);

    }

    public void estadoJugando() {

        trans.cambiarFondo("src\\manejo3d\\recursos\\jugar.png");
        hilo = new Thread(this);
        hilo.start();
    }

    public void run() {
        double factor = 0;
        while (true) {
            if (!(tama.getEstadoActual() instanceof Jugando)) {
                hilo.stop();
                trans.reset();
            }
            factor = factor + 0.1;
            trans.rotarRaymanX(factor);
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
