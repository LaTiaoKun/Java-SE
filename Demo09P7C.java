package unit09;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;

public class Demo09P7C {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		
		byte[] buf =new byte[1024];
		InetAddress server ;
		DatagramPacket sndpkt;
	    DatagramPacket rcvpkt;
		try (DatagramSocket socket = new DatagramSocket()){
			server = InetAddress.getByName("localhost");
			sndpkt = new DatagramPacket(buf,buf.length);
			sndpkt.setAddress(server);
			sndpkt.setPort(8000);
			
			Scanner scanner = new Scanner(System.in);
			double r =scanner.nextDouble();
		
		
//			Arrays.fill(buf,(byte) 0);
			buf = Double.valueOf(r).toString().getBytes();
			sndpkt.setData(buf);
			socket.send(sndpkt);
			buf =new byte[1024];
			rcvpkt = new DatagramPacket(buf,buf.length);
			socket.receive(rcvpkt);
			double area = Double.parseDouble(new String(buf).trim());
			System.out.println("area is"+area);
			
		}

	}

}
