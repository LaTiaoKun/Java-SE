package unit09;

import java.io.*;

import java.net.*;

public class Demo09T11server {
  public static void main (String [] args)
  {
	  try {
		  
		  var server =new ServerSocket(6666);
		  System.out.println("Listening on port 6666");
		  var socket = server.accept();
		  var in = new DataInputStream(socket.getInputStream());
		  var out = new DataOutputStream(socket.getOutputStream());
		  Double x = in.readDouble();
		  String s = x.toString();
		  out.writeBytes(s);
		  server.close();
		  System.out.println("server closed");
		  
	  }catch(IOException ex)
	  
	  {
		  ex.printStackTrace();
	  }
  }
}
