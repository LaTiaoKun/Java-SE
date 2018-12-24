package project1;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Project1 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO 自动生成的方法存根
		TextField  t1 = new TextField();
		TextField  t2 = new TextField();
		TextField  t3 = new TextField();
		TextField  t4 = new TextField();
		Car c1 = new Car(100);
		Car c2 = new Car(250);
		Car c3 = new Car(400);
		Car c4 = new Car(550);
	   // Line l1 = new Line(800,150,0,150);
	    //Line l2 = new Line(100,800,0,800);
	    //Line l3 = new Line(8,450,0,450);
	//	StackPane pane1 = new StackPane(); 
		GridPane pane =new GridPane();
//		pane.setHgrow(new Label("Car1's SPEED"), 1);
		
//		pane.setAlignment(Pos.CENTER);
		pane.add(new Label("Car1's SPEED"),0,0);
		pane.add(t1,1,0);
		pane.add(new Label("Car2's SPEED"),2,0);
		pane.add(t2,3,0);
		pane.add(new Label("Car3's SPEED"),4,0);
		pane.add(t3,5,0);
		pane.add(new Label("Car4's SPEED"),6,0);
		pane.add(t4,7,0);
	//	Line l4 = new Line(10,10,10,30);
		
		pane.add(c1,0,0);
		pane.add(c2,0,0);
		pane.add(c3,0,0);
		pane.add(c4,0,0);
		pane.setStyle("-fx-background-color:linear-gradient(to top,#00ffff,#fff6af);");
		Button OK = new Button("   OK   ");
		OK.setStyle("-fx-background-color:linear-gradient(to top,#00ffff,#fff6af);");
		OK.setOnAction(
				handlerOK->
				{
					int a1 = 0;
					int a2 = 0;
					int a3 = 0;
					int a4 = 0;
					
					
					c1.setSpeed(a1 = Integer.parseInt(t1.getText().trim()));
					c2.setSpeed(a2 = Integer.parseInt(t2.getText().trim()));
					c3.setSpeed(a3 = Integer.parseInt(t3.getText().trim()));
		   			c4.setSpeed(a4 = Integer.parseInt(t4.getText().trim()));
		         	
			 
//			        System.out.println(c1.Speed);
		 	    	c1.run(pane);
		 	    	c2.run(pane);
		 	    	c3.run(pane);
		 	        c4.run(pane);
		 	    }
				
		 	    
     	);
		
		pane.add(OK,8,0);
		Scene scene  = new Scene(pane,1000,600);
		primaryStage.setTitle("Racing car");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
	Application.launch(args);

	}
	
}
class Car extends Pane
{
	public int Speed;
	private int x;
	private int y;
    private boolean win;
    Image i1 = new Image("project1/car.gif",175,175,false,false);
    ImageView  i= new ImageView(i1);  
     

    public Car()
    {   
    	Speed = 0;
    	x = 0;
    	//y = 0;
    	win = false;
    }
    public Car(int y)
    {   
    	Speed = 0;
    	x = 0;
    	this.y = y;
    	win = false;
    }
    public void setSpeed(int speed)
    {
    	this.Speed = speed;
    }
    public void run(GridPane pane)
    {
    	//x = (int)(x + 0.1*Speed);
    	pane.getChildren().add(i);
    	try{PathTransition pt = new PathTransition(Duration.millis(1000000/Speed*3),new Line(1000,y,50,y),i);
        pt.setCycleCount(1);
        pt.play();
    	}
    	catch(Exception e)
    	{
    		System.out.println("Speed不能为0");
    	}
    }
    public boolean getwin()
    {
    	return win;
    }
	public void win()
	{
		if(x>=1000) 
		{
		   win = true;	
		}
	}
}
