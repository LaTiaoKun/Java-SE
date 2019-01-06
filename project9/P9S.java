package project9;

import java.io.*;
import java.lang.reflect.Array;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class P9S {

public static int APoint;
public static int BPoint;
	 public static RPS rps;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
	    rps = new RPS();
		Thread ts = new Thread(new TCPServer(rps));
		Thread us = new Thread(new UDPServer(rps));
		ts.start();
		us.start();
		
		for (int i = 3; i > 0; i--) {
			synchronized (rps)
			{
			while (!rps.isAOK() || !rps.isBOK()) {
				try {
					rps.wait();
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			if((rps.getaSelection()==0&&rps.getbSelection()==1)||(rps.getaSelection()==1&&rps.getbSelection()==2)||(rps.getaSelection()==2&&rps.getbSelection()==0))
			{
				APoint+=2;
			} 
			else if((rps.getaSelection()==1&&rps.getbSelection()==0)||(rps.getaSelection()==2&&rps.getbSelection()==1)||(rps.getaSelection()==0&&rps.getbSelection()==2))
			{
				BPoint+=2;
			}
			else if((rps.getaSelection()==0&&rps.getbSelection()==0)||(rps.getaSelection()==1&&rps.getbSelection()==1)||(rps.getaSelection()==2&&rps.getbSelection()==2))
			{
				APoint++;
				BPoint++;
			}
		
		System.out.print(APoint);
		System.out.print("\t"+rps.getaSleep()+"\t");
		System.out.print(BPoint);
		System.out.println("\t"+rps.getbSleep()+"\t");
		
				rps.setAOK(false);
				rps.setBOK(false);
				rps.setATrans(true);
				rps.setBTrans(true);
				rps.notifyAll();
			}
			}
		}
	}
}

class TCPServer implements Runnable {
	private Socket socket = null;
	private RPS rps = null;
	DataInputStream in;
	DataOutputStream out;

	public TCPServer(RPS rps) {
		this.rps = rps;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try (ServerSocket ss = new ServerSocket(6666)) {
			System.out.println("Listening on port 6666");
			socket = ss.accept();
			System.out.println("Thread for"+socket.getInetAddress().getHostName()+"port"+socket.getPort());
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			int count = 3;
			// read sleep time , Selection
			while (count-- > 0) {
				synchronized (rps) {
					rps.setaSleep(in.readInt());
					rps.setaSelection(in.readInt());
					rps.setAOK(true);
					rps.notifyAll();
					while (rps.isAOK() == true) {
						rps.wait();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}

class UDPServer implements Runnable {

	private RPS rps = null;

	ByteArrayInputStream bis;
	DataInputStream dis;
	int count = 3;

	public UDPServer(RPS rps) {
		this.rps = rps;
	}

	@Override
	public void run() {

		try (var ds = new DatagramSocket(7777);) {
			System.out.println("Listening on port 7777");
			while (count-- > 0) {
				byte[] buf = new byte[256];
				Array.setByte(buf, 0, (byte) 0);
				var rcvpkt = new DatagramPacket(buf, buf.length);
				// TODO 自动生成的方法存根
				ds.receive(rcvpkt);
				bis = new ByteArrayInputStream(buf);
				dis = new DataInputStream(bis);
				synchronized (rps) 
				{
					
					rps.setbSleep(dis.readInt());
					rps.setbSelection(dis.readInt());
					rps.setBOK(true);
					rps.notifyAll();
					
					while (rps.isBOK()) {
						rps.wait();
					}
					dis.close();
					bis.close();
				}
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {

			try {
				dis.close();
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			try {
				bis.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

}

class RPS {// Rock Paper Scissors
	private int aSelection = 0;
	private int bSelection = 0;
	private int aSleep = 0;
	private int bSleep = 0;
	private boolean isAOK = false;
	private boolean isBOK = false;
	private boolean isATrans =false;
    private boolean isBTrans =false;
	public int getaSelection() {
		return aSelection;
	}

	public void setaSelection(int aSelection) {
		this.aSelection = aSelection;
	}

	public int getbSelection() {
		return bSelection;
	}

	public void setbSelection(int bSelection) {
		this.bSelection = bSelection;
	}

	public int getaSleep() {
		return aSleep;
	}

	public void setaSleep(int aSleep) {
		this.aSleep = aSleep;
	}

	public int getbSleep() {
		return bSleep;
	}

	public void setbSleep(int bSleep) {
		this.bSleep = bSleep;
	}

	public boolean isAOK() {
		return isAOK;
	}

	public void setAOK(boolean isAOK) {
		this.isAOK = isAOK;
	}

	public boolean isBOK() {
		return isBOK;
	}

	public void setBOK(boolean isBOK) {
		this.isBOK = isBOK;
	}

	
	public boolean isBTrans() {
		return isBTrans;
	}

	public void setBTrans(boolean isBTrans) {
		this.isBTrans = isBTrans;
	}

	public boolean isATrans() {
		return isATrans;
	}

	public void setATrans(boolean isTrans) {
		this.isATrans = isATrans;
	}
}