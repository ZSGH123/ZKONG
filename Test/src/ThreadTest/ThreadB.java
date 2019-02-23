package ThreadTest;

public class ThreadB extends Thread {
	
	public ThreadB(String name){
		super(name);
	}
	
	public void run(){
			System.out.println(getName()+ThreadA.i++);
	}
}
