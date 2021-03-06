package estados;

/**
 *
 * @author Timoteo Latisnere
 */
public class BarraEstado {

    Thread hilo;
    int contador;
    int velocidad;

    public BarraEstado(int contador) {
        this.contador = contador;
        velocidad = 1000;
    }

    public void incremento(int ValorIcremento) {
        contador = contador + ValorIcremento;
    }

    public void decremento(int ValorDecremento) {
        contador = contador - ValorDecremento;
    }

    public Thread getHilo() {
        return hilo;
    }

    public void setHilo(Thread hilo) {
        this.hilo = hilo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

}
