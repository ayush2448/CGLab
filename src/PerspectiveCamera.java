import static java.lang.Math.cos;
import static java.lang.Math.sin;
public class PerspectiveCamera extends Camera
{
  public Point3D cop=new Point3D(0,0,-4);           //centre of projection
  public Point3D vrp=new Point3D(0,0,0);            //view reference point
 
  public Vector3D vpn=new Vector3D(0,0,0);          //view Plane normal
  public Vector3D vuv=new Vector3D(0,1,0);          //View Up Vector

  public PerspectiveCamera(double xmin_, double xmax_, double ymin_, double ymax_)
  {
      super( xmin_,  xmax_,  ymin_,  ymax_);
  }
  
  public Vector3D getVPN()  
  {
      return (vpn.normalize().multiply(cop.vector()));                          //multiply cop and vpn
  }

  protected Point3D projectionTransform(final Point3D p)
  {
  
      double x1=cop.x -p.x;
      double y1=cop.y-p.y;
      double z1=cop.z-p.z;
      Vector3D dSubVector = new Vector3D(x1,y1,z1);
     
      Vector3D d = dSubVector.clone();
     
      //Transforming 
      d.x = cos(vpn.y) * (sin(vpn.z)*dSubVector.y + cos(vpn.z) * dSubVector.x) - sin(vpn.y) * dSubVector.z;
      d.y = sin(vpn.x) * (cos(vpn.y)*dSubVector.z + sin(vpn.y) * (sin(vpn.z) * dSubVector.y + cos(vpn.z)*dSubVector.x)) + cos(vpn.x)*(cos(vpn.z)*dSubVector.y - sin(vpn.z)*dSubVector.x); 
      d.z = cos(vpn.x) * (cos(vpn.y)*dSubVector.z + sin(vpn.y) * (sin(vpn.z) * dSubVector.y + cos(vpn.z)*dSubVector.x)) - sin(vpn.x)*(cos(vpn.z)*dSubVector.y - sin(vpn.z)*dSubVector.x);

      double TransformedX = d.x/d.z;
      double TransformedY = d.y/d.z;
      return new Point3D(TransformedX, TransformedY, d.z);
  }
  
  protected Point3D cameraTransform(final Point3D p)
  {
      return p;
  }
  public void setupCOP(Point3D cop_)        //setups Center of the projection
  {
      this.cop = cop_;
  }     

  public void setupUVN(Point3D vrp_, Vector3D vpn_, Vector3D vuv_)          //Setups VRP,VPN,VUV
  {
      this.vrp =vrp_;
      this.vpn = vpn_;
      this.vuv = vuv_;      
  }
}



