/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estados;

import javax.swing.JLabel;
import logica.MaquinaTamagochi;
import manejo3d.AnimacionAburrido;

/**
 *
 * @author Shinsnake
 */
public class Cansado extends EstadoGeneral implements Estado {
    
    AnimacionAburrido animacion;
    public Cansado(MaquinaTamagochi tamagochi, JLabel mensajePensamiento) {
        setTama(tamagochi);
        setMensajePensamiento(mensajePensamiento);
        //animacion = new AnimacionAburrido(getTama().getTg());
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
        Thread hilo;
        hilo = new Thread((Runnable) this);
        hilo.start();
    }
    
    public void run(){
         try{
             
           // getTama().setTg(animacion.estadoAburrido());
            //
            Thread.sleep(5000);
            getTama().getHiloEneregia().incremento(30);
            getTama().getHiloSueno().decremento(50);
            setEstado(getTama().getNormal());
        }catch (Exception e){
            System.out.println("Error al dormir el hilo"); //TODO: delete , este metodo es solo para debug del manejo de hilos
        }
    }
}
