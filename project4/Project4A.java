package project4;

import java.awt.Color;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Project4A extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO 自动生成的方法存根
		Pane pane = new Pane();
		   Rect r1 = new Rect(200.4,108.8,"white");
			r1.draw(pane);
			r1.getimformation();
			System.out.println( "Area:"+r1.getArea()+"Perimeter:"+r1.getPerimeter());
		Scene scene = new Scene(pane,1240,720);
		primaryStage.setTitle("Rectangle");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
      Application.launch(args);
	}

}
class Rect {
	private double weight;
	private double hight;
	private String color;
	public Rect()
	{
		weight = 1;
		hight = 1;
		color = "white";
	}
	public Rect (double w,double h,String c)
	{
		weight = w;
		hight = h;
		color = c;
	}
	public void getimformation()
	{
		System.out.println("weight:"+weight+"hight:"+hight+"color:"+color);
	}
	public double getArea()
	{
		return weight*hight;
	}
	public double getPerimeter()
	{
		return 2*(weight+hight);
	}
	public void draw(Pane pane)
	{
		Rectangle r1 =new Rectangle(10,10,weight,hight);
	//	Paint p1 = null ;
	  //	r1.setFill(p1);
			pane.getChildren().add(r1);
	}
	
}