package project5;

import java.util.Random;
import java.util.Stack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Pointfor24 extends Application {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	     Application.launch(args);
	}

	@Override
	public void start(Stage primary) throws Exception 
	{
	    Integer x1 =new Integer(0);
		Integer x2 = new Integer(0);
		Integer x3 = new Integer(0);
		Integer x4 = new Integer(0);
		 BorderPane pane = new BorderPane();
	 HBox tbox = addHBoxtop();
     HBox cbox ;
     map m1 = addHBoxCenter();
	HBox bbox = addHBoxBottom();
	HBox rbox;
	cbox = m1.hbox;
	x1 =m1.x1;
	x2 =m1.x2;
	x3 =m1.x3;
	x4 =m1.x4;
     TextField t1 = new TextField();
     TextField t2 = new TextField();
	 Button Find = new Button("我是猪，求答案");
	 Find.setOnAction(e->{
		 t1.setText("童鞋,看控制台←v←");
		  map m2 = m1;
		  Auto(t2,m2.x1,m2.x2,m2.x3,m2.x4);
	 }); 
	 
	 
	   Find.setPrefSize(150, 30);
	   Button refresh = new Button("其实你就是算不出来"); 
	   refresh.setPrefSize(150, 30);
	   refresh.setOnAction(e->{ 
		   t1.setText("");
		   t2.setText("");
		map m2 = addHBoxCenter();
		m1.hbox =m2.hbox;
		m1.x1 = m2.x1;
		m1.x2 = m2.x2;
		m1.x3 = m2.x3;
		m1.x4 = m2.x4;
		   pane.setCenter(m2.hbox);}
	   );
	   tbox.getChildren().addAll(Find, t1,refresh);
	  Label l1 = new Label("计算24点");
	  l1.setTextFill(Color.web("#33ffff"));
	  l1.setFont(new Font("Arial", 20));
	  Button view = new Button("检查"); 
	   view.setPrefSize(85, 30);
	  
	
	  view.setOnAction(e->{
		  map m2 = m1;
		  int a = math(t2,m2.x1,m2.x2,m2.x3,m2.x4);
			 System.out.println("a :"+a);
			 if(a ==24) {
				
				 t2.setText("你真TMD机智");
			 }
			 else t2.setText("who all say you 笨");
	  }
	  );
	  
	  bbox.getChildren().addAll(l1,t2,view);
	 pane.setTop(tbox);
	 pane.setCenter(cbox);
	 pane.setBottom(bbox);
	 Scene scene = new Scene(pane);
	 primary.setScene(scene);
	 primary.show();
	
   }
public void  Auto(TextField t, Integer x1,Integer x2,Integer x3,Integer x4)
{
	int x[] = {x1,x2,x3,x4};

	for(int i1 =1;i1<=13;i1++)
	{
		for(int j1 = 0;j1<4;j1++)
		{
			for(int i2 = 1; i2<=13; i2++)
			{
				for(int j2 = 0;j2<4;j2++)
				{
					for(int i3 = 1;i3<=13;i3++)
					{
						for(int j3 = 0 ; j3<4;j3++)
						{
							for(int i4 = 1 ; i4<=13;i4++)
							{
								int sum = 0;
								boolean PD = true;
								switch(j1)
								{
								case 0: sum = i1+i2;break;
								case 1: sum = i1-i2;break;
								case 2: sum = i1*i2;break;
								case 3: 
									if(i1%i2==0) {sum = i1/i2;break;}
									else {PD = false;break;}
								}
								switch(j2)
								{
								case 0: sum +=i3;break;
								case 1: sum -=i3;break;
								case 2: sum *=i3;break;
								case 3: if(sum%i3==0&&PD==true) {sum /=i3;break;}
								else {PD=false;break;}
								
								}
								switch(j3)
								{
								case 0: sum +=i4;break;
								case 1: sum -=i4;break;
								case 2: sum *=i4;break;
								case 3: if(sum%i4==0&&PD==true) {sum /=i4;break;}
								else {
									PD = false; break;
								}
								}
								for(int count1 = 0;count1<4;count1++)
								if(i1==x[count1])
								{
									
									for(int count2 = 0;count2<4;count2++)
									{
										if(i2==x[count2]&&count2!=count1)
										{
											for(int count3 = 0;count3<4;count3++)
											{
												if(i3==x[count3]&&count3!=count2&&count3!=count1)
												{
													for(int count4=0;count4<4;count4++)
													{
														if(PD==true&&sum==24&&i4==x[count4]&&count4!=count3&&count4!=count2&&count4!=count1)
														{
															String A;
															String B;
															String C;
															
															int sums=0;
															switch(j1)
															{
															case 0: A="+";sums = i1+i2;System.out.println(i1+""+A+""+i2);break;
															case 1: A="-";sums = i1-i2;System.out.println(i1+""+A+""+i2);break;
															case 2: A="*";sums = i1*i2;System.out.println(i1+""+A+""+i2);break;
															case 3: A="/";sum = i1/i2;System.out.println(i1+""+A+""+i2);break;
														
															}
															switch(j2)
															{
															case 0: B = "+";System.out.println(sums+""+B+""+i3);sums+=i3;break;
															case 1: B = "-";System.out.println(sums+""+B+""+i3);sums-=i3;break;
															case 2: B = "*";System.out.println(sums+""+B+""+i3);sums*=i3;break;
															case 3: B = "/";System.out.println(sums+""+B+""+i3);sums/=i3;break;
												
															}
															switch(j3)
															{
															case 0: C="+";System.out.println(sums+""+C+""+i4);sums+=i4;break;
															case 1: C="-";System.out.println(sums+""+C+""+i4);sums-=i4;break;
															case 2: C="*";System.out.println(sums+""+C+""+i4);sums*=i4;break;
															case 3: C="/";System.out.println(sums+""+C+""+i4);sums/=i4;break;
											
															}	
															System.out.println();
															
														}
													}
												}
											}
											
										}
									}
								}
								
							}
						}
					}
				}
			}
				
		}
	}
	
}

public int   math (TextField t, Integer x1,Integer x2,Integer x3,Integer x4)
{
	String x = t.getText().toString();
	Stack<Integer> integer = new Stack();
    Stack<Character> Character = new Stack();
	for(int i =0;i<x.length();i++)
	{
		char c = x.charAt(i);
		char cs ;
		if(c=='1')
		{
		 	cs = x.charAt((i+1));
			
			
			if(cs<='3'&& cs>='0')
			{
		       String k =String.valueOf(c)+String.valueOf(cs);
				int a = Integer.parseInt(k);
				if(a==x1||a==x2||a==x3||a==x4)
				{
				integer.push(a);
				System.out.println(a);
				i++;
				}
				else return -1;
			}
			else {
				String k =String.valueOf(c);
			      int a =Integer.parseInt(k);
			      if(a==x1||a==x2||a==x3||a==x4)
					{
					integer.push(a);
					System.out.println(a);
					}
			      else return -1;
			}
		
		}
		else if (c>='2'&&c<='9')
		{
		      String k =String.valueOf(c);
		      int a =Integer.parseInt(k);
		      if(a==x1||a==x2||a==x3||a==x4)
		      {
		      integer.push(a);
		  	System.out.println(a);
		      }
		      else return -1;
		}
		
		else if(c=='+'||c=='-'||c=='*'||c=='/')
		{
			while (!Character.isEmpty()&&priorityIsBiggerOrTheSame(Character.peek() + "", String.valueOf(c) ))
			{// 循环直到栈空或者遇到优先级较小的符号
                compute(integer, Character);
            }
			Character.push(c);
        }
		 else if (c == '(')
             Character.push('(');
         else if (c == ')')
         {// 遇到左括号，将栈内符号全部出栈参与运算
            while (Character.peek() != '(')// 循环直到遇到左括号
            	 compute(integer, Character);
             Character.pop();// 左括号出栈
         }
		}
	 while (!Character.isEmpty())// 最后将所有的符号出栈参与运算
	 { 
		 compute(integer, Character);
	 }
	 
	 int e = integer.pop();

	return e;
}
public HBox addHBoxBottom()
{
	HBox hbox =new HBox();
	hbox.setPadding (new Insets(30,50,30,50));
	hbox.setStyle("-fx-background-color:linear-gradient(to top,#FFFF00,#98FB98);");
	hbox.setSpacing(50);
	return hbox;
}

public map addHBoxCenter() 
{
	HBox hbox =new HBox();
	map m1 = new map(); 
	hbox.setPadding (new Insets(50,50,50,50));
	hbox.setSpacing(50);
	String[] imgSrcs = new String[52];
	for(int i = 1;i<=52;i++)
	{
		Integer j = new Integer(i); 
		imgSrcs[i-1] = j.toString();
	}
	Random r = new Random();
	
	int flag1 = r.nextInt(52);
	int flag2;
	int flag3;
	int flag4;
	if(flag1<14)
	{
		
		m1.x1 = flag1;
		System.out.println("x1 "+m1.x1);
	}
	else 
	{
		Integer temp = new Integer(flag1%13);
		m1.x1 = temp;
		if(m1.x1==0)
		{
			m1.x1 =13;
		}
		System.out.println("x1 "+m1.x1);
		
	}
	do {
		 flag2 = r.nextInt(52);
		 if(flag2<14)
		 {
			 Integer temp = new Integer(flag2);
             m1.x2 = temp;
			 System.out.println("x2 "+m1.x2);
		 }
			else 
			{
				Integer temp = new Integer(flag2%13);
				m1.x2 = temp;
				if(m1.x2==0)
				{
					m1.x2=13;
				}
			
				System.out.println("x2 "+m1.x2);
			}		 
	}while(flag2==flag1);
	do {
		 flag3 = r.nextInt(52);
		 if(flag3<14)
			{	
			 Integer temp = new Integer(flag3);
			  m1.x3 = temp;
			System.out.println("x3 "+m1.x3);
			}
			else 
			{
				Integer temp = new Integer(flag3%13);
				m1.x3 = temp;
				if(m1.x3==0)
				{
					m1.x3 =13;
				}
			
				System.out.println("x3 "+m1.x3);
			}
	}while(flag3==flag1||flag3==flag2);
	do {
		 flag4 = r.nextInt(52);
		 if(flag4<14)
		 {
			 Integer temp = new Integer(flag4);
				m1.x4 = temp;
			System.out.println("x4 "+m1.x4);
			}
			else 
			{
				Integer temp = new Integer(flag4%13);
				m1.x4 = temp;
				if(m1.x4==0)
				{
					m1.x4 = 13;
				}
				
				System.out.println("x4 "+m1.x4);
				}
	}while(flag4==flag1||flag4==flag2||flag4 ==flag3);
	Image  i1 =new Image("Project5/card/"+imgSrcs[flag1-1] +".png");
	ImageView ia = new ImageView(i1);
	Image i2 =new Image("Project5/card/"+imgSrcs[flag2-1]+".png");
	ImageView ib = new ImageView(i2);
	Image i3 =new Image("Project5/card/"+ imgSrcs[flag3-1]+".png");
	ImageView ic = new ImageView(i3);
	Image i4 =new Image("Project5/card/"+ imgSrcs[flag4-1]+".png");
	ImageView id = new ImageView(i4);
	hbox.setStyle("-fx-background-color:linear-gradient(to top,#98FB98,#33ffff);");
	  hbox.getChildren().addAll(ia,ib,ic,id);
	  m1.hbox =hbox;
	return m1;
}
public HBox addHBoxtop(){
   HBox hbox = new HBox();
   hbox.setPadding(new Insets(30, 20, 30, 20)); 
   hbox.setSpacing(50); 
	 
	   hbox.setStyle("-fx-background-color:linear-gradient(to top,#33ffff,#BF3EFF);");
	
      
   
   return hbox;
}
public static void compute(Stack<Integer> value, Stack<Character> operation) {
    int v1 = value.pop();
    int v2 = value.pop();
    char op = operation.pop();
    switch (op) {
        case '+':
            value.push(v2 + v1);
            break;
        case '-':
            value.push(v2 - v1);
            break;
        case '*':
            value.push(v2 * v1);
            break;
        case '/':
            value.push(v2 / v1);
            break;
    }
}
public static boolean priorityIsBiggerOrTheSame(String a, String b) {
    String s = "+- */";
    return (s.indexOf(a) - s.indexOf(b)) >= 2;

}
}

class map{
	public HBox hbox;
	public int x1;
	public int x2;
	public int x3;
	public int x4;
}
