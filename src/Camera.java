public class Camera
{
  private double xmin, xmax, ymin, ymax;    //Window dimensions
  private double fcp, bcp;  //NOT USED: front & back clippling planes
  private double aX, bX, aY, bY;
  
  public Camera(double xmin_, double xmax_, double ymin_, double ymax_)
  {
      xmin = xmin_;     
      xmax = xmax_;
      ymin = ymin_;
      ymax = ymax_; 
  }
  
  public void setViewport(int width, int height)
  {
      //Window
      double dWx = this.xmax - this.xmin;       //Ratio of Xmax and Xmin
      double dWy = this.ymax - this.ymin;       //Ratio of Ymax and Ymin
      
      //bX = dVx/dWx; aX = Vxmin - bX*Wxmin;     
      //bY = dVy/dWy; aY = Vymin - bY*Wymin;
      
      bX = width / dWx;     //width=dVx
      bY = height/ dWy;     //height=dVy
      
      aX = -(bX*xmin);      //Vxmin=0
      aY = -(bY*ymin);      //Vymin=0
  }
  
  public Vector3D getVPN()
  {
      //for parallel projection my plane of projection is: z=1 plane
      return new Vector3D(0,0,1);
  }

  protected Point3D cameraTransform(final Point3D p)
  {
      return p;
  }

  protected Point3D projectionTransform(final Point3D p)
  {
      return p;
  } 

  private final Point3D viewportTransform(final Point3D p)
  {  
      // x' = Vxmin + (dVx/dWx) *(x - Wxmin) 
      // y' = Vymin + (dVy/dWy) *(y - Wymin)
      
      //x' = aX + bX*x   for constants aX, bX, aY, bY:
      double X = aX + bX*p.x;
      
      //y' = aY + bY*y,
      double Y = aY + bY*p.y;
      
      return new Point3D(X, Y, 0);
      
  }

  public final Point3D project(final Point3D p)
  {
    //return(viewportTransform(cameraTransform(p)));            //Didn't Work   No idea Why?
      
    Point3D t=cameraTransform(p);
    t=projectionTransform(t);
    return viewportTransform(t);
  }  
}