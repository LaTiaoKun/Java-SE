package unit09;

import java.io.*;

import java.net.*;

public class Demo09P12 {
  public static void main (String [] args)
  {
	  try {
		  
		  var server =new ServerSocket(8888);
		  System.out.println("Listening on port 8888");
		  
		  var socket = server.accept();
		  System.out.println("Client connected");
		  double r;
		  var in = new DataInputStream(socket.getInputStream());
		  var out =new DataOutputStream(socket.getOutputStream());
	       while(true){
		  r =in.readDouble();
		  if(r<0)break;
		  var area =r*r*Math.PI;
		  out.writeDouble(area);
		  System.out.println("\tRadius is"+r);
		  System.out.println("\tarea is "+area);
		  }
		  socket.close();
		  System.out.println("server close");
	  }catch(IOException ex)
	  
	  {
		  ex.printStackTrace();
	  }
  }
}
