public class PerspectiveAnimator extends ParallelAnimator
{
  public PerspectiveAnimator()
  {
      
  }
  protected void setupCamera()
  {
    camera= new PerspectiveCamera(-5,5,-5,5);
    ((PerspectiveCamera)camera).setupUVN(new Point3D(0,0,0), new Vector3D(0,0,1), new Vector3D(0,1,0));         //Setting up UVN
    ((PerspectiveCamera)camera).setupCOP(new Point3D(0,0,3));                                                   //Setting up COP
  }
  
  public static void main(String[] args)
  { 
    new PerspectiveAnimator().loop();
    
  }
}