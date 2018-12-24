package project6;

public class GeometricObject {
   protected String color;
   protected boolean fill;
   public GeometricObject() {
	  color = "white";
	  fill = false;
   }
   public GeometricObject(String color,boolean fill)
   {
	   this.color=color;
	   this.fill = fill;
   }
   public double getArea() 
   {
	  return 0;
   }
   public double getPerimeter()
   {
	   return 0;
   }
   
   public String toString()
   {
	   String s = this.getClass().getName();
	   return (s+" : \n"+ " color: " +color+" \n" + " fill: " + fill+"\n");
   }
}
