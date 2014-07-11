import java.awt.Container;

import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.*;

import javax.media.j3d.*;
import javax.vecmath.*;

public class Ball {

public Ball() {

   // Create the universe

   SimpleUniverse universe = new SimpleUniverse();

   // Create a structure to contain objects

   BranchGroup group = new BranchGroup();
   
   // Create a ball and add it to the group of objects
   TextureLoader tl = new TextureLoader("C:\\Users\\Zacarías\\Documents\\GitHub\\SG3\\grass_1.jpg","RGB",new Container());
   Texture texture = tl.getTexture();
   texture.setBoundaryModeS(Texture.WRAP);
   texture.setBoundaryModeT(Texture.WRAP);
   texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 0.0f, 0.0f));
   TextureAttributes texAtrr = new TextureAttributes();
   texAtrr.setTextureMode(TextureAttributes.MODULATE);
   Appearance app = new Appearance();
   app.setTexture(texture);
   app.setTextureAttributes(texAtrr);
   
   int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
   Sphere sphere = new Sphere(0.5f,primflags,app);
   
   TransformGroup tg = new TransformGroup();
   tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
   Transform3D tr = new Transform3D();
   tr.setTranslation(new Vector3f(0,0,0));
   tg.setTransform(tr);
   tg.addChild(sphere);
   group.addChild(tg);

   // Create a red light that shines for 100m from the origin

   Color3f light1Color = new Color3f(1.8f, 0.1f, 0.1f);

   BoundingSphere bounds =

   new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);

   Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);

   DirectionalLight light1

      = new DirectionalLight(light1Color, light1Direction);

   light1.setInfluencingBounds(bounds);

   group.addChild(light1);

   // look towards the ball

   universe.getViewingPlatform().setNominalViewingTransform();

   // add the group of objects to the Universe

   universe.addBranchGraph(group);

}

public static void main(String[] args) { new Ball(); }

}