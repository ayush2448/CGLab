import java.util.Scanner;
import java.io.*;
import java.awt.Color;

public class GObject
{
  public Point3D[] vertex;
  public Face[] face;
  
  public GObject(Point3D[] v, Face[] f)
  {
      vertex=v;
      face=f;
  }

  public GObject(String fileName)
  {
      try{
          Scanner input=new Scanner(new FileReader(fileName));
          System.out.println(fileName+" File Opened");
          
          //Get no. of Verices for the loop
          int numVert =input.nextInt();
          //System.out.println(numVert);        //For debug
                  
          double x,y,z;
          float r,g,b;
          Point3D[] vtx = new Point3D[numVert];
          for(int i=0; i<vtx.length; i++) 
          {
                //Get values of all the Vertices in the loop
                x=input.nextDouble();
                y=input.nextDouble();
                z=input.nextDouble();
                vtx[i]=new Point3D(x,y,z);              
          }
          
          //Get no. Faces for the loop
          int numOfFaces=input.nextInt();
          //System.out.println(numOfFaces);     //For debug

          //Creating Face objects
          Face[] numFace = new Face[numOfFaces];           
          for(int i=0; i<numFace.length; i++)
          {
              //Geting no. of Indexes in a face
              int numVertFaces=input.nextInt();
              //System.out.println(numVertFaces);       //For debug
                
              int[] vertexIndexes=new int[numVertFaces];
              for(int j=0;j<numVertFaces;j++)
                {
                    //Getting the Indexes 
                    int ind=input.nextInt();
                    vertexIndexes[j]=ind;
                    
                }   //similarly getting color
                    r=input.nextFloat();
                    g=input.nextFloat();
                    b=input.nextFloat();

                Color newColors = new Color(r, g, b);
                
                //Creating the Face Object
                numFace[i] = new Face(vertexIndexes, newColors);
                String m1=numFace[i].toString();
                System.out.println(m1);
               
            }
          input.close();            //closing IO connections
          vertex=vtx;
          face=numFace;
      }
      catch(IOException e) 
      {
         System.out.println("Please correct the file Path from the ParallelAnimator.java --public String[] files-- attribute"); 
         System.out.println("Error due too absolute path name"); 
      }
  }
  
  public void transform(Matrix m)
  {
      int len= vertex.length;
      for(int i=0;i<len;i++)
      {
          vertex[i]=vertex[i].transform(m);
      }
  }
}