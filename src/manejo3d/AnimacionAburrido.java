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
import com.sun.j3d.utils.image.TextureLoader;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TransformGroup;


public class AnimacionAburrido {
    
    Transformaciones trans;
    Shape3D shape;
    TextureLoader tex;
    ImageComponent2D imagen;
    Background background;
    BoundingSphere bounds = new BoundingSphere();
    TransformGroup Tuxcontent = new TransformGroup();
    TransformGroup Tuxtrans = new TransformGroup();
    TransformGroup grupoTrans;
    
    public AnimacionAburrido(TransformGroup grupoTrans) {  
        Tuxcontent.addChild(Tuxtrans);
        this.grupoTrans = grupoTrans;
        
    }
    
    public TransformGroup estadoAburrido() {
        //trans = new Transformaciones();
        trans.trasladarRayman();
        trans.rotarRaymanZ(100);
        return grupoTrans;  
    }
    
    public TransformGroup fondoAburrido() {
        tex = new TextureLoader("src\\manejo3d\\recursos\\nada.jpg", null);
        imagen= tex.getImage();
        background = new Background();
        background.setImage(imagen);
        background.setApplicationBounds(bounds);
        Tuxcontent.addChild(background);
        return Tuxcontent;
    }
    
    
}

