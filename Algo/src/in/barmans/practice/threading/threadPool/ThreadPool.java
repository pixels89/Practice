package in.barmans.practice.threading.threadPool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> queue;
	private List<Thread> threads;

	public ThreadPool(int threadCount) {
		queue = new LinkedBlockingQueue<Runnable>();
		threads = new LinkedList<Thread>();
		for (int i = 0; i < threadCount; i++) {
			Thread t = new Thread(new Worker());
			t.start();
			threads.add(t);
		}
	}

	public void submit(Runnable runnable) {
		queue.add(runnable);
	}

	public void shutdown() {
		for (Thread thread : threads) {
			thread.interrupt();
		}
	}

	class Worker extends Thread {

		@Override
		public void run() {
			while (!(isInterrupted() && queue.isEmpty())) { //FIXME
				Runnable runnable;
				try {
					runnable = queue.take();
					runnable.run();
				} catch (InterruptedException e) {
					System.out.println("Inturrpted - coming out queue size: "+ queue.size());
				} catch (Exception e) {
					System.out.println("Exception in client code" + e.getMessage());
				}

			}
		}

	}
}
