/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manejo3d;

import estados.Normal;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.MaquinaTamagochi;

/**
 *
 * @author Shinsnake
 */
public class AnimacionNormal implements Runnable{
    Transformaciones trans;
    MaquinaTamagochi tama;
    Thread hilo;
    
    
    public AnimacionNormal(Universo universo, MaquinaTamagochi tama){
        this.tama = tama;
        trans = new Transformaciones(universo);
        hilo = new Thread(this);
        hilo.start();
    }
    public void run(){
        double factor = 0;
        while(true){
            if(!(tama.getEstadoActual() instanceof Normal)){
                hilo.suspend();
            }
            factor = factor + 0.1;
            trans.rotarRaymanY(factor);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(AnimacionNormal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public void reanudarNormal(){
        //trans.reset();
        hilo.resume();
    }
    
}
