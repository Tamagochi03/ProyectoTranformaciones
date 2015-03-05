package manejo3d;

/**
 *
 * @author Timoteo Enrique
 */
public class AnimacionCansado {

    Transformaciones trans;
    Universo universo;

    public AnimacionCansado(Universo universo) {
        this.universo = universo;
        trans = new Transformaciones(this.universo);
    }

    public void estadoCansado() {
        trans.cambiarFondo("src\\manejo3d\\recursos\\Cansado.jpg");
        trans.tumbarRayman();
    }
}
