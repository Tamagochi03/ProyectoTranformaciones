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

    private BranchGroup grupoModelo;
    private BranchGroup grupoFondo;
    private SimpleUniverse universe;
    private LoadScene ls;
    TransformGroup transModelo = new TransformGroup();
    TransformGroup transFondo = new TransformGroup();
    Background fondo;

    public Universo(Canvas3D canvas3D) {
        universe = new SimpleUniverse(canvas3D);
        grupoModelo = new BranchGroup();
        grupoFondo = new BranchGroup();
        fondo = new Background();
        setup3DGraphics();
    }

    private void setup3DGraphics() {
        //Configuración de permisos sobre elementos del universo
        transModelo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        transFondo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        grupoModelo.setCapability(BranchGroup.ALLOW_DETACH);
        grupoModelo.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        grupoModelo.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
        grupoModelo.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        grupoFondo.setCapability(BranchGroup.ALLOW_DETACH);
        grupoFondo.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        grupoFondo.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
        grupoFondo.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        
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
        transModelo.addChild(ls.getParte());
        transFondo.addChild(fondo);
        grupoModelo.addChild(transModelo);
        grupoFondo.addChild(transFondo);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(grupoModelo);
        universe.addBranchGraph(grupoFondo);

    }

    public TransformGroup getTransModelo() {
        return transModelo;
    }

    public BranchGroup getGrupoModelo() {
        return grupoModelo;
    }
    
    public BranchGroup getGrupoFondo(){
        return grupoFondo;
    }
    
    public Background getFondo(){
        return fondo;
    }
    
    public TransformGroup getTransFondo(){
        return transFondo;
    }

    public void setTransModelo() {
        grupoModelo.addChild(transModelo);
    }
    
    public void setTransFondo() {
        grupoModelo.addChild(transFondo);
    }
    
    public void setGrupoModelo(){
        universe.addBranchGraph(grupoModelo);
    }
    
    public void setGrupoFondo(){
        universe.addBranchGraph(grupoFondo);
    }

}
