package in.barmans.practice.threading;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class SimpleCountDownLatchTest {
	AtomicInteger commonCount = new AtomicInteger(0);

	@Test
	public void test() throws InterruptedException {

		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		SimpleCountDownLatch latch = new SimpleCountDownLatch(2);
		for (int i = 0; i < 10; i++) {
			threadPool.submit(new Waiter(latch));
		}
		assertEquals(0, commonCount.get());
		Thread.sleep(1000);
		latch.countDown();
		latch.countDown();
		Thread.sleep(1000);
		assertEquals(10, commonCount.get());
	}

	class Waiter implements Runnable {
		private SimpleCountDownLatch latch;

		public Waiter(SimpleCountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				System.out.println("Waiting for latch" + Thread.currentThread().getName());
				this.latch.await();
				commonCount.incrementAndGet();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Latch cleared: " + Thread.currentThread().getName());

		}
	}

}
