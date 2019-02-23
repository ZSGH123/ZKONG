package ThreadTest;

public class ThreadA extends Thread {
    
	public static int i=0;
	
	public ThreadA(String name){
		super(name);
	}
	
	public void run(){
		for (int j = 0; j < 10; j++) {
			if(getName().equals("c")){
				ThreadB b=new ThreadB("b");
				b.start();
				try {
					b.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(getName()+i++);
		}
	}
}
