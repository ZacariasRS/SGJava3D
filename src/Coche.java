import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.ObjectFile;


public class Coche extends Scene {
	ObjectFile f = new ObjectFile (ObjectFile.RESIZE);
	Scene s = f.load(ClassLoader.getSystemResource("coche.ply"));
}
