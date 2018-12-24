package project7;

import project6.GeometricObject;

public class Project7B {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
      Octagon obj1 = new Octagon(5,"blue",true);
      Octagon obj2 = obj1.clone(obj1);
      if(obj1.compareTo(obj2)==1)
       System.out.println("相同"+"\n");
      else
    	  System.out.println("不相同"+"\n");
       System.out.println(obj1.toString());
       System.out.println(obj2.toString());
	}

}
class Octagon extends GeometricObject implements  Comparable<Octagon>,Cloneable
{

	private int []side = new int [8];
	public Octagon()
	{
		for(int i : side)
		{
			i = 0;
		}
		this.color = "white";
		this.fill =false;
	}
	public Octagon(int a ,String color, boolean fill)
	{
		for(int i = 0;i<5;i++)
		{
			side[i] = a;
		}
		this.color = color;
		this.fill = fill;
	}
	
	public Octagon clone(Octagon obj1)
	{
		Octagon obj2 = new Octagon(obj1.side[0],obj1.color,obj1.fill);
		return obj2;		
				
	}
	@Override
	public int compareTo(Octagon obj2) {
		if(obj2 instanceof GeometricObject)
		{
			if(this.side[0]==obj2.side[0]&&this.fill==obj2.fill&&this.color==obj2.color)
				return 1;
			else return 0;
		}
		// TODO 自动生成的方法存根
		else return 0;
	}
	@Override
	public String toString()
	{
		return (super.toString()+" side: "+side[0]+"\n");
		
	}
	
}