import java.applet.Applet;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;


import javax.media.j3d.*;
import javax.swing.*;
import javax.vecmath.*;


import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

import java.awt.event.*;

//   SimpleBehaviorApp renders a single ColorCube
//   that rotates when any key is pressed.

/**
 * @author Sravan
 *
 */
public class SimpleBehaviorApp extends Applet {
	private JButton br=new JButton(" Rotate-Right ");
	private JButton bd=new JButton(" Rotate-Down ");
    private JButton bl = new JButton("Rotate-left");
    private JButton bu = new JButton("Rotate-Up");
    private Transform3D translate=new Transform3D();
    private BoundingSphere bounds =
            new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1000.0);
public class SimpleBehavior extends Behavior {

    private TransformGroup targetTG;

    private Transform3D rotation = new Transform3D();
    

    private double angleY = 0.0;
    private double angleX= 0.0;

    // create SimpleBehavior
    SimpleBehavior(TransformGroup targetTG) {
    this.targetTG = targetTG;
    }

    // initialize the Behavior
    //     set initial wakeup condition
    //     called when behavior beacomes live
    public void initialize() {
      // set initial wakeup condition
      this.wakeupOn(new WakeupOnAWTEvent(KeyEvent.MOUSE_MOTION_EVENT_MASK));
    }

    // behave
    // called by Java 3D when appropriate stimulus occures
    public void processStimulus(Enumeration criteria) {
      // decode event

      // do what is necessary
//      angle += 0.1;
//      rotation.rotY(angle);
//      targetTG.setTransform(rotation);
//      b.setLabel(rotation.toString());
//      this.wakeupOn(new WakeupOnAWTEvent(KeyEvent.KEY_PRESSED));
    	
    	bu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double now=angleX;
				rotation.rotY(angleY);
				targetTG.setTransform(rotation);
	      		for(double i=angleX;i<now+1.57;i+=0.000001)
	      		{
	      		angleX = i;
	            rotation.rotX(angleX);
	            targetTG.setTransform(rotation);
	      		}
			}
		});
    bl.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		double i=0.0d;
      		double now=angleY;
      			for(i=angleY;i<(now+1.57);i+=0.000001)
      		{
      		angleY = i;
            rotation.rotY(angleY);
            targetTG.setTransform(rotation);
      		}
      	}
      });
    }

  } // end of class SimpleBehavior

public BranchGroup createSceneGraph() {
    // Create the root of the branch graph
    BranchGroup objRoot = new BranchGroup();

    TransformGroup objRotate = new TransformGroup();
//    TransformGroup objRotate1=new TransformGroup();
//    TransformGroup objTranslate=new TransformGroup(translate);
    objRotate.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
    
    objRoot.addChild(objRotate);
    ColorCube cc=new ColorCube(0.1);
   /* objTranslate.addChild(cc);
    objRotate.addChild(objTranslate);*/
    
   /* ColorCube cc1=new ColorCube(0.3);
    objTranslate.addChild(cc1);
    objRotate1.addChild(objTranslate);*/
    objRotate.addChild(cc);
    /*MouseRotate behavior = new MouseRotate();
    behavior.setTransformGroup(objRotate);
    objRotate.addChild(behavior);
    behavior.setFactor(1, 0);
    behavior.setSchedulingBounds(bounds)*/;

    SimpleBehavior myRotationBehavior = new SimpleBehavior(objRotate);
    
    myRotationBehavior.setSchedulingBounds(new BoundingSphere());
    
    objRoot.addChild(myRotationBehavior);
//    objRoot.addChild(new SimpleBehavior(objRotate1).setSchedulingBounds(new BoundingSphere()));
    
//    KeyNavigatorBehavior key = new KeyNavigatorBehavior( objRotate );
//    key.setSchedulingBounds( createApplicationBounds() );
//    key.setEnable( true );
//    objRoot.addChild( key );
    // Let Java 3D perform optimizations on this scene graph.
    objRoot.compile();

    return objRoot;
  } // end of CreateSceneGraph method of SimpleBehaviorApp

  // Create a simple scene and attach it to the virtual universe

  private Bounds createApplicationBounds() {
	// TODO Auto-generated method stub
	 Bounds mpp= new BoundingSphere(new Point3d(0.0, 0.0, 0.0),
		        100.0);
	return mpp;
}

public SimpleBehaviorApp() {
//	Panel p=new Panel();
    setLayout(new BorderLayout());
    GraphicsConfiguration gconf=SimpleUniverse.getPreferredConfiguration();
    Canvas3D canvas3D = new Canvas3D(gconf);
    OrbitBehavior orbit = new OrbitBehavior(canvas3D,
            OrbitBehavior.REVERSE_ALL|OrbitBehavior.STOP_ZOOM);
    orbit.setSchedulingBounds(bounds);
    add("Center", canvas3D);
//   setVisible(true);
     SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
     translate.setTranslation(new Vector3f(0.0f, 0.4f, 0.0f));
     
   /*  add(bl, BorderLayout.NORTH);     
     add(bu, BorderLayout.SOUTH);*/
     BranchGroup scene = createSceneGraph();
  
//     setLayout(null);
    
    
//   bl.setBounds(30, 30, 10, 20);
    
    // SimpleUniverse is a Convenience Utility class
    

    // This will move the ViewPlatform back a bit so the
    // objects in the scene can be viewed.
     ViewingPlatform viewingPlatform =simpleU.getViewingPlatform();

    simpleU.addBranchGraph(scene);
    simpleU.getViewingPlatform().setNominalViewingTransform();
    viewingPlatform.setViewPlatformBehavior(orbit);
  } // end of SimpleBehaviorApp (constructor)

  //  The following allows this to be run as an application
  //  as well as an applet

  public static void main(String[] args) {
    
    Frame frame = new MainFrame(new SimpleBehaviorApp(), 256, 256);
  } // end of main (method of SimpleBehaviorApp)

} // end of class SimpleBehaviorApp
