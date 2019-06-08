package in.barmans.practice.threading;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

class SemaphoreTest {

	@Test
	void test() throws InterruptedException {
		SemaphoreSimple sem = new SemaphoreSimple(2);
		AtomicInteger ignore = new AtomicInteger();

		Thread t1 = new Thread(new Worker(sem, ignore), "Thread 1");
		Thread t2 = new Thread(new Worker(sem, ignore), "Thread 2");
		Thread t3 = new Thread(new Worker(sem, ignore), "Thread 3");

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
	}

	@Test
	void testWithExecutorService() throws InterruptedException {
		ExecutorService threadPool = Executors.newFixedThreadPool(6);
		SemaphoreSimple sem = new SemaphoreSimple(10);
		AtomicInteger counter = new AtomicInteger();

		for (int i = 0; i < 10; i++) {
			threadPool.submit(new Worker(sem, counter));
		}

		threadPool.shutdown();
		threadPool.awaitTermination(10, TimeUnit.SECONDS);
		assertEquals(10000, counter.get());
	}

	static class Worker implements Runnable {
		private SemaphoreSimple sem;
		private AtomicInteger counter;

		public Worker(SemaphoreSimple sem, AtomicInteger i) {
			this.sem = sem;
			this.counter = i;
		}

		@Override
		public void run() {
			int i = 0;
			for (i = 0; i < 1000; i++) {
				try {
					sem.acquire();

					System.out.println("Semaphore acquired, item: " + i + " counter: " + counter.incrementAndGet()
							+ "  name: " + Thread.currentThread().getName());
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} finally {
					sem.release();
				}
			}
			System.out.println("Completed work " + i + "  name: " + Thread.currentThread().getName());
		}

	}

}
