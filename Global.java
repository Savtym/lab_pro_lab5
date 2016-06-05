package Main;

import java.io.File;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Global {
	public static final int sizeBreak = 2;
	public static final int MaxSize = 5;
	public static int[] mas = new int[MaxSize];
	public static CyclicBarrier CB1 = new CyclicBarrier(2);
	public static CyclicBarrier CB2 = new CyclicBarrier(2);
	public static Semaphore Sem1 = new Semaphore(0, true);
	public static Semaphore Sem2 = new Semaphore(0, true);
	public static String fileName = "log.txt";
	public static File file = new File(Global.fileName);
}

