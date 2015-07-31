/**
 * 
 */
package concurrency;

/**
 * @author morsi
 *
 */
public class Ex1_CreationStartingThreads {

	public static void main(String args[]) {
		MyThread thread = new MyThread();
		thread.start();

		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("Thread Running");
			}
		};
		thread2.start();

		Thread thread3 = new Thread(new MyRunnable());
		thread3.start();

		Runnable myRunnable = new Runnable() {
			public void run() {
				System.out.println("Runnable running");
			}
		};

		Thread thread4 = new Thread(myRunnable);
		thread4.start();
	}
}

class MyThread extends Thread {
	public void run() {
		System.out.println("MyThread running");
	}
}

class MyRunnable implements Runnable {
	public void run() {
		System.out.println("MyRunnable running");
	}
}
