import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Animator extends JFrame
{
  private static final int WIDTH=800;                   //Window length
  private static final int HEIGHT=600;                  //Window breadth
  private static final int INTERVAL=50;                 //Animation speed is lower when interval is greater
  private BufferedImage image;
  
  public Animator()
  {
    setSize(WIDTH,HEIGHT);                                  //Set the size of the window
    setDefaultCloseOperation(this.EXIT_ON_CLOSE);           //Close on exit
    setVisible(true);                                       //Set the window visible
  }

  private int R;
  protected void animate(Graphics g)
  {
    g.setColor(Color.RED);                                                                  //Sets the color of the g object
    R=R>20?0:R+1;                                                                           //Used for the animation
    g.fillPolygon(new int[]{100,WIDTH/2,R*3},new int[]{100,HEIGHT/2,R*3},3);                //creates the red polygon
  }

  protected void loop()
  {
    while(true)                                                                                     //creates an infinite loop
    {
      image=new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);                 //Sets the window
      Graphics2D g2 = image.createGraphics();                                                       //Creates the window 
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);       //smothes the animation
      g2.setColor(Color.WHITE);                                                                     //Object color acts as the background image
      g2.fillRect(0,0,getWidth(),getHeight());                                                      //filing the background withe the color

      animate(g2);                          //get the backround which is the g2

      ((Graphics2D)getGraphics()).drawImage(image,0,0,null);        //draws images
      paint(getGraphics());                                         //Refresh the visible area
      try {Thread.sleep(INTERVAL);}                                 //Slow the speed of refreshes by using a thread with an interval
      catch(InterruptedException e){}                               //catch any exception
     
    }
  }

  public final void paint(Graphics g){}             //used to print every changes, every time a change is made
  
  public static void main(String[] args) 
  {
    new Animator().loop();                          //loop the animator 
  }
}
