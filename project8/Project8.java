package project8;

import java.util.Random;

public class Project8 {
    
	public static void main(String [] args)
  {
	threadC C = new threadC();
	C.start();
  }
}

class threadA extends Thread
{
	private char a;

	 int sleep = 0;
	Random r = new Random();

	public char  getc ()
	{
	     return a;	
	}
	@Override
	public synchronized void run()
	{
		
		a =(char) ('a'+r.nextInt(25));
		try {
			sleep = r.nextInt(1000);
			sleep(sleep);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
class  threadB implements Runnable
{
	private char a;
	Random r = new Random();
    int sleep = 0;
    public char  getc ()
	{
	     return a;	
	}
	@Override
	public synchronized void run() {
		// TODO 自动生成的方法存根
		
		a = (char) ('a'+r.nextInt(25));
		try {
			sleep = r.nextInt(1000);
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}

}
class threadC extends Thread
{
	threadA A = null;
	threadB B = null;
	int PointA = 0;
	int PointB = 0;
    boolean  p =false;

    int count = 1;
	public threadC()
	{
	}
	public void CompareTo()
	{
		if(A.getc()>B.getc()) PointA+=2;
		else if(A.getc()<B.getc())PointB+=2;
		else {
			PointA+=1;
			PointB+=1;
		}
	}
	public void print()
	{
		if(p == false)
		{
		 System.out.println("                    ThreadA          "+"               ThreadB         ");
	     System.out.println("Round   SleepTime   RandomChar  Point"+"  SleepTime   RandomChar  Point");
	     p = true;
		}
		 System.out.println(" "+count +"        "+A.sleep+"         "+A.getc()+"          "+PointA+"       "+ B.sleep+"       "+B.getc()+"           "+PointB);
		 count ++;     
	}
	@Override
	public void run()
	{
		while(true)
		{
		A = new threadA();
		B = new threadB();
		A.start();
		Thread t = new Thread(B);
		t.start();
		try {
			A.join();
		} catch (InterruptedException e2) {
			// TODO 自动生成的 catch 块
			e2.printStackTrace();
		}
		try {
			t.join();
		} catch (InterruptedException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
		CompareTo();
		print();
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		}
	}
}














