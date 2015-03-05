package estados;

import javax.swing.JLabel;
import logica.MaquinaTamagochi;
import manejo3d.AnimacionMuerto;

/**
 *
 * @author Timoteo Latisnere
 */
public class Muerto extends EstadoGeneral implements Estado {

    AnimacionMuerto animacion;
    public Muerto(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
        animacion =  new AnimacionMuerto(getTama().getUniverso());
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("...");
    }

    @Override
    public void jugar() {
        getMensajePensamiento().setText("...");
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("...");
    }
    
    @Override
    public void runThread(){
    }
    
    public AnimacionMuerto getAnimacion(){
        return animacion;
    }
}
