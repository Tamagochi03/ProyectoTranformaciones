/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estados;

import javax.swing.JLabel;
import logica.MaquinaTamagochi;
import manejo3d.AnimacionAburrido;
import manejo3d.AnimacionMuerto;

/**
 *
 * @author Shinsnake
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
