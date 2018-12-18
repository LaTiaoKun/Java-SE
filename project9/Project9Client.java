package project9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Project9Client extends Application {


	int Order  =  0;
	boolean win = false;
    Integer yourpoint = 0;
    int oppopoint = 0;
    int yourping = 0;
    int oppoping = 0;
	Socket socket ;
	BorderPane pane = new BorderPane();
	 HBox tbox = addHBoxTop();
	 HBox cbox = addHBoxCenter();
	 HBox bbox = addHBoxBottom();
	 Scene scene = new Scene(pane);
	DataOutputStream out ;
	DataInputStream in;
    public static void main(String[] args) {
		// TODO 自动生成的方法存根
		 Application.launch(args);		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO 自动生成的方法存根
		 socket = new Socket("127.0.0.1",8000);
		 out = new DataOutputStream(socket.getOutputStream());
		 in = new DataInputStream(socket.getInputStream());
		 
		 pane.setTop(tbox);
		 pane.setCenter(cbox);
		 pane.setBottom(bbox);
		 
		 primaryStage.setScene(scene);
		 primaryStage.show();
		 
	}
	public HBox addHBoxTop()
	{
		Label l1 = new Label("opponent");
		l1.setTextFill(Color.web("#FF1493"));
		l1.setFont(new Font("", 20));
		Label l2 = new Label("\n\nPoint:"+oppopoint+"      ");
		l2.setTextFill(Color.web("#FF1493"));
		l2.setFont(new Font("", 20));
		Label l3 = new Label("\n\n\n\nPing:"+oppoping+" ms  ");
		l3.setTextFill(Color.web("#FF1493"));
		l3.setFont(new Font("", 20));
		HBox box1 =new HBox();
		Image  i1 =new Image("Project9/石头.png");
		ImageView ia = new ImageView(i1);
		Button btn1 = new Button("", ia);
		Image  i2 =new Image("Project9/剪刀.png");
		ImageView ib = new ImageView(i2);
		Button btn2 = new Button("", ib);
		Image  i3 =new Image("Project9/布.png");
		ImageView ic = new ImageView(i3);
		Button btn3 = new Button("", ic);
		box1.setPadding (new Insets(10,100,10,100));
		box1.getChildren().addAll(l1,l2,btn1,btn2,btn3,l3);
		box1.setStyle("-fx-background-color:linear-gradient(to right,#00ffff,#54FF9F);");
		box1.setSpacing(50);
		return box1;
	}
	public HBox addHBoxCenter()
	{
		HBox box1 =new HBox();
	
		box1.setPadding (new Insets(10,100,10,100));

		box1.setStyle("-fx-background-color:linear-gradient(to right,#00ffff,#54FF9F);");
		box1.setSpacing(50);
		return box1;
	}
	public HBox addHBoxBottom()
	{
		Label l1 = new Label("     You     ");
		l1.setTextFill(Color.web("#00BFFF"));
		l1.setFont(new Font("", 20));
		Label l2 = new Label("\n\nPoint:"+yourpoint+"      ");
		l2.setTextFill(Color.web("#00BFFF"));
		l2.setFont(new Font("", 20));
		Label l3 = new Label("\n\n\n\nPing:"+yourping+" ms  ");
		l3.setTextFill(Color.web("#00BFFF"));
		l3.setFont(new Font("", 20));
		HBox box1 =new HBox();
		Image  i1 =new Image("Project9/石头.png");
		ImageView ia = new ImageView(i1);
		Button btn1 = new Button("", ia);
		btn1.setOnAction(e->{
			try {
				out.writeInt(1);
				int i =in.readInt();
			     yourping = in.readInt();
				 oppoping = in.readInt();

				if(i==0)
				{
					oppopoint = oppopoint + 2;
				
		
				}
				else if(i == 1)
				{
					oppopoint = oppopoint + 1;
					yourpoint = yourpoint + 1;
				}
				else if(i == 2)
				{
					yourpoint +=2;
				
				}
				tbox = addHBoxTop();
			    bbox = addHBoxBottom();
			    pane.setTop(tbox);
			    pane.setBottom(bbox);
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		});
		
		
		Image  i2 =new Image("Project9/剪刀.png");
		ImageView ib = new ImageView(i2);
		Button btn2 = new Button("", ib);
		btn2.setOnAction(e->{
			try {
				out.writeInt(2);
				
				int i =in.readInt();
				 yourping = in.readInt();
				 oppoping = in.readInt();

				if(i==0)
				{
					oppopoint = oppopoint + 2;
		
				}
				else if(i == 1)
				{
					oppopoint = oppopoint + 1;
					yourpoint = yourpoint + 1;
				}
				else if(i == 2)
				{
					yourpoint +=2;
				}
				tbox = addHBoxTop();
			    bbox = addHBoxBottom();
			    pane.setTop(tbox);
			    pane.setBottom(bbox);
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		});
		Image  i3 =new Image("Project9/布.png");
		ImageView ic = new ImageView(i3);
		Button btn3 = new Button("", ic);
		btn3.setOnAction(e->{
			try {
				out.writeInt(3);
				int i =in.readInt();
				yourping = in.readInt();
			    oppoping = in.readInt();
				if(i==0)
				{
					oppopoint = oppopoint + 2;
		
				}
				else if(i == 1)
				{
					oppopoint = oppopoint + 1;
					yourpoint = yourpoint + 1;
				}
				else if(i == 2)
				{
					yourpoint +=2;
				}
				tbox = addHBoxTop();
			    bbox = addHBoxBottom();
			    pane.setTop(tbox);
			    pane.setBottom(bbox);
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		});
		box1.setPadding (new Insets(10,100,10,100));
		box1.getChildren().addAll(l1,l2,btn1,btn2,btn3,l3);
		box1.setStyle("-fx-background-color:linear-gradient(to right,#00ffff,#54FF9F);");
		box1.setSpacing(50);
		return box1;
	}


}
