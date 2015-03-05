package estados;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import logica.MaquinaTamagochi;
import manejo3d.AnimacionComiendo;

/**
 *
 * @author Timoteo Latisnere
 */
public class Comiendo extends EstadoGeneral implements Estado, Runnable {

    AnimacionComiendo animacion;

    public Comiendo(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
        animacion = new AnimacionComiendo(getTama().getUniverso());
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("Tal vez después de comer me dé sueño");
    }

    @Override
    public void jugar() {
        getMensajePensamiento().setText("No me interrumpas cuando como!");
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("Creo que no podría comer más!");
    }

    public void runThread() {
        Thread hilo;
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        animacion.estadoComiendo();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Comiendo.class.getName()).log(Level.SEVERE, null, ex);
        }
        getTama().getHiloEneregia().incremento(30);
        getTama().getHiloHambre().decremento(50);

        setEstado(getTama().getNormal());
    }
}
