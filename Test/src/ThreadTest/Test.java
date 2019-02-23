package ThreadTest;

public class Test {

	public static void main(String[] args) {
		ThreadA a=new ThreadA("a");
		ThreadA c=new ThreadA("c");
		a.start();
		c.start();
		
		
		

	}

}
