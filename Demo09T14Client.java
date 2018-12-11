package unit09;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Demo09T14Client {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
       byte[] buf = new byte[1024];
       InetAddress server;
       DatagramPacket sndpkt;
	   DatagramPacket rcvpkt;
	   DatagramSocket socket = new DatagramSocket();
	   server = InetAddress.getByName("localhost");
	   sndpkt = new DatagramPacket(buf,buf.length);
	   sndpkt.setAddress(server);
	   sndpkt.setPort(6666);
	
        Scanner scanner = new Scanner(System.in);
        double r = scanner.nextDouble();
        buf = Double.valueOf(r).toString().getBytes();
        sndpkt.setData(buf);
        socket.send(sndpkt);
        buf =new byte[1024];
        rcvpkt = new DatagramPacket(buf,buf.length);
        socket.receive(rcvpkt);
		String s = new String(buf).trim();
		System.out.println(s);
        
}
}
