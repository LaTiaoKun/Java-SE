package unit09;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import unit09.Demo09P13threadserver.ServerThread;

public class Demo09T13Server {
	public static void main(String[] args) throws IOException {
		
		 try {
	    	  ExecutorService executor = Executors.newCachedThreadPool();
	    	  ServerSocket  ss = new ServerSocket(6666);
	    	  System.out.println("Listening on port 6666");
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
