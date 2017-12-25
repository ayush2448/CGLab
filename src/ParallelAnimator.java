import java.awt.*;

public class ParallelAnimator extends Animator
{
  private Scene scene;
  protected Camera camera;
  public String[] files={"C://octahedron.dat"};     //CHANGE HERE
  //Following dat files are there
  //Cube, Pyramid
  //Tetrahederon
  //xyPlane , xzPlane ,yzPlane
  
  public ParallelAnimator()
  {
                                                                 
    scene=new Scene(files);                                                     //inputing files to the scene
    setupCamera();
                                          
  }

  protected void setupCamera()
  {
    camera= new Camera(-5,5,-5,5);
  }
  
  protected void animate(Graphics g)
  {
    camera.setViewport(getWidth(),getHeight());                                 //Set viewport
     if(g==null || scene==null || camera==null)                                 //if either g,scene or camera is null then return
      return;

    Matrix mX=new Matrix();                                                     //Creating the new matrix 
    mX.setRotationX(0.08);                                                      //Rotation along X cordinate
    
    Matrix mY=new Matrix();                                         
    mY.setRotationY(0.2);                                                       //Rotation along Y cordinate
    
    Matrix mZ=new Matrix();
    mZ.setRotationZ(0.03);                                                      //Rotation along Z cordinate
    
    scene.transform(mZ.multiply(mY.multiply(mX)));                              //Transfromation matrix for all the rotations Matrix Z (Matrix Y * Matrix X)

    scene.draw(camera,g);                                                       //draw with camera and g
  }

  public static void main(String[] args) 
  {
    new ParallelAnimator().loop();                                              //START
  }

  
}