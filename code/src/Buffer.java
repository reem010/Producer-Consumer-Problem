import java.util.*;

public class Buffer {
	private Queue<Integer> qu = new LinkedList<Integer>();
    private int bufferSize;
    Boolean terminate = false;
    int elements = 0;

    
   void setTerminate(boolean t){
    	terminate=t;
    }
    public Buffer(int _bufferSize)
    {
        bufferSize= _bufferSize;
    }
    public synchronized int consume()
    {
   	System.out.println("consuming");
            while(qu.isEmpty()) {
           	 try {System.out.println("consumer is waiting");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } 
    		 System.out.println("consuming");
            int tmp=qu.remove();
            elements--;
            notify();
            return tmp;
    }
    
    public synchronized void produce(int number)
        {
              while(elements==bufferSize)
              {
                 try {
             		System.out.println("preducer is waiting");
                     wait();
                } catch (InterruptedException e)
                {
                  e.printStackTrace();
                }
              }
      		System.out.println("preducing");
              this.qu.add(number);
              elements++;
              notify();
          
       }

}
