/*
 * Aquí se importa el modelo con extensión .obj a Java 3D.
 */
package manejo3d;

/**
 *
 * @author Yareli Avilés
 */
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.utils.image.TextureLoader;
import java.awt.Container;
import java.io.FileReader;
import java.util.Map;
import javax.media.j3d.*;

public class LoadScene {

    String location;
    Shape3D parte;
    Scene scene;

    static TextureLoader loader;
    static Texture texture;

    public LoadScene(String location) {
        this.location = location;
        loader = new TextureLoader(location + "rayman.png",
                "RGP", new Container());
        texture = loader.getTexture();
    }

    public void load() {
        try {
            ObjectFile loader = new ObjectFile(ObjectFile.RESIZE);
            scene = loader.load(new FileReader(location + "Rayman3.obj"));

        } catch (Exception e) {
            System.out.println("Error al cargar el modelo");
        }
        Map<String, Shape3D> nameMap = scene.getNamedObjects();
        Shape3D shape = nameMap.get("mesh_rayman3_rayman_3");

        /* Por default, el BrachGroup de la Scene ya contiene una referencia a la figura, no puede haber más de 1, por lo que la removemos. */
        this.parte = shape;
        BranchGroup root = scene.getSceneGroup();
        root = scene.getSceneGroup();
        root.removeChild(shape);

        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);
        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        this.parte.setAppearance(ap);
    }

    public void listSceneNamedObjects() {
        Map<String, Shape3D> nameMap = scene.getNamedObjects();
        for (String name : nameMap.keySet()) {
            System.out.printf("Name: %s\n", name);
        }
    }

    public Shape3D getParte() {
        return parte;
    }

    Map<String, Shape3D> getNamedObjects() {
        throw new UnsupportedOperationException("No soportado.");
    }

}
