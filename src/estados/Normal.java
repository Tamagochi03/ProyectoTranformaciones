package estados;

import javax.swing.JLabel;
import logica.MaquinaTamagochi;
import manejo3d.AnimacionNormal;

/**
 *
 * @author Timoteo Latisnere
 */
public class Normal extends EstadoGeneral implements Estado {

    AnimacionNormal animacion;

    public Normal(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
        animacion = new AnimacionNormal(getTama().getUniverso(), getTama());

    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("No tengo mucho sueño");
    }

    @Override
    public void jugar() {
        if (getTama().getAburrimiento() > 10) {
            setEstado(getTama().getJugando());
            getTama().getEstadoActual().runThread();
        } else {
            System.out.println("No estoy aburrido");
            getMensajePensamiento().setText("No estoy aburrido");
        }
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("No tengo mucha hambre");
    }

    @Override
    public void runThread() {
    }

    public AnimacionNormal getAnimacion() {
        return animacion;
    }
}
