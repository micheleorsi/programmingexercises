/**
 * 
 */
package concurrency;

/**
 * @author morsi
 *
 */
public class Ex3_MethodThreadSafe {
	
	public static void main (String args[]) {
		NotThreadSafe sharedInstance = new NotThreadSafe();
		
		for(int i=0; i<100000; i++) {
			new Thread(new MyRunnable2(sharedInstance)).start();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sharedInstance.returnString());
	}
}

class MyRunnable2 implements Runnable{
	  NotThreadSafe instance = null;

	  public MyRunnable2(NotThreadSafe instance){
	    this.instance = instance;
	  }

	  public void run(){
	    this.instance.add("some text");
	  }
	}

class NotThreadSafe{
    int counter = 0;

    public void add(String text){
        this.counter++;
    }
    
    public int returnString() {
    	return this.counter;
    }
}
