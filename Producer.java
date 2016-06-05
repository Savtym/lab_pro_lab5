package Main;

import java.util.concurrent.BrokenBarrierException;

public class Producer implements Runnable {
	private int threadNum;
	CommonStack CR;
	Thread t;

	public Producer(int num, CommonStack CR_arg) {
		threadNum = num;
		this.CR = CR_arg;
		t = new Thread(this);
		FileWorker.write("Producer thread " + threadNum);
		t.start();
	}

	@Override
	public void run() {
		while (true) {
			if (Global.sizeBreak <= CommonStack.sizePassage) break;
			if ((threadNum == 2) || (threadNum == 3)) {
				try {
					CommonVariables.mutex.lock();
					CommonVariables.updateVariables(threadNum);
					CommonVariables.mutex.unlock();
					if (threadNum == 3) {
						Global.Sem1.release();
						FileWorker.write("P3 opened Sem2");
						CR.pushVector(threadNum);
						FileWorker.write("P3 start waiting for Sem1");
						Global.Sem2.acquire();
						FileWorker.write("P3 finish waiting for Sem1");
					}
					Global.CB1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			} else if ((threadNum == 4) || (threadNum == 5)) {
				try {
					CommonVariables.mutex.lock();
					CommonVariables.updateVariables(threadNum);
					CommonVariables.mutex.unlock();
					Global.CB2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		}
		switch(threadNum) {
			case 2:
				FileWorker.write("Producer thread " + threadNum + " finished");
		 		System.out.println("Producer thread " + threadNum + " finished");
				break;
			case 3:
				FileWorker.write("Producer thread " + threadNum + " finished");
		 		System.out.println("Producer thread " + threadNum + " finished");
				break;
			case 4:
				FileWorker.write("Producer thread " + threadNum + " finished");
		 		System.out.println("Producer thread " + threadNum + " finished");
				break;
			case 5:
				FileWorker.write("Producer thread " + threadNum + " finished");
		 		System.out.println("Producer thread " + threadNum + " finished");
				break;
		}
	}
}

