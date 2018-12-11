package unit09;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Demo09T10Client {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
    try {
    	Socket socket = new Socket("127.0.0.1",6666);//Loop Back Address//"127.0.0.1" ="localhost"
        var out = new DataOutputStream(socket.getOutputStream());
        double r = 1;
        while(r>0)
        {
        System.out.println("please input double:");
        Scanner s = new Scanner(System.in);
        r = s.nextDouble();
        out.writeDouble(r);
        }
        socket.close();
        		
    }
    catch(IOException ex){
    	ex.printStackTrace();
    }
	}

}
