package Main;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class CommonVariables {

    private static Random random = new Random();

    public static ReentrantLock mutex = new ReentrantLock();

    private static byte  Byte;
    private static short Short;
    private static int   Int;
    private static long  Long;

    public CommonVariables() {
	    CommonVariables.setByte();
	    CommonVariables.setShort();
	    CommonVariables.setInt();
	    CommonVariables.setLong();
    }

    public static byte getByte() { 
        return Byte; 
    }

    public static void setByte() { 
        CommonVariables.Byte =  (byte)random.nextInt(127); 
    }

    public static short getShort() {
        return Short;
    }

    public static void setShort() {
        CommonVariables.Short = (short)random.nextInt(32767);
    }

    public static int  getInt() {
        return Int;
    }

    public static void setInt() {
        CommonVariables.Int = random.nextInt();
    }

    public static long getLong() {
        return Long;
    }

    public static void setLong() {
        CommonVariables.Long = random.nextLong();
    }

    public static void updateVariables(int i) {
        switch (i) {
            case 2:
                setByte();
                setShort();
                setInt();
                setLong();
                break;
            case 4:
                setByte();
                setShort();
                setInt();
                setLong();
                break;
            case 5:
                setByte();
                setShort();
                setInt();
                setLong();
                break;
        }
            FileWorker.write("Thread " + i + " changes: ");
    	    showValue(Byte);
    	    showValue(Short);
    	    showValue(Int);
    	    showValue(Long);
    }

    private static void showValue(byte Type) {
    	FileWorker.write(" Byte value: " + getByte());
    }

    private static void showValue(short Type){
    	FileWorker.write(" Short value: " + getShort());
    }

    private static void showValue(int Type){
    	FileWorker.write(" Int value: " + getInt());
    }

    private static void showValue(long Type){
    	FileWorker.write(" Long value: " + getLong());
    }
}
