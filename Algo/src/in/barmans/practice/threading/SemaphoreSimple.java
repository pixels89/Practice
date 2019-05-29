package in.barmans.practice.threading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class SemaphoreSimple {
	private final Queue<Object> queue;
	private final AtomicIntegerExt count;

	public SemaphoreSimple(int count) {
		queue = new LinkedList<Object>();
		this.count = new AtomicIntegerExt(count);
	}

	public void aquire() throws InterruptedException {
		Object lock = new Object();

		synchronized (lock) {
			int countVal = count.get();
			do {
				if (count.get() == 0) {
					queue.add(lock);
					while (count.get() == 0)
						lock.wait();
					queue.remove(lock);
					countVal = count.get();
				}
			} while (!count.compareAndSetIfMore(0, countVal - 1));
		}
	}

	public void release() {
		Object lock = queue.peek();
		this.count.incrementAndGet();
		if (lock != null) {
			synchronized (lock) {
				lock.notify();
			}
		}
	}

	/**
	 * http://gridgain.blogspot.com/2011/06/better-atomiclong-and-atomicinteger-in.html
	 * 
	 * @author mbarman
	 *
	 */
	class AtomicIntegerExt extends AtomicInteger {

		private static final long serialVersionUID = 8627798166505321631L;

		AtomicIntegerExt(int count) {
			super(count);
		}

		public boolean compareAndSetIfMore(int moreThan, int value) {
			while (true) {
				int cur = get();
				if (moreThan < cur) {
					if (compareAndSet(cur, value))
						return true;
				} else
					return false;
			}
		}
	}

}
