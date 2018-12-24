package project6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Project6 
{

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	    Triangle T1 = new Triangle(1,1.5,1,"yellow",true);
	    System.out.println(T1.toString()+"\nArea:"+T1.getArea()+"\nPerimeter:"+T1.getPerimeter());

}
}
class Triangle extends GeometricObject
{
	private double side1,side2,side3;

	public Triangle()
	{
		side1 = 1.0;
		side2 = 1.0;
		side3 = 1.0;
	}
	public Triangle(double side1,double side2,double side3,String color,boolean fill)
	{
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.color = color;
		this.fill = fill;
	}
	@Override
	public double getArea()
	{
		double p = getPerimeter()/2;
		return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
	}
	@Override
	public double getPerimeter()
	{
		return side1+side2+side3;
	}
	public String toString()
	{
		return (super.toString()+" side1: "+side1+"\n"+" side2: "+side2+"\n"+" side3: "+side3);
	}
}