package unit09;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Date;



public class Demo09P7s {

	public static void main(String[] args)  {
		// TODO 自动生成的方法存根
    byte[] buf = new byte[1024] ;
   
   
    DatagramPacket rcvpkt = new DatagramPacket(buf,buf.length);
    DatagramPacket sndpkt = new DatagramPacket(buf,buf.length);
    try( DatagramSocket  socket=  new DatagramSocket(8000);) {
    	 System.out.println("Server Started on port 8000"+new Date());
    while(true)
    {
    	
    	Arrays.fill(buf,(byte)0);
    	socket.receive(rcvpkt);
    	System.out.println("Received packet from"+rcvpkt.getAddress().getHostAddress()+":"+rcvpkt.getPort());//获取IP地址
      	var radius = Double.parseDouble(new String(buf).trim());
    	System.out.println("Radius:"+radius);
        var area  = radius*radius*Math.PI;
        System.out.println("area is"+area);
        buf = Double.valueOf(area).toString().getBytes();
        sndpkt.setAddress(rcvpkt.getAddress());
        sndpkt.setPort(rcvpkt.getPort());
        sndpkt.setData(buf,0,buf.length);
        socket.send(sndpkt);
    }}
    catch(Exception e) {
    	
    }
    
	}

}
