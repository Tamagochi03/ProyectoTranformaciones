/*
 Esta clase crea el universo en el cual podrá vivir Rayman
 */
package manejo3d;

import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ImageComponent2D;
import javax.media.j3d.TransformGroup;

/**
 *
 * @author Yareli Avilés
 */
public class Universo {

    private BranchGroup group;
    private SimpleUniverse universe;
    private LoadScene ls;
    TransformGroup tg = new TransformGroup();
    Background fondo;

    public Universo(Canvas3D canvas3D) {
        universe = new SimpleUniverse(canvas3D);
        group = new BranchGroup();
        fondo = new Background();
        setup3DGraphics();
    }

    private void setup3DGraphics() {
        //Configuración de permisos sobre elementos del universo
        tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        group.setCapability(BranchGroup.ALLOW_DETACH);
        group.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        group.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
        group.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        
        //Carga del modelo
        ls = new LoadScene("src\\manejo3d\\recursos\\");
        ls.load();
        ls.listSceneNamedObjects();
        
        //Carga del fondo inicial
        TextureLoader tex = new TextureLoader("src\\manejo3d\\recursos\\fondoInicial.jpg", null);
        ImageComponent2D imagen = tex.getImage();
        fondo.setImage(imagen);
        BoundingSphere bounds = new BoundingSphere();
        fondo.setApplicationBounds(bounds);

        //Agregado de los elmentos al universo
        tg.addChild(ls.getParte());
        tg.addChild(fondo);
        group.addChild(tg);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(group);

    }

    public TransformGroup getTg() {
        return tg;
    }

    public BranchGroup getGroup() {
        return group;
    }
    
    public Background getFondo(){
        return fondo;
    }

    public void setTg() {
        group.addChild(tg);
    }
    
    public void setGroup(){
        universe.addBranchGraph(group);
    }

}
