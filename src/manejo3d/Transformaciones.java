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
        universo.getTg().setTransform(transform);

    }

    public void rotarRaymanY(int factor) {
        transform.rotY(factor);
        universo.getTg().setTransform(transform);
    }

    public void rotarRaymanZ(int factor) {
        aislarElementos();
        transform.rotZ(factor);
        universo.getTg().setTransform(transform);
        unirElementos();
    }

    public void trasladarRayman() {
        aislarElementos();
        translada = new Vector3f(2F, 3F, -10F);
        transform.setTranslation(translada);
        universo.getTg().setTransform(transform);
        unirElementos();
    }

    public void escalaRayman() {
        escala = new Vector3d(3D, 1D, 2D);
        transform.setScale(escala);
        universo.getTg().setTransform(transform);
    }
    
    public void cambiarFondo(String rutaImagen){
        aislarElementos();
        TextureLoader tex = new TextureLoader(rutaImagen, null);
        ImageComponent2D imagen= tex.getImage();
        Background background = new Background();
        background.setImage(imagen);
        BoundingSphere bounds = new BoundingSphere();
        background.setApplicationBounds(bounds);
        universo.getTg().removeChild(universo.getFondo());
        universo.getTg().addChild(background);
        unirElementos();
    }
    
    public void acostarRayman(){
        aislarElementos();
        Transform3D combinacion = new Transform3D();
        Transform3D rotacion = new Transform3D();
        rotacion.rotZ(100);
        Transform3D traslacion = new Transform3D();
        translada = new Vector3f(2F, 3F, -10F);
        traslacion.setTranslation(translada);
        combinacion.mul(traslacion, rotacion);
        universo.getTg().setTransform(combinacion);
        unirElementos();
        
    }
    
    public void aislarElementos(){
        universo.getGroup().detach();
        universo.getGroup().removeAllChildren();
    }
    
    public void unirElementos(){
        universo.setTg();
        universo.setGroup();
    }
}
