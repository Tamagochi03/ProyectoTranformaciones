/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entorno;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import logica.MaquinaTamagochi;
import manejo3d.Universo;


/* *
 @author Yareli Avilés 
 */
public class TamagochiFrame extends JFrame implements ActionListener {

    private Canvas3D canvas3D;
    private Appearance ap;

    /**
     * Declaración de Paneles
     */
    private JPanel jpB;
    private JPanel jpL;
    private JPanel jpPb;
    private JPanel jpL1;
    private JPanel jpE;

    /**
     * Declaración de Botones y etiquetas
     */
    private JButton bcomer; //Boton de comer
    private JLabel lhambre;
    private JButton bdormir; //Boton de dormir
    private JLabel lsueno;
    private JButton bjugar; //Boton de jugar
    private JLabel lAburrimiento;
    private JLabel lEnergia;
    private JLabel mensaje;
    private JLabel estado; //TODO:delte

    /**
     * Declaración de Barras de progreso
     */
    private BarraSueno PbSuenio;
    private BarraHambre PbHambre;
    private BarraAburrimiento PbAburrimiento;
    private BarraEnergia PbEnergia;

    private MaquinaTamagochi tamagochi;
    static Sphere sphere;

    Universo universo;

    public TamagochiFrame() {

        super("Tamagochi 3D");

        setResizable(false);
        setSize(900, 600);
        setLocationRelativeTo(null);
        GraphicsConfiguration config
                = SimpleUniverse.getPreferredConfiguration();

        /**
         * Inicialización de Variables
         */
        canvas3D = new Canvas3D(config);
        canvas3D.setSize(500, 00);

        bcomer = new JButton("Comer");
        lhambre = new JLabel("Hambre");

        bdormir = new JButton("Dormir");
        lsueno = new JLabel("Sueno");

        bjugar = new JButton("Jugar");

        lEnergia = new JLabel("Energía");
        lAburrimiento = new JLabel("Aburrimiento");

        mensaje = new JLabel("Hola, soy Rayman");
        estado = new JLabel("Estado Actual");
        //TODO: verificar funcionalidad y orden de ejecución de estas líneas
        universo = new Universo(canvas3D);

        tamagochi = new MaquinaTamagochi(mensaje, estado, universo);

        PbSuenio = new BarraSueno(tamagochi);
        PbHambre = new BarraHambre(tamagochi);
        PbAburrimiento = new BarraAburrimiento(tamagochi);
        PbEnergia = new BarraEnergia(tamagochi);

        jpB = new JPanel();
        jpL = new JPanel();
        jpL1 = new JPanel();
        jpE = new JPanel();

        jpL.add(lhambre);
        jpL.add(PbHambre);
        jpB.add(bcomer);

        jpL.add(lsueno);
        jpL.add(PbSuenio);
        jpB.add(bdormir);

        jpL.add(lAburrimiento);
        jpL.add(PbAburrimiento);
        jpB.add(bjugar);
        jpE.add(lEnergia);
        jpE.add(PbEnergia);
        jpL1.add(mensaje);
        jpL1.add(estado);

        add("North", jpL);
        add("East", jpB);
        add("Center", jpL1);
        add("West", canvas3D);
        add("South", jpE);

        bdormir.addActionListener(this);
        bjugar.addActionListener(this);
        bcomer.addActionListener(this);

        setup3DGraphics();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    void setup3DGraphics() {
        
    }

    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        if (boton.getText().equals("Comer")) {
            tamagochi.comer();
        } else if (boton.getText().equals("Dormir")) {
            tamagochi.dormir();
        } else if (boton.getText().equals("Jugar")) {
            tamagochi.jugar();
        }
    }

    public static void main(String[] args) {

        new TamagochiFrame();

    }

    public void windowClosing(WindowEvent e) {

        System.exit(0);
    }
}
