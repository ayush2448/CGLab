import java.awt.Color;

public class Face
{
  public int[] index;
  public Color color;

  public Face(int[] i, Color c)
  {
      index=i;
      color=c;
  }

  public String toString()
  {
      String value1="";
      for(int i=0; i<index.length; i++)
      {
        value1 +=" " +index[i];
      }
      int r = color.getRed();
      int b = color.getBlue();
      int g = color.getGreen();
      return value1+" Colour-> R: "+r+" G: "+g+" B:"+b;
  }
}