package estados;

import javax.swing.JLabel;
import logica.MaquinaTamagochi;
import manejo3d.AnimacionJugando;

/**
 *
 * @author Timoteo Latisnere
 */
public class Jugando extends EstadoGeneral implements Estado, Runnable {

    AnimacionJugando animacion;

    public Jugando(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
        animacion = new AnimacionJugando(getTama().getUniverso(), getTama());
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("Aún quiero jugar!");
    }

    @Override
    public void jugar() {
        getMensajePensamiento().setText("Qué divertido!");
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("No gracias, me podría doler la barriga");
    }

    @Override
    public void runThread() {
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {
        try {

            animacion.estadoJugando();
            Thread.sleep(5000);
            getTama().getHiloEneregia().decremento(10);
            getTama().getHiloHambre().incremento(20);
            getTama().getHiloAburrimiento().decremento(40);

            setEstado(getTama().getNormal());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
