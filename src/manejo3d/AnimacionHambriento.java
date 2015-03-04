/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manejo3d;

/**
 *
 * @author Shinsnake
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
