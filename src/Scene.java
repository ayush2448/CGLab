
import java.awt.*;

public class Scene {

    private GObject[] obj;

    public Scene(String[] fileName) {
        //As fileName and GObject are the same so, obj.length should be equal to fileName.length
        obj = new GObject[fileName.length];  //2

        //Open all the GObjects for the input.
        for (int i = 0; i < obj.length; i++) //2
        {
            obj[i] = new GObject(fileName[i]);
        }
    }

    public void transform(Matrix m) {
        for (int i = 0; i < obj.length; i++) {
            obj[i].transform(m);
        }
    }
    //Camera Class

    public void draw(Camera c, Graphics g) {
        for (int i = 0; i < obj.length; i++) //2
        {
            //Array of Vertiecs of type Point3D
            Point3D[] vertices = obj[i].vertex;                                 //Vertices

            //For each Object has faces, loop through
            for (int j = 0; j < obj[i].face.length; j++) //6
            {
                Face thisFace = obj[i].face[j];                                 //Current Face

                int[] verticesIndicesOfThisFace = thisFace.index;
                int numVtxInThisFace = verticesIndicesOfThisFace.length;        //No. of vertices in the current face
                //System.out.println("Test"+numVtxInThisFace);                  //Debug

                //Each face as N, vertices, keep order and map to an array.
                int[] xPoints = new int[numVtxInThisFace];                      //An array to store the values of the vertices' Indices
                int[] yPoints = new int[numVtxInThisFace];

                for (int k = 0; k < numVtxInThisFace; k++) {
                    Point3D vertex = vertices[verticesIndicesOfThisFace[k]];
                    vertex = c.project(vertex);
                    
                    //Adding values to xPoints and yPoints and coverting them to integer 
                    xPoints[k] = (int) vertex.x;
                    yPoints[k] = (int) vertex.y;
                }

                //Only three points are required to check the orientation of the plane 
                Point3D tfP1 = c.projectionTransform(vertices[verticesIndicesOfThisFace[0]]);
                Point3D tfP2 = c.projectionTransform(vertices[verticesIndicesOfThisFace[1]]);
                Point3D tfP3 = c.projectionTransform(vertices[verticesIndicesOfThisFace[2]]);
                boolean isFrontFace = Point3D.isFrontFace(tfP1, tfP2, tfP3, c.getVPN());

                //Setting the color
                g.setColor(thisFace.color);

                if (isFrontFace) {
                    g.fillPolygon(xPoints, yPoints, numVtxInThisFace);     //Same as animator (xPoints,yPoints, size of (xPoints=yPoints)) // (int[],int[],int) 
                }
            }

        }
    }
}
