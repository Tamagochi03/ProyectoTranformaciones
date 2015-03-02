/*
 * Aquí se implementan los métodos necesarios de la clase
   Transformaciones para un tamagochi que está durmiendo.
 */
package manejo3d;

public class AnimacionDurmiendo {
    
    Transformaciones trans;
    Universo universo;
    
    public AnimacionDurmiendo(Universo universo) {  
        this.universo = universo;
        trans = new Transformaciones(this.universo);        
    }
    
    public void estadoDurmiendo() {        
        trans.cambiarFondo("src\\manejo3d\\recursos\\habitacion.jpg");
        trans.acostarRayman();
    }

}
