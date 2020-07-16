package in.barmans.practice.threading;

public class SimpleCountDownLatch {

	private volatile int count;
	private Object lock = new Object();

	public SimpleCountDownLatch(int count) {
		this.count = count;
	}

	public void await() throws InterruptedException {
		synchronized (lock) {
			while (count != 0)
				lock.wait();
		}
	}

	public void countDown() {
		synchronized (lock) {
			count--;
			if (count == 0) {
				lock.notifyAll();
			}
		}
	}

}
