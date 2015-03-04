/*
 * Aquí se crean todas las transformaciones que se puedan ocupar para el modelo.
 */
package manejo3d;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.image.TextureLoader;
import javax.media.j3d.Appearance;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author Yareli Avilés
 */
public class Transformaciones {
    Universo universo;
    Transform3D transform = new Transform3D();
    Vector3f translada;
    Vector3d escala;

    public Transformaciones(Universo universo) {
        this.universo = universo;
    }

    public void rotarRaymanX(double factor) {
        transform.rotX(factor);      
        universo.getTransModelo().setTransform(transform);

    }
    
    public void tumbarRayman(){
        Transform3D rotacionY = new Transform3D();
        Transform3D rotacionZ = new Transform3D();
        transform.rotX(30);
        rotacionY.rotY(50);
        rotacionZ.rotZ(5);
        transform.mul(rotacionY);
        transform.mul(rotacionZ);
        
        universo.getTransModelo().setTransform(transform);
    }

    public void rotarRaymanY(double factor) {
       // aislarModelo();
        transform.rotY(factor);
        universo.getTransModelo().setTransform(transform);
        //unirModelo();
    }

    public void rotarRaymanZ(double factor) {
        aislarModelo();
        transform.rotZ(factor);
        universo.getTransModelo().setTransform(transform);
        unirModelo();
    }

    public void trasladarRayman() {
        //aislarModelo();
        Transform3D escala = new Transform3D();
        Transform3D rotacionY = new Transform3D();
        Vector3d vectorEscala = new Vector3d(0.6D, 0.6D, 0.6D);
        
        
        rotacionY.rotY(70);
        escala.setScale(vectorEscala);        
        translada = new Vector3f(1.5F, 0.2F, 0F);
        transform.setTranslation(translada);
        transform.mul(escala, rotacionY);
        
        universo.getTransModelo().setTransform(transform);
        //unirModelo();
    }
    
    public void trasladarObjeto(Box shape){
        TransformGroup tg = universo.getTransFondo();
        Transform3D trans = new Transform3D();
        translada = new Vector3f(0F, 0F, -1F);
        trans.setTranslation(translada);        
        tg.setTransform(trans);
        
    }

    public void escalaRayman(double x, double y, double z) {
        escala = new Vector3d(x, y, z);
        transform.setScale(escala);
        universo.getTransModelo().setTransform(transform);
    }
    
    public void cambiarFondo(String rutaImagen){        
       // aislarFondo();
        TextureLoader tex = new TextureLoader(rutaImagen, null);
        Appearance ap = universo.getFondo().getAppearance();
        ap.setTexture(tex.getTexture());
       // unirFondo();
    }
    
    public void acostarRayman(){
        //aislarElementos();
        Transform3D combinacion = new Transform3D();
        Transform3D rotacionZ = new Transform3D();
        Transform3D rotacionY = new Transform3D();
        Transform3D rotacionX = new Transform3D();
        Transform3D traslacion = new Transform3D();
        Transform3D escala = new Transform3D();
        Vector3d vectorEscala = new Vector3d(0.4D, 0.4D, 0.4D);        
        rotacionZ.rotZ(100);
        rotacionY.rotY(180);
        rotacionX.rotX(0);
        translada = new Vector3f(0.2F, 0.1F, 0F);
        escala.setScale(vectorEscala);
        traslacion.setTranslation(translada);
        
        combinacion.mul(traslacion, rotacionZ);
        combinacion.mul(rotacionY);
        combinacion.mul(escala);
        
        universo.getTransModelo().setTransform(combinacion);
        //unirElementos();        
    }
    
    public void reset(){
        //aislarModelo();
        Transform3D transform = new Transform3D();
        transform.perspective(1, 1, 1, 1);
        universo.getTransModelo().setTransform(transform);
        //unirModelo();
        
    }
    
//    public void aislarElementos(){
//        aislarFondo();
//        aislarModelo();
//    }
    
//    public void aislarFondo(){
//        universo.getGrupoFondo().detach();
//        universo.getGrupoFondo().removeChild(universo.getTransFondo());
//    }
    
    public void aislarModelo(){
        universo.getGrupoModelo().detach();
        universo.getGrupoModelo().removeChild(universo.getTransModelo());
    }
    
    public void unirModelo(){
        universo.setTransModelo();
        universo.setGrupoModelo();
    }
    
//    public void unirFondo(){
//        universo.setTransFondo();
//        universo.setGrupoFondo();
//    }
    
//    public void unirElementos(){
//        unirModelo();
//        unirFondo();
//    }
    
    
}
