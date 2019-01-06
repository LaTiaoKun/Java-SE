package project9;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;

public class P9C {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Thread tcp = new Thread(new TCP());
		Thread udp = new Thread(new UDP());
		tcp.start();
		udp.start();
	}
}

class TCP implements Runnable {
	Socket socket;
	DataOutputStream out;
	DataInputStream in;
	static int sleep = 0;
	int selection = 0;
	Random rand = new Random();

	public TCP() {

	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
	
		try {
			socket = new Socket("127.0.0.1", 6666);
			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());
			while (true) {

				sleep = rand.nextInt(1000);
				selection = rand.nextInt(3);
				out.writeInt(sleep);
				out.writeInt(selection);
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}

class UDP implements Runnable {
     int sleep = 0;
     int selection = 0;
	//byte[] buf = new byte[128];
	Random rand = new Random();
	InetAddress server;
	DatagramSocket socket;
	DatagramPacket sndpkt;   
	@Override
	public void run()
	{
		// TODO 自动生成的方法存根
		try 
		{
		 socket = new DatagramSocket(); 
		 server = InetAddress.getByName("localhost");
		// sndpkt = new DatagramPacket(buf,buf.length);
		 sndpkt.setAddress(server);
		 sndpkt.setPort(7777);
		 while(true)
		 { 
				 sleep = 1000;
				 selection = rand.nextInt(3);
				var bos = new ByteArrayOutputStream(256);
				var dos = new DataOutputStream(bos);
				dos.write(sleep);
				dos.write(selection);
				byte[]buf = new byte[256];
				buf =bos.toByteArray();
				sndpkt = new DatagramPacket(buf, buf.length,new InetSocketAddress("localhost",7777));
				socket.send(sndpkt);
		}
}catch(Exception e)
   {
	   e.getStackTrace();
   }
   }
	}