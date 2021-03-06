package estados;

import javax.media.j3d.TransformGroup;
import javax.swing.JLabel;
import logica.MaquinaTamagochi;

/**
 *
 * @author Timoteo Latisnere
 */
public class EstadoGeneral {

    private TransformGroup tg;
    private MaquinaTamagochi tama;
    private JLabel mensajePensamiento;

    public TransformGroup getTg() {
        return tg;
    }

    public void setTg(TransformGroup tg) {
        this.tg = tg;
    }

    public MaquinaTamagochi getTama() {
        return tama;
    }

    public void setTama(MaquinaTamagochi tama) {
        this.tama = tama;
    }

    public JLabel getMensajePensamiento() {
        return mensajePensamiento;
    }

    public void setMensajePensamiento(JLabel mensajePensamiento) {
        this.mensajePensamiento = mensajePensamiento;
    }

    public void setEstado(Estado estado) {
        if (estado instanceof Normal || estado instanceof Cansado || estado instanceof Hambriento) {
            if (tama.getEnergia() <= 0) {
                estado = tama.getMuerto();
            } else if (tama.getHambre() > 60) {
                estado = tama.getHambriento();
                ((Hambriento) tama.getHambriento()).getAnimacion().estadoHambriento();
                tama.getHiloEneregia().decremento(3);

            } else if (tama.getSueno() > 40) {
                estado = tama.getCansado();
                ((Cansado) tama.getCansado()).getAnimacion().estadoCansado();
                tama.getHiloEneregia().decremento(2);

            }
        } else if (estado instanceof Hambriento || estado instanceof Cansado) {
            if (tama.getEnergia() > 0 && tama.getHambre() < 40 && tama.getSueno() < 70) {
                estado = tama.getNormal();
            }
        } else if (tama.getEstadoActual() instanceof Muerto) {
            ((Muerto) tama.getMuerto()).getAnimacion().estadoMuerto();
            Thread hilos[] = new Thread[20];
            Thread.enumerate(hilos);
            for (int i = 0; i < 10; i++) {
                hilos[i].stop();
            }
        }
        tama.setEstado(estado);
        if (tama.getEstadoActual() instanceof Normal) {
            ((Normal) tama.getNormal()).getAnimacion().reanudarNormal();
        }
    }

}
