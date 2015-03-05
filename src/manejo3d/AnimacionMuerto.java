package manejo3d;

/**
 *
 * @author Yareli Sarahi
 */
public class AnimacionMuerto {

    Transformaciones trans;
    Universo universo;

    public AnimacionMuerto(Universo universo) {
        this.universo = universo;
        trans = new Transformaciones(this.universo);
    }

    public void estadoMuerto() {
        trans.cambiarFondo("src\\manejo3d\\recursos\\rip.png");
        trans.aislarModelo();
    }

}
