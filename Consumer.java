package Main;

public class Consumer implements Runnable {
	private int threadNum;
	Thread t;
	
	CommonStack CR;
	
	public Consumer(int num, CommonStack CR_arg) {
		threadNum = num;
		this.CR = CR_arg;
		t = new Thread(this);
		FileWorker.write("Consumer thread " + threadNum);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			if (Global.sizeBreak <= CommonStack.sizePassage) break;
			try	{
				Global.Sem2.release();
				FileWorker.write("P1 opened Sem1");
				CR.popVector(threadNum);
				FileWorker.write("P1 start waiting for Sem2");
				Global.Sem1.acquire();
				FileWorker.write("P1 finish waiting for Sem2");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		FileWorker.write("Consumer thread " + threadNum + " finished");
 		System.out.println("Producer thread " + threadNum + " finished");
	}
}

