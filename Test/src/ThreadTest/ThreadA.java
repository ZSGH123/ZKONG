package ThreadTest;

public class ThreadA extends Thread {
    
	public static int i=0;
	
	public ThreadA(String name){
		super(name);
	}
	
	public void run(){
		for (int j = 0; j < 10; j++) {
			System.out.println(getName()+i++);
		}
	}
}
