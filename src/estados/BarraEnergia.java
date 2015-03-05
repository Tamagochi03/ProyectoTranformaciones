package estados;

import logica.MaquinaTamagochi;

/**
 *
 * @author Timoteo Latisnere
 */
public class BarraEnergia extends BarraEstado implements Runnable {

    MaquinaTamagochi tama;

    public BarraEnergia(int contador, MaquinaTamagochi tama) {
        super(contador);
        hilo = new Thread(this);
        this.tama = tama;
        hilo.start();
    }

    public void run() {
        while (true) {
            contador--;
            tama.setEnergia(contador);
            System.out.println("Energia: " + contador);//TODO:delete
            try {
                Thread.sleep(velocidad);
            } catch (Exception e) {
                System.out.println("Error al dormir barra de energía");
            }
        }
    }
}
