import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.*;

import com.sun.j3d.utils.universe.*;

import javax.media.j3d.*;

import javax.vecmath.*;

public class Position extends Applet{
	TransformGroup big=new TransformGroup();
	Transform3D tsf3=new Transform3D();
	BoundingSphere bounds =

		      new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
	OrbitBehavior orbit;
public Position() {
setLayout(new BorderLayout());
	 GraphicsConfiguration gconf=SimpleUniverse.getPreferredConfiguration();
	    Canvas3D canvas3D = new Canvas3D(gconf);
	    orbit = new OrbitBehavior(canvas3D,
	            OrbitBehavior.REVERSE_ALL|OrbitBehavior.STOP_ZOOM);
	    orbit.setSchedulingBounds(bounds);
	    add("Center", canvas3D);
   SimpleUniverse universe = new SimpleUniverse(canvas3D);

   BranchGroup group = new BranchGroup();

   // X axis made of spheres

   for (float x = -1.0f; x <= 1.0f; x = x + 0.1f)

   {

      Sphere sphere = new Sphere(0.05f);

      TransformGroup tg = new TransformGroup();

      Transform3D transform = new Transform3D();

      Vector3f vector = new Vector3f( x, .0f, .0f);

      transform.setTranslation(vector);

      tg.setTransform(transform);

      tg.addChild(sphere);

      group.addChild(tg);
      

   }

   // Y axis made of cones

   for (float y = -1.0f; y <= 1.0f; y = y + 0.1f)

   {

      TransformGroup tg = new TransformGroup();

      Transform3D transform = new Transform3D();

      Cone cone = new Cone(0.05f, 0.1f);

      Vector3f vector = new Vector3f(.0f, y, .0f);

      transform.setTranslation(vector);

       tg.setTransform(transform);

      tg.addChild(cone);
tg.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//      group.addChild(tg);
      big.addChild(tg);

   }
   group.addChild(big);
  big.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
  MouseRotate behavior = new MouseRotate();
  behavior.setTransformGroup(big);
  big.addChild(behavior);
  behavior.setFactor(0.02, 0);
  behavior.setSchedulingBounds(bounds);
  
   // Z axis made of cylinders
Button b=new Button("Rotate cones");
b.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		 tsf3.rotZ(1.57);
		   big.setTransform(tsf3);
		   orbit.setEnable(false);
	}
	
});
   for (float z = -1.0f; z <= 1.0f; z = z+ 0.1f)

   {

      TransformGroup tg = new TransformGroup();

      Transform3D transform = new Transform3D();

      Cylinder cylinder = new Cylinder(0.05f, 0.1f);

      Vector3f vector = new Vector3f(.0f, .0f, z);

      transform.setTranslation(vector);

      tg.setTransform(transform);

       tg.addChild(cylinder);

      group.addChild(tg);

   }

    add(b,BorderLayout.NORTH);
   Color3f light1Color = new Color3f(.1f, 1.4f, .1f); // green light

   

   Vector3f light1Direction = new Vector3f(4.0f, -7.0f, -12.0f);

   DirectionalLight light1

      = new DirectionalLight(light1Color, light1Direction);

   light1.setInfluencingBounds(bounds);

   group.addChild(light1);
   ViewingPlatform vp=universe.getViewingPlatform();
   universe.getViewingPlatform().setNominalViewingTransform();

   // add the group of objects to the Universe

   universe.addBranchGraph(group);
   vp.setViewPlatformBehavior(orbit);

}

public static void main(String[] args) {

	Frame frame = new MainFrame(new Position(), 256, 256);

}

}