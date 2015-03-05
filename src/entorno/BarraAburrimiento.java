package entorno;

import javax.swing.JProgressBar;
import logica.MaquinaTamagochi;

/**
 *
 * @author Timoteo Latisnere
 */
public class BarraAburrimiento extends JProgressBar implements Runnable{
    MaquinaTamagochi tama;
    Thread hilo;
    
    public BarraAburrimiento(MaquinaTamagochi tama){
        super();
        this.tama = tama;
        hilo = new Thread(this);
        hilo.start();
    }
    
    public void run(){
        while(true){
            setValue(tama.getAburrimiento());
        }
    }
}
