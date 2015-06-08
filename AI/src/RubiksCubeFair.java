import java.applet.*;
import java.awt.*;

import javax.media.j3d.*;
import javax.vecmath.*;

import com.sun.j3d.utils.applet.*;
import com.sun.j3d.utils.behaviors.vp.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;

public class RubiksCubeFair extends Applet
{
	private int i=0,j=0,k=0;
	Bounds bounds=createApplicationBounds();
	private static final float[] verts = {
	    // front face
	   1.0f, -1.0f,  1.0f,
	   1.0f,  1.0f,  1.0f,
	  -1.0f,  1.0f,  1.0f,
	  -1.0f, -1.0f,  1.0f,
	    // back face
	  -1.0f, -1.0f, -1.0f,
	  -1.0f,  1.0f, -1.0f,
	   1.0f,  1.0f, -1.0f,
	   1.0f, -1.0f, -1.0f,
	    // right face
	   1.0f, -1.0f, -1.0f,
	   1.0f,  1.0f, -1.0f,
	   1.0f,  1.0f,  1.0f,
	   1.0f, -1.0f,  1.0f,
	    // left face
	  -1.0f, -1.0f,  1.0f,
	  -1.0f,  1.0f,  1.0f,
	  -1.0f,  1.0f, -1.0f,
	  -1.0f, -1.0f, -1.0f,
	    // top face
	   1.0f,  1.0f,  1.0f,
	   1.0f,  1.0f, -1.0f,
	  -1.0f,  1.0f, -1.0f,
	  -1.0f,  1.0f,  1.0f,
	    // bottom face
	  -1.0f, -1.0f,  1.0f,
	  -1.0f, -1.0f, -1.0f,
	   1.0f, -1.0f, -1.0f,
	   1.0f, -1.0f,  1.0f,
	    };
	private static final float[] colors = {
	    // front face (red)
	  1.0f, 0.0f, 0.0f,
	  1.0f, 0.0f, 0.0f,
	  1.0f, 0.0f, 0.0f,
	  1.0f, 0.0f, 0.0f,
	    // back face (orange)
	  1.0f, 0.5f, 0.0f,
	  1.0f, 0.5f, 0.0f,
	  1.0f, 0.8f, 0.0f,
	  1.0f, 0.8f, 0.0f,
	    // right face (green)
	  0.0f, 1.0f, 0.0f,
	  0.0f, 1.0f, 0.0f,
	  0.0f, 1.0f, 0.0f,
	  0.0f, 1.0f, 0.0f,
	    // left face (blue)
	  0.0f, 0.0f, 1.0f,
	  0.0f, 0.0f, 1.0f,
	  0.0f, 0.0f, 1.0f,
	  0.0f, 0.0f, 1.0f,
	    // top face (white)
	  1.0f, 1.0f, 1.0f,
	  1.0f, 1.0f, 1.0f,
	  1.0f, 1.0f, 1.0f,
	  1.0f, 1.0f, 1.0f,
	    // bottom face (yellow)
	  1.0f, 1.0f, 0.0f,
	  1.0f, 1.0f, 0.0f,
	  1.0f, 1.0f, 0.0f,
	  1.0f, 1.0f, 0.0f,
	    };

	
public Bounds createApplicationBounds()
{
	return new BoundingSphere(new Point3d(0.0,0.0,0.0),100.0);
}

public BranchGroup createSceneGraph()
{
	BranchGroup root=new BranchGroup();
	float y;
	float z;
	float x=y=z=0.0f;
	for(i=0,x=0;i<3;i++)
	{
		for(j=0,y=0;j<3;j++)
		{
			for(k=0,z=0;k<3;k++)
			{
				ColorCube cc=new ColorCube(0.1);
				TransformGroup obj = new TransformGroup();
				obj.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
				Transform3D transform=new Transform3D();
				Vector3f vector=new Vector3f(x,y,z);
				transform.setTranslation(vector);
				obj.setTransform(transform);
				QuadArray qa=new QuadArray(24,QuadArray.COORDINATES|QuadArray.COLOR_3);
				qa.setColors(0, colors);
				float scaledVerts[] = new float[verts.length];
				  for (int i = 0; i < verts.length; i++)
				      scaledVerts[i] = verts[i] * (float)0.1;

				  qa.setCoordinates(0, scaledVerts);
				cc.setGeometry(qa);
				obj.addChild(cc);
				root.addChild(obj);
				System.out.println(x+" "+y+" "+z);
				z+=0.205f;
//				root.compile();
				
			}
			
			y+=0.205f;
		}
	
		x+=0.205f;
	}
	root.compile();
	return root;
}
 public RubiksCubeFair()
 {
	 setLayout(new BorderLayout());
	 GraphicsConfiguration gconf=SimpleUniverse.getPreferredConfiguration();
	 Canvas3D canvas=new Canvas3D(gconf);
	 add("Center",canvas);
	 OrbitBehavior orbit=new OrbitBehavior(canvas,OrbitBehavior.STOP_ZOOM|OrbitBehavior.REVERSE_ALL);
	 orbit.setSchedulingBounds(bounds);
	 SimpleUniverse univ=new SimpleUniverse(canvas);
	 BranchGroup bg=createSceneGraph();
	 ViewingPlatform vp=univ.getViewingPlatform();
	 univ.addBranchGraph(bg);
	 univ.getViewingPlatform().setNominalViewingTransform();
//	 vp.setNominalViewingTransform();
	 vp.setViewPlatformBehavior(orbit);
 }
public static void main(String[] args) {
    Frame frame = new MainFrame(new RubiksCubeFair(), 256, 256);
  } // end of main (method of SimpleBehaviorApp)

} // end of class SimpleBehaviorApp

