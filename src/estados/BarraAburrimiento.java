package estados;

import logica.MaquinaTamagochi;

/**
 *
 * @author Timoteo Latisnere
 */
public class BarraAburrimiento extends BarraEstado implements Runnable {

    MaquinaTamagochi tamagochi;

    public BarraAburrimiento(int contador, MaquinaTamagochi tamagochi) {
        super(contador);
        this.tamagochi = tamagochi;
        hilo = new Thread(this);
        hilo.start();
    }

    public void run() {
        while (true) {
            contador++;
            try {
                Thread.sleep(velocidad);
                tamagochi.setAburrimiento(contador);
                System.out.println(contador);//TODO:delete
            } catch (Exception e) {
                System.out.println("Error al dormir barra de estado");
            }
        }
    }
}
