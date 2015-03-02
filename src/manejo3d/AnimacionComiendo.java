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


public class AnimacionComiendo {
    
    Transformaciones trans;
    Universo universo;
    
    public AnimacionComiendo(Universo universo) {  
        this.universo = universo;
        trans = new Transformaciones(this.universo); 
        
    }
    
    public void estadoComiendo() {
        
        trans.cambiarFondo("src\\manejo3d\\recursos\\cocina.jpg");
        
    }
    
    
}

