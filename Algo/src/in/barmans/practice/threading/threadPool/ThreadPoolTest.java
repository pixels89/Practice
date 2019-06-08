package in.barmans.practice.threading.threadPool;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import in.barmans.practice.threading.SemaphoreSimple;

public class ThreadPoolTest {

	private AtomicInteger count = new AtomicInteger();

	@Test
	public void testEmptyQueue() {
		ThreadPool pool = new ThreadPool(1);
		pool.shutdown();
	}

	@Test
	public void testSingleThreadSinglework() throws InterruptedException {
		ThreadPool pool = new ThreadPool(1);
		pool.submit(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println("Just prints something" + i + Thread.currentThread().getName());
				}
			}
		});
		Thread.sleep(1000);
		pool.shutdown();
	}

	@Test
	public void testSingleThreadManyWork() throws InterruptedException {
		ThreadPool pool = new ThreadPool(1);
		count = new AtomicInteger();

		for (int i = 0; i < 10; i++) {
			pool.submit(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						count.incrementAndGet();
					}
				}
			});
		}
		Thread.sleep(1000);
		assertEquals(100000, count.get());
		pool.shutdown();
	}

	@Test
	public void testManyThreadManyWork() throws InterruptedException {
		ThreadPool pool = new ThreadPool(6);
		count = new AtomicInteger();

		for (int i = 0; i < 10; i++) {
			pool.submit(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						count.incrementAndGet();
					}
				}
			});
		}
		Thread.sleep(1000);
		assertEquals(100000, count.get());
		pool.shutdown();
	}

	@Test
	public void testManyThreadManyWorkSemaphore() throws InterruptedException {
		ThreadPool pool = new ThreadPool(6);
		int concurrentCount = 3;

		SemaphoreSimple sem = new SemaphoreSimple(concurrentCount);
		// LimitedAtomicInteger concurrentThread = new LimitedAtomicInteger(2);
		AtomicInteger totalcount = new AtomicInteger();

		for (int i = 0; i < 10; i++) {
			pool.submit(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						try {
							sem.acquire();
							totalcount.incrementAndGet();
							System.out.printf("Total count: %d\n", totalcount.get());
							// concurrentThread.incrementAndGetLimited();
							// concurrentThread.decrement();
						} catch (InterruptedException e) {
							e.printStackTrace();
							break;
						} finally {
							sem.release();
						}
					}
				}
			});
		}
		//pool.shutdown();
		Thread.sleep(5000);
		assertEquals(100000, totalcount.get());
	}

	class LimitedAtomicInteger {
		private AtomicInteger innerInteger;
		private int limit;

		LimitedAtomicInteger(int limit) {
			this.limit = limit;
			innerInteger = new AtomicInteger();
		}

		public int get() {
			return innerInteger.get();
		}

		public void decrement() {
			innerInteger.decrementAndGet();
		}

		public int incrementAndGetLimited() {
			if (this.limit == innerInteger.get()) {
				throw new RuntimeException("Limit reached");
			}
			return innerInteger.incrementAndGet();
		}

	}

}
