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
public class AnimacionCansado {
    Transformaciones trans;
    Universo universo;
    
    public AnimacionCansado(Universo universo) {  
        this.universo = universo;
        trans = new Transformaciones(this.universo);        
    }
    
    public void estadoCansado() {        
        trans.cambiarFondo("src\\manejo3d\\recursos\\Cansado.jpg");
        trans.rotarRaymanX(1);
    }
}
