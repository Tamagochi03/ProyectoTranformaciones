/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manejo3d;

import java.util.logging.Level;
import java.util.logging.Logger;
import logica.MaquinaTamagochi;
import manejo3d.Transformaciones;
import manejo3d.Universo;

/**
 *
 * @author Shinsnake
 */
public class AnimacionNormal implements Runnable{
    Transformaciones trans;
    MaquinaTamagochi tama;
    
    public AnimacionNormal(Universo universo, MaquinaTamagochi tama){
        this.tama = tama;
        trans = new Transformaciones(universo);
        Thread hilo = new Thread(this);
        hilo.start();
    }
    public void run(){
        double factor = 0;
        while(true){
            factor = factor + 0.1;
            trans.rotarRaymanY(factor);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(AnimacionNormal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
