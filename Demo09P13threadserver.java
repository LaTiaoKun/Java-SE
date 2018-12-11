package unit09;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo09P13threadserver {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
      try {
    	  ExecutorService executor = Executors.newCachedThreadPool();
    	  ServerSocket  ss = new ServerSocket(8000);
    	  System.out.println("Listening on port 8000");
    	  while(true)
    	  {
    		  Socket socket = ss.accept();
    		  System.out.println("Thread for"+socket.getInetAddress().getHostName()+"port"+socket.getPort());
			executor.execute(new ServerThread(socket));
    	  }
      }catch(Exception e)
      {
    	  e.getStackTrace();
      }
}
	static class ServerThread implements Runnable {

		private Socket socket;

		ServerThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			while (true) {
				try {
					var in = new DataInputStream(socket.getInputStream());
					var out = new DataOutputStream(socket.getOutputStream());
					double r = in.readDouble();
					double area = r * r * Math.PI;
					out.writeDouble(area);
					System.out.println(this.hashCode()+"Radius is" + r);
					System.out.println(this.hashCode()+"Area is" + area);
				} catch (Exception e) {
					e.getStackTrace();
				}
			}
		}
	}

}
