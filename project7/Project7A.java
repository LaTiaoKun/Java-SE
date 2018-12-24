package project7;

import project6.GeometricObject;

public class Project7A {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
     GeometricObject [] geometricObject = { new Square(),new Square(), new Square(), new Square(), new Square() };
     for(int i=0;i<5;i++)
     {
    	 if(geometricObject[i] instanceof GeometricObject)
    	 {
    		Square s =  (Square) geometricObject[i];
    		s.howToColor();
    	 }
     }
	}

}
interface Colorable
{
	void howToColor();
}
class Square extends GeometricObject implements Colorable
{    public void howToColor()    
{        
	System.out.println("Color 4 sides");
}
}

