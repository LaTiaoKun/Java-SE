package hello;


import java.util.Date;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MyClock extends Application{

	@Override
	public void start(Stage primary)
	{
		Clock clock = new Clock();
		Scene scene = new Scene(clock,400,300);
		Timeline timeline=new Timeline();
		timeline.getKeyFrames().add(new KeyFrame(Duration.millis(5),e->{clock.paint();}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		clock.setStyle("-fx-background-color:linear-gradient(to top,#00ffff,#54FF9F)");
	        primary.setTitle("My Clock");
	        primary.setScene(scene);
	        primary.centerOnScreen();
	        primary.show();
	   

	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
                Application.launch(args);
	}

}

class Clock extends StackPane{


	private int hour;
	private int min;
	private int sec;
	private boolean b = false ;
	private Label l1 = new Label(hour+":"+min+":"+sec+"");
	private Font font = new Font("华文雅黑",40);
	public Clock() {
	Date date = new Date();
	hour = date.getHours();
        min = date.getMinutes();
        sec = date.getSeconds();
        this.getChildren().add(l1);
        this.setAlignment(Pos.CENTER);
	}
	public int getHour(boolean b)
	{
		if(b == true)
		{
		return hour;
		}
		else 
			{
			  if(hour>=12)
				  return (hour-12);
			 
			  else return hour;
			}
	}
	public void setHour(int hour)
	{
		this.hour =hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	public void paint()
	{
		Date date = new Date();
		hour = date.getHours();
	        min = date.getMinutes();
	        sec = date.getSeconds();
		l1.setText(hour+":"+min+":"+sec+"");
		l1.setFont(font);
	}
}
