package dt06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Msgqueue {

	public static void main(String[] args) {

		MQ msgqueue = new MQ();
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new Consumer(msgqueue,1));
		executor.execute(new Producer(msgqueue));
		executor.execute(new Consumer(msgqueue,2));
	}
}

/*
 * producer msg->|Queue|->consumer
 */
//Queue Class
class MQ {
	private Queue<String> queue = new LinkedList<String>();
	int count = 0;

	public synchronized void push(String s) {
		queue.add(s);
		notifyAll();
		count++;
	}

	public synchronized String pop() throws Exception {

	while (count==0)
	{
		System.out.println("队列为空,等待...");
		wait();
		
	}

     String s = queue.poll();
			count--;
		return s;
	}

	public int length() {
		// 求队列长度
		return count;
	}
}

//thread producer Class extends Thread
class Producer extends Thread {
	// 生成消息，并放到MQ对象中；
	private String s = "";
	MQ queue = null;

	public Producer(MQ queue) {
		this.queue = queue;
	}

	public void run() {
		while (true) {
			Random length = new Random();
			Random rand = new Random();
			int l = length.nextInt(10);
			for (int i = 0; i < l; i++) {
				Random ASCII = new Random();
				int x = ASCII.nextInt(94) + 32;
				char c = (char) x;

				s = s + c;

			}
			try {
				queue.push(s);//将消息放入MQ中
			//此处无法通知consumer	notifyAll();//通知Consumer线程

				System.out.println("Producer push:" + s);
			} catch (Exception e) {
				System.out.println("无法像消息队列中添加信息，错误原因" + e.getLocalizedMessage());
			}
			try {
				s = " ";
				sleep(rand.nextInt(rand.nextInt(1000)));
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}

//thread consumer Class implement Runnable
class Consumer implements Runnable {
	MQ queue = null;
	private int ID;
	Random rand = new Random();

	public Consumer(MQ queue,int x) {
		this.queue = queue;
		ID =x;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while (true) {
			try {
				String s = queue.pop();
				System.out.println("Consumer"+ID+" pop：" + s);
			} catch (Exception e) {
		
			}
		}
	}

}