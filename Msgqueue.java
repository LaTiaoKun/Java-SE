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
		System.out.println("����Ϊ��,�ȴ�...");
		wait();
		
	}

     String s = queue.poll();
			count--;
		return s;
	}

	public int length() {
		// ����г���
		return count;
	}
}

//thread producer Class extends Thread
class Producer extends Thread {
	// ������Ϣ�����ŵ�MQ�����У�
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
				queue.push(s);//����Ϣ����MQ��
			//�˴��޷�֪ͨconsumer	notifyAll();//֪ͨConsumer�߳�

				System.out.println("Producer push:" + s);
			} catch (Exception e) {
				System.out.println("�޷�����Ϣ�����������Ϣ������ԭ��" + e.getLocalizedMessage());
			}
			try {
				s = " ";
				sleep(rand.nextInt(rand.nextInt(1000)));
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
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
		// TODO �Զ����ɵķ������
		while (true) {
			try {
				String s = queue.pop();
				System.out.println("Consumer"+ID+" pop��" + s);
			} catch (Exception e) {
		
			}
		}
	}

}