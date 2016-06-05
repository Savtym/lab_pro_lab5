package Main;

public class CommonStack {

	public static int sizePassage = 0;
	int ind = 0;
	int iCur = 0;
	int jCur = 0;
	boolean IsEmpty = iCur  == jCur;
	boolean IsFull = iCur == Global.MaxSize;

    synchronized void popVector(int threadNum) {
    	while (IsEmpty)
			try {
				wait(); 
			} catch (InterruptedException e) {
				System.out.println("InterruptedException");
			}
		if (jCur == Global.MaxSize) jCur = 0;
		if (sizePassage != Global.sizeBreak) {
	    	System.out.println("--- buf [" + jCur + "] = " + Global.mas[jCur]);
		    FileWorker.write("Thread " + threadNum + " pop: " + Global.mas[jCur]);
		    Global.mas[jCur] = -2;
		    ++jCur;
		}

	    IsEmpty = iCur == jCur;
		IsFull = false;
			
		notify();
    }

    synchronized void pushVector(int threadNum) {
    	while (IsFull)
			try {
				wait(); 
			} catch (InterruptedException e) {
				System.out.println("InterruptedException");
			}

		if (iCur == Global.MaxSize) {
			iCur = 0;
			++sizePassage;
		}
		if (sizePassage != Global.sizeBreak) {
			System.out.println("+++ ind: " + iCur +" => " + iCur);
		    Global.mas[iCur] = iCur;
	        FileWorker.write("Thread " + threadNum + " push: " + Global.mas[iCur]);
	        ++iCur;
	    }

	    IsFull = iCur == jCur;
		IsEmpty = false;
			
		notify();
    }
}


