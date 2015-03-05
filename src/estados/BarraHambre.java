package estados;

import logica.MaquinaTamagochi;

/**
 *
 * @author Timoteo Latisnere
 */
public class BarraHambre extends BarraEstado implements Runnable {

    MaquinaTamagochi tamagochi;

    public BarraHambre(int contador, MaquinaTamagochi tamagochi) {
        super(contador);
        this.tamagochi = tamagochi;
        velocidad = 500;
        hilo = new Thread(this);
        hilo.start();
    }

    public void run() {
        while (true) {
            contador++;
            try {
                Thread.sleep(velocidad);
                tamagochi.setHambre(contador);
                System.out.println(contador);//TODO:delete
            } catch (Exception e) {
                System.out.println("Error al dormir barra de estado");
            }
        }
    }
}
