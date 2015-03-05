package manejo3d;

/**
 *
 * @author Timoteo Latisnere
 */
public class AnimacionHambriento {

    Transformaciones trans;
    Universo universo;

    public AnimacionHambriento(Universo universo) {
        this.universo = universo;
        trans = new Transformaciones(this.universo);
    }

    public void estadoHambriento() {
        trans.cambiarFondo("src\\manejo3d\\recursos\\hambre.jpg");
        trans.escalaRayman(1, 0.35, 1);
    }
}
