package ok.thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

class TaskOdd implements Runnable {
	int counter = 1;
	int max = Integer.MAX_VALUE;
	private Lock l;
	private Condition oc;
	private AtomicBoolean start;

	public TaskOdd(Lock l, Condition c, int max,AtomicBoolean start) {
		this.l = l;
		this.oc = c;
		this.max = max;
		this.start = start;
	}

	public void run() {
		l.lock();
		while (counter < max) {
			System.out.println(counter);
			counter = counter + 2;
			oc.signal();
			start.compareAndSet(false, true);
			try {
				oc.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		l.unlock();
	}

}

class TaskEven implements Runnable {
	int counter = 2;
	private Lock l;
	private Condition ec;
	int max = Integer.MAX_VALUE;
	private AtomicBoolean start;

	public TaskEven(Lock l, Condition c, int max,AtomicBoolean start) {
		this.l = l;
		this.ec = c;
		this.max = max;
		this.start = start;
	}

	public void run() {
		l.lock();
		try {
			ec.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (counter < max) {
			if(start.get()) {
				System.out.println(counter);
				counter = counter + 2;
				ec.signal();
				try {
					ec.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
		l.unlock();

	}

}

public class One {

	public static void main(String[] args) {
		// Thread t = new Thread(() -> IntStream.range(1,
		// 10000000).forEach(System.out::println));
	
		Lock common = new ReentrantLock();
		Condition one = common.newCondition();
		AtomicBoolean start = new AtomicBoolean(false);

		Thread t2 = new Thread(new TaskEven(common, one, 100,start));
		t2.start();

		

		Thread t1 = new Thread(new TaskOdd(common, one, 100,start));
		t1.start();

		
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
