package manejo3d;

/**
 *
 * @author Yareli Sarahi
 */
public class AnimacionComiendo {

    Transformaciones trans;
    Universo universo;

    public AnimacionComiendo(Universo universo) {
        this.universo = universo;
        trans = new Transformaciones(this.universo);

    }

    public void estadoComiendo() {

        trans.cambiarFondo("src\\manejo3d\\recursos\\cocina.jpg");
        trans.trasladarRayman();

    }

}
