/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejo3d;

/**
 *
 * @author YareliS
 */

public class AnimacionMuerto {
    
    Transformaciones trans;
    Universo universo;
    
    public AnimacionMuerto(Universo universo) {  
        this.universo = universo;
        trans = new Transformaciones(this.universo);
        
    }
    
   
    public void estadoMuerto(){
        
        trans.cambiarFondo("src\\manejo3d\\recursos\\rip.png");
    
    }
    
    
}
