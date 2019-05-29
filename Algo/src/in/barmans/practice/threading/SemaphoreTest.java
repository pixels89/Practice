package in.barmans.practice.threading;

import org.junit.jupiter.api.Test;

class SemaphoreTest {

	@Test
	void test() throws InterruptedException {
		SemaphoreSimple sem = new SemaphoreSimple(2);

		Thread t1 = new Thread(new Worker(sem), "Thread 1");
		Thread t2 = new Thread(new Worker(sem), "Thread 2");
		Thread t3 = new Thread(new Worker(sem), "Thread 3");

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();
	}

	static class Worker implements Runnable {

		private SemaphoreSimple sem;

		public Worker(SemaphoreSimple sem) {
			this.sem = sem;
		}

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					sem.aquire();
					System.out.println("Sefmaphore acquired: " + Thread.currentThread().getName());
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} finally {
					sem.release();
				}
			}
		}

	}

}
