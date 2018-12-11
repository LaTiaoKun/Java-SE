package unit09;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Demo09P11 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
    try {
    	Socket socket = new Socket("127.0.0.1",8000);//Loop Back Address//"17.0.0.1" ="localhost"
        var in = new DataInputStream(socket.getInputStream());
        var out = new DataOutputStream(socket.getOutputStream());
        double r = 1;
   
        System.out.println("please input radius:");
        Scanner s = new Scanner(System.in);
        r = s.nextDouble();
        out.writeDouble(r);
        System.out.println("sent r"+ r);
        var area = in.readDouble();
        System.out.println("Area is:"+area);
       
        socket.close();
        		
    }
    catch(IOException ex){
    	ex.printStackTrace();
    }
	}

}
