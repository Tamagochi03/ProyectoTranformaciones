package logica;

// @author Timoteo Latisnere
import estados.*;
import estados.Estado;
import javax.swing.JLabel;
import manejo3d.Universo;

public class MaquinaTamagochi {

    Estado cansado;
    Estado hambriento;
    Estado durmiendo;
    Estado comiendo;
    Estado jugando;
    Estado muerto;
    Estado normal;
    MonitorDeEstados monitor;

    JLabel mensaje;
    JLabel mensajeEstado;

    int energia;
    int hambre;
    int sueno;
    int aburrimiento;

    Thread hiloMonitor;

    BarraEnergia hiloEneregia;
    BarraHambre hiloHambre;
    BarraSueno hiloSueno;
    BarraAburrimiento hiloAburrimiento;

    Estado estadoActual;

    Universo universo;

    public MaquinaTamagochi(JLabel mensaje, JLabel estado, Universo universo) {
        energia = 99;
        hambre = 1;
        sueno = 1;
        aburrimiento = 1;
        this.mensaje = mensaje;

        this.universo = universo;

        cansado = new Cansado(this, this.mensaje);
        hambriento = new Hambriento(this, this.mensaje);
        durmiendo = new Durmiendo(this, this.mensaje);
        comiendo = new Comiendo(this, this.mensaje);
        jugando = new Jugando(this, this.mensaje);
        muerto = new Muerto(this, this.mensaje);
        normal = new Normal(this, this.mensaje);

        estadoActual = normal;

        //Se lazan los hilos que controlan las variables asociadas a las barras de progreso de la ventana.
        hiloEneregia = new BarraEnergia(energia, this);
        hiloHambre = new BarraHambre(hambre, this);
        hiloSueno = new BarraSueno(sueno, this);
        hiloAburrimiento = new BarraAburrimiento(aburrimiento, this);

        mensajeEstado = estado;
        estado.setText(getNombreEstado());

        monitor = new MonitorDeEstados(this, this.mensajeEstado);
    }

    public void dormir() {
        estadoActual.dormir();
        mensajeEstado.setText(getNombreEstado()); //TODO: delete
    }

    public void comer() {
        estadoActual.comer();
        mensajeEstado.setText(getNombreEstado());
    }

    public void jugar() {
        estadoActual.jugar();
        mensajeEstado.setText(getNombreEstado());
    }

    void setState(Estado estado) {
        this.estadoActual = estado;
    }

    public Estado getCansado() {
        return cansado;
    }

    public Estado getHambriento() {
        return hambriento;
    }

    public Estado getDurmiendo() {
        return durmiendo;
    }

    public Estado getComiendo() {
        return comiendo;
    }

    public Estado getJugando() {
        return jugando;
    }

    public Estado getMuerto() {
        return muerto;
    }

    public Estado getNormal() {
        return normal;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public int getEnergia() {
        return energia;
    }

    public int getHambre() {
        return hambre;
    }

    public int getSueno() {
        return sueno;
    }

    public int getAburrimiento() {
        return aburrimiento;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public void setSueno(int sueno) {
        this.sueno = sueno;
    }

    public void setAburrimiento(int aburrimiento) {
        this.aburrimiento = aburrimiento;
    }

    public JLabel getMensaje() {
        return mensaje;
    }

    public BarraEnergia getHiloEneregia() {
        return hiloEneregia;
    }

    public BarraHambre getHiloHambre() {
        return hiloHambre;
    }

    public BarraSueno getHiloSueno() {
        return hiloSueno;
    }

    public BarraAburrimiento getHiloAburrimiento() {
        return hiloAburrimiento;
    }

    public void setMensaje(JLabel mensaje) {
        this.mensaje = mensaje;
    }

    public void setEstado(Estado estado) {
        estadoActual = estado;
    }

    public Universo getUniverso() {
        return universo;
    }

    public String getNombreEstado() {
        return estadoActual.getClass().getName();
    }

}
