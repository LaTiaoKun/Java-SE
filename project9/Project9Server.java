package project9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Project9Server
{

	
	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		 ExecutorService executor = Executors.newCachedThreadPool();
		 ServerSocket  server =new ServerSocket(8000);
		 System.out.println("Listening on port 8000");
		 while(true)
		 {
			 Socket socket1 = server.accept();
			 Socket socket2 = server.accept();
			 System.out.println("Thread for"+socket1.getInetAddress().getHostName()+"port"+socket1.getPort());
			 System.out.println("Thread for"+socket2.getInetAddress().getHostName()+"port"+socket2.getPort());
			 executor.execute(new ServerThread(socket1,socket2));
		 }
	}

}
class ServerThread implements Runnable
{
	private Socket socket1;
	private Socket socket2;
	Random r =new Random();
	ServerThread(Socket socket1,Socket socket2)
	{
		this.socket1 = socket1;
		this.socket2 = socket2;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
		while(true)
		{
			var in1 = new DataInputStream(socket1.getInputStream());
			var out1 = new DataOutputStream(socket1.getOutputStream());
			var in2 = new DataInputStream(socket2.getInputStream());
			var out2 = new DataOutputStream(socket2.getOutputStream());
			int i1 = in1.readInt();
			int i2 = in2.readInt();
			if((i1==1&&i2==2)||(i1==2&&i2==3)||(i1==3&&i2==1))
			{
				int ping1 = r.nextInt(1000);
				Thread.sleep(ping1);
				out1.writeInt(2);
				int ping2 = r.nextInt(1000);
				Thread.sleep(ping2);
				out2.writeInt(0);
				out1.writeInt(ping1);
				out1.writeInt(ping2);
				out2.writeInt(ping2);
				out2.writeInt(ping1);
			}
			else if((i2==1&&i1==2)||(i2==2&&i1==3)||(i2==3&&i1==1))
			{
				int ping1 = r.nextInt(1000);
				Thread.sleep(ping1);
				out1.writeInt(0);
				int ping2 = r.nextInt(1000);
				Thread.sleep(ping2);
				out2.writeInt(2);
				out1.writeInt(ping1);
				out1.writeInt(ping2);
				out2.writeInt(ping2);
				out2.writeInt(ping1);
			}
			else
			{
				int ping1 = r.nextInt(1000);
				Thread.sleep(ping1);
				out1.writeInt(1);
				int ping2 = r.nextInt(1000);
				Thread.sleep(ping2);
				out2.writeInt(1);
				out1.writeInt(ping1);
				out1.writeInt(ping2);
				out2.writeInt(ping2);
				out2.writeInt(ping1);
			}
		}
		}
		catch(Exception e){
			e.getStackTrace();
	   }
	}
}