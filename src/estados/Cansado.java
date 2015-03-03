/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estados;

import javax.swing.JLabel;
import logica.MaquinaTamagochi;
import manejo3d.AnimacionCansado;

/**
 *
 * @author Shinsnake
 */
public class Cansado extends EstadoGeneral implements Estado {
    
    AnimacionCansado animacion;
    
    public Cansado(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
        animacion = new AnimacionCansado(getTama().getUniverso());     
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("Si! a dormir!");
        setEstado(getTama().getDurmiendo());
        getTama().getEstadoActual().runThread();
        
    }

    @Override
    public void jugar() {
        getMensajePensamiento().setText("No tengo ganas de jugar");
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("Estoy cansado no hambriento!");
    }
    
    @Override
    public void runThread(){
    }
    
    public AnimacionCansado getAnimacion(){
        return animacion;
    }
}
