import static java.lang.Math.*;  /* Now you can use math functions without the Math. prefix */

public class Vector3D implements Cloneable     
{
  public double x,y,z;
  
  public Vector3D(double X, double Y, double Z)
  {
      this.x=X;
      this.y=Y;
      this.z=Z;
  }

//  public String toString(){/* Make it look nice to save your debugging time! */}
  
  public Vector3D(Point3D p)
  {
      this.x = p.x;
      this.y = p.y;
      this.z = p.z;
  }
  
  public Vector3D clone() //throws CloneNotSupportedException       //Change
  {
      Vector3D v0= new Vector3D(0.0,0.0,0.0); 
      v0.x=x;
      v0.y=y;
      v0.z=z;
      return v0;
  }

  public double L2norm()
  {
      return sqrt(x*x+y*y+z*z);
  }

  public double dotProduct(Vector3D v)
  {
     return v.x*this.x+v.y*this.y+v.z*this.z; 
  }

  public Vector3D crossProduct(Vector3D v)
  {
      Vector3D v0= new Vector3D(0.0,0.0,0.0);
      
      v0.x =((v.y*z)-  (v.z*y));
      v0.y= (-1)*((v.x*z) - (v.z*x));
      v0.z= ((v.x*y) - (v.y*x));
      
      return v0;
  }

  public Vector3D normalize()
  { 
      double d=this.L2norm();
      double x = this.x/d;
      double y = this.y/d;
      double z = this.z/d;
      
      return new Vector3D(x,y,z);
      
  } 
  public Vector3D transform(Matrix m)
  {
    double x1=x*m.m[0][0]+y*m.m[0][1]+z*m.m[0][2]+m.m[0][3];
    double y1=x*m.m[1][0]+y*m.m[1][1]+z*m.m[1][2]+m.m[1][3];
    double z1=x*m.m[2][0]+y*m.m[2][1]+z*m.m[2][2]+m.m[2][3];
    Vector3D resVector=new Vector3D(x1,y1,z1);
    return resVector;
  }
  //checking
  public Vector3D multiply(Vector3D vec)
  {
      double multX = this.x * vec.x;
      double multY = this.y * vec.y;
      double multZ = this.z * vec.z;
      
      return new Vector3D(multX, multY, multZ);
  }
  public String toString()
  {
      return "X: "+x+" Y: "+y+" Z: "+z;
  }
}