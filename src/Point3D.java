public class Point3D
{
  public double x,y,z;

  public Point3D(double X,double Y,double Z)
  {
      this.x=X;
      this.y=Y;
      this.z=Z;
  }
  public Point3D()
  {
      x=0;
      y=0;
      z=0;
  }

  public double distance(Point3D p)
  {
      double d =Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y)+(p.z-z)*(p.z-z));
      return d;
  }
  
public Point3D transform(Matrix m)
{
    //Point3D resPoint=new Point3D();
    double x1=x*m.m[0][0]+y*m.m[0][1]+z*m.m[0][2]+m.m[0][3];
    double y1=x*m.m[1][0]+y*m.m[1][1]+z*m.m[1][2]+m.m[1][3];
    double z1=x*m.m[2][0]+y*m.m[2][1]+z*m.m[2][2]+m.m[2][3];
    
    Point3D resPoint=new Point3D(x1,y1,z1);
    return resPoint;
}

public Vector3D vector(Point3D p)
{
    double x1=p.x-x;
    double x2=p.y-y;
    double x3=p.z-z;
    
    Vector3D v1=new Vector3D(x1,x2,x3);
    return v1;
}
public Vector3D vector()
    {
        return new Vector3D(this.x, this.y , this.z);
    }


public static Vector3D faceNormal(Point3D p1, Point3D p2, Point3D p3)
{
    double x1=p2.x-p1.x;
    double y1=p2.y-p1.y;
    double z1=p2.z-p1.z;
    Vector3D n1=new Vector3D(x1,y1,z1);
    
    double x2=p3.x-p1.x;
    double y2=p3.y-p1.y;
    double z2=p3.z-p1.z;
    Vector3D n2=new Vector3D(x2,y2,z2);
    
    Vector3D n3=new Vector3D(0,0,0);
    n3=n1.crossProduct(n2);
    return n3;   
}

public static boolean isFrontFace(Point3D p1, Point3D p2, Point3D p3, Vector3D vpn){
       
        Vector3D faceNormal = Point3D.faceNormal(p1, p2, p3);
         
        double res=faceNormal.dotProduct(vpn);
        if(res>0)
        {
        return (true);
        }
        else return(false);
    }
public Point3D subtract(Point3D p)
    {
        return new Point3D(this.x - p.x, this.y - p.y, this.z - p.z);
    }
  public String toString()
  {
      return "X: "+x+" Y: "+y+" Z: "+z;
  }
  
}