/*
 * Aquí se crean todas las transformaciones que se puedan ocupar para el modelo.
 */
package manejo3d;

import com.sun.j3d.utils.image.TextureLoader;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.Transform3D;
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

    public void rotarRaymanX(int factor) {
        transform.rotX(factor);
        universo.getTransModelo().setTransform(transform);

    }

    public void rotarRaymanY(double factor) {
        aislarModelo();
        transform.rotY(factor);
        universo.getTransModelo().setTransform(transform);
        unirModelo();
    }

    public void rotarRaymanZ(double factor) {
        aislarModelo();
        transform.rotZ(factor);
        universo.getTransModelo().setTransform(transform);
        unirModelo();
    }

    public void trasladarRayman() {
        aislarModelo();
        translada = new Vector3f(2F, 3F, -10F);
        transform.setTranslation(translada);
        universo.getTransModelo().setTransform(transform);
        unirModelo();
    }

    public void escalaRayman() {
        escala = new Vector3d(3D, 1D, 2D);
        transform.setScale(escala);
        universo.getTransModelo().setTransform(transform);
    }
    
    public void cambiarFondo(String rutaImagen){
        aislarFondo();
        TextureLoader tex = new TextureLoader(rutaImagen, null);
        ImageComponent2D imagen= tex.getImage();
        Background background = new Background();
        background.setImage(imagen);
        BoundingSphere bounds = new BoundingSphere();
        background.setApplicationBounds(bounds);
        universo.getTransFondo().removeChild(universo.getFondo());
        universo.getTransFondo().addChild(background);
        unirFondo();
    }
    
    public void acostarRayman(){
        aislarElementos();
        Transform3D combinacion = new Transform3D();
        Transform3D rotacion = new Transform3D();
        rotacion.rotZ(100);
        Transform3D traslacion = new Transform3D();
        translada = new Vector3f(0.2F, 0.1F, -6F);
        traslacion.setTranslation(translada);
        combinacion.mul(traslacion, rotacion);
        universo.getTransModelo().setTransform(combinacion);
        unirElementos();
        
    }
    
    public void reset(){
        aislarModelo();
        Transform3D transform = new Transform3D();
        transform.perspective(1, 1, 1, 1);
        universo.getTransModelo().setTransform(transform);
        unirModelo();
        
    }
    
    public void aislarElementos(){
        aislarFondo();
        aislarModelo();
    }
    
    public void aislarFondo(){
        universo.getGrupoFondo().detach();
        universo.getGrupoFondo().removeChild(universo.getTransFondo());
    }
    
    public void aislarModelo(){
        universo.getGrupoModelo().detach();
        universo.getGrupoModelo().removeChild(universo.getTransModelo());
    }
    
    public void unirModelo(){
        universo.setTransModelo();
        universo.setGrupoModelo();
    }
    
    public void unirFondo(){
        universo.setTransFondo();
        universo.setGrupoFondo();
    }
    
    public void unirElementos(){
        unirModelo();
        unirFondo();
    }
    
    
}
