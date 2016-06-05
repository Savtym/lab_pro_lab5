package Main;

public class Main {
	public static void main(String[] args) {
		Global.file.delete();
		CommonStack MyCR = new CommonStack();
		Consumer thread_1 = new Consumer(1,MyCR);
		Producer thread_2 = new Producer(2,MyCR);
		Producer thread_3 = new Producer(3,MyCR);
		Producer thread_4 = new Producer(4,MyCR);
		Producer thread_5 = new Producer(5,MyCR);
		try {
			 /* Очікується завершення потоків. */
			 thread_1.t.join();
			 thread_2.t.join();
			 thread_3.t.join();
			 thread_4.t.join();
			 thread_5.t.join();
		 } catch(InterruptedException e) {
			 System.out.println("\nMain Interrupted");
		 }
		 System.out.println("\nFinished Threads All");
	}
}