/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package estados;

import manejo3d.AnimacionHambriento;
import javax.swing.JLabel;
import logica.MaquinaTamagochi;

/**
 *
 * @author Shinsnake
 */
public class Hambriento extends EstadoGeneral implements Estado{
    
    AnimacionHambriento animacion;
    public Hambriento(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
        animacion = new AnimacionHambriento(getTama().getUniverso());
    }

    @Override
    public void dormir() {
        getMensajePensamiento().setText("Tengo mucha hambre, no puedo dormir...");
    }

    @Override
    public void jugar() {
        getMensajePensamiento().setText("No tengo energías para jugar...");
    }

    @Override
    public void comer() {
        getMensajePensamiento().setText("Por fin! Comida!");
        setEstado(getTama().getComiendo());
        getTama().getEstadoActual().runThread();
    }
    
    @Override
    public void runThread(){
        Thread hilo;
        hilo = new Thread((Runnable) this);
        hilo.start();
    }
    
    public void run(){
         try{ 
            Thread.sleep(5000);
            getTama().getHiloEneregia().incremento(30);
            getTama().getHiloSueno().decremento(50);
            setEstado(getTama().getNormal());
        }catch (Exception e){
            System.out.println("Error al dormir el hilo"); //TODO: delete , este metodo es solo para debug del manejo de hilos
        }
    }

    public AnimacionHambriento getAnimacion() {
        return animacion;
    }       

}
