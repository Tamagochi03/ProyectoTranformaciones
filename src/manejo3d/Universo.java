/*
 Esta clase crea el universo en el cual podrá vivir Rayman
 */
package manejo3d;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.TextureAttributes;
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
    Box fondo = new Box(1.5f, 1.5f, 0.0f,
        Box.GENERATE_TEXTURE_COORDS, new Appearance());
    Appearance ap = new Appearance();
    Transformaciones trans = new Transformaciones(this);

    public Universo(Canvas3D canvas3D) {
        universe = new SimpleUniverse(canvas3D);
        grupoModelo = new BranchGroup();
        grupoFondo = new BranchGroup();
        setup3DGraphics();
    }

    private void setup3DGraphics() {
        //Configuración de permisos sobre elementos del universo        
        grupoModelo.setCapability(BranchGroup.ALLOW_DETACH);
        grupoModelo.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        grupoModelo.setCapability(BranchGroup.ALLOW_CHILDREN_READ);
        grupoModelo.setCapability(BranchGroup.ALLOW_CHILDREN_WRITE);
        
        fondo.setCapability(Primitive.ENABLE_APPEARANCE_MODIFY);
        
        ap.setCapability(Appearance.ALLOW_TEXTURE_WRITE);
        
        transFondo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        transModelo.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        
        
        //Carga del modelo
        ls = new LoadScene("src\\manejo3d\\recursos\\");
        ls.load();
        ls.listSceneNamedObjects();
        
        //Carga del fondo inicial
        TextureLoader tex = new TextureLoader("src\\manejo3d\\recursos\\fondoInicial.jpg", null);   
        TextureAttributes textAttrib = new TextureAttributes();
        textAttrib.setTextureMode(TextureAttributes.REPLACE);
        ap.setTextureAttributes(textAttrib);
        ap.setTexture(tex.getTexture());
        
        fondo.setAppearance(ap);

        //Agregado de los elmentos al universo
        transModelo.addChild(ls.getParte());
        transFondo.addChild(fondo);
        grupoModelo.addChild(transModelo);
        grupoFondo.addChild(transFondo);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(grupoModelo);
        universe.addBranchGraph(grupoFondo);
        trans.trasladarObjeto(fondo);
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
    
    public Box getFondo(){
        return fondo;
    }
    
    public TransformGroup getTransFondo(){
        return transFondo;
    }

    public void setTransModelo() {
        grupoModelo.addChild(transModelo);
    }
    
//    public void setTransFondo() {
//        grupoFondo.addChild(transFondo);
//    }
    
    public void setGrupoModelo(){
        universe.addBranchGraph(grupoModelo);
    }
    
    public void setGrupoFondo(){
        universe.addBranchGraph(grupoFondo);
    }

}
