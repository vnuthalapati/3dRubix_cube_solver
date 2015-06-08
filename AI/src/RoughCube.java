import java.applet.*;
import java.awt.*;

import javax.media.j3d.*;
import javax.vecmath.*;

import com.sun.j3d.utils.applet.*;
import com.sun.j3d.utils.behaviors.vp.*;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;

public class RoughCube extends Applet
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

	TransformGroup tg[]=new TransformGroup[27];
	TransformGroup mtg[]=new TransformGroup[6];
public Bounds createApplicationBounds()
{
	return new BoundingSphere(new Point3d(0.205,0.205,0.205),100.0);
}
public void init()
{
	for(int i=0;i<27;i++)
		tg[i]=new TransformGroup();
}
public void combine()
{
	
}
public BranchGroup createSceneGraph()
{
	this.init();
	BranchGroup root=new BranchGroup();
	float y;
	float z;
	float x=y=z=0.0f;
	int count=0;
//	System.out.println(root.toString());
	for(i=0,x=0;i<3;i++)
	{
		for(j=0,y=0;j<3;j++)
		{
			for(k=0,z=0;k<3;k++)
			{
//				System.out.println(root.toString());
				ColorCube cc=new ColorCube(0.1);
//				System.out.println(root.toString());
				TransformGroup obj = new TransformGroup();
//				System.out.println(root.toString());
				tg[count].setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
//				System.out.println(root.toString());
				Transform3D transform=new Transform3D();
				Vector3f vector=new Vector3f(x,y,z);
				transform.setTranslation(vector);
				tg[count].setTransform(transform);
				QuadArray qa=new QuadArray(24,QuadArray.COORDINATES|QuadArray.COLOR_3);
				qa.setColors(0, colors);
				float scaledVerts[] = new float[verts.length];
				  for (int i = 0; i < verts.length; i++)
				      scaledVerts[i] = verts[i] * (float)0.1;

				  qa.setCoordinates(0, scaledVerts);
				cc.setGeometry(qa);
				tg[count].addChild(cc);
//				System.out.println(root.toString());
				root.addChild(tg[count++]);
//				System.out.println(root.toString());
				System.out.println(x+" "+y+" "+z);
				z+=0.205f;
//				root.compile();
				
			}
			
			y+=0.205f;
		}
	
		x+=0.205f;
	}
	root.compile();
//	System.out.println(root.toString());
	return root;
}
 public RoughCube()
 {
	 setLayout(new BorderLayout());
	 GraphicsConfiguration gconf=SimpleUniverse.getPreferredConfiguration();
	 Canvas3D canvas=new Canvas3D(gconf);
	 add("Center",canvas);
	 OrbitBehavior orbit=new OrbitBehavior(canvas,OrbitBehavior.STOP_ZOOM|OrbitBehavior.REVERSE_ALL|OrbitBehavior.KEY_LISTENER);
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
    Frame frame = new MainFrame(new RoughCube(), 256, 256);
  } // end of main (method of SimpleBehaviorApp)

} // end of class SimpleBehaviorApp

