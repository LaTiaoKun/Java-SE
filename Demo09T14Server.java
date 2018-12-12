package unit09;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Date;

public class Demo09T14Server {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
      byte[] buf = new byte [1024];
      DatagramPacket rcvpkt = new DatagramPacket(buf,buf.length);
      DatagramPacket sndpkt = new DatagramPacket(buf,buf.length);
	  DatagramSocket socket = new DatagramSocket(6666);
	  System.out.println("Server Started on port 6666"+new Date());
	  while(true)
	  {
		  Arrays.fill(buf, (byte)0);
		  socket.receive(rcvpkt);
		  System.out.println("Received packet from"+rcvpkt.getAddress().getHostAddress()+":"+rcvpkt.getPort());
		  var rcv = Double.parseDouble(new String(buf).trim());
		  buf = Double.valueOf(rcv).toString().getBytes();
		  sndpkt.setAddress(rcvpkt.getAddress());
		  sndpkt.setPort(rcvpkt.getPort());
	        sndpkt.setData(buf,0,buf.length);
	        socket.send(sndpkt);
	  }
	  
	}

}
