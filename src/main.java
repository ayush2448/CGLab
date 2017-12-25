import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class main 
{
    @SuppressWarnings("empty-statement")
    public static void main(String[] args)
    {
        String msg;
        
//        //Point 3D
//        Point3D a,b,c;
//        a = new Point3D(1,0,0);
//        b = new Point3D(5,0,0);
//        c=new Point3D();
//        msg=c.toString();
//        System.out.println(msg);
//        
//        //Distance
//        double dist=a.distance(b);
//        System.out.println("Distance: "+dist+" Units");
//        
//        //Vector3D
//        Vector3D v1,v2,v3;
//        v1 = new Vector3D(1,2,3);
//        msg=v1.toString();
//        System.out.println(msg);
//        
//        v2 = new Vector3D(4,5,6);
//        msg=v2.toString();
//        System.out.println(msg);
//        
//        //Clone
//        try {
//            v3 = v1.clone();
//            msg=v3.toString();
//            System.out.println(msg);
//        System.out.println(msg);
//        } catch (CloneNotSupportedException ex) {
//            System.out.println("Can't Clone ERROR: "+ex);
//        }
//        
//        //Norm
//        double norm=v1.L2norm();
//        System.out.println("Norm: for V1 "+norm);
//        
//        //Dot Product
//        double dot=v1.dotProduct(v2);
//        System.out.println("DotProduct: "+dot);
//        
//        //Cross Product
//        Vector3D v4=v1.crossProduct(v2);
//        msg=v4.toString();
//        System.out.println("Cross-Product: "+msg);
//        
//        //Normalize
//        v1.normalize();
//        v2.normalize();
//        //v3.normalize();
//        v4.normalize();
        
        
        //Scanner
        //System.out.println("Enter the FIlename");
        //Scanner sc=new Scanner(System.in);
        //String fileName=sc.next();
//        System.out.println("Loading Object Files");
//        String[] fileName = {"C:\\cube.dat","C:\\pyramid.dat"};
//        
//        for(int i=0;i<fileName.length;i++)
//        {
//        GObject cube=new GObject(fileName[i]);
//        }

        String op=null;
        int option=Integer.parseInt(JOptionPane.showInputDialog("Press 1: For Parallel Animation and Press 2: For Perspective Animation"));
        if(option==1)
            {
                new ParallelAnimator().loop();
            }
        else if(option==2)
        new PerspectiveAnimator().loop();
        else
            JOptionPane.showMessageDialog(null,"Exception");
        
    }
    
}
