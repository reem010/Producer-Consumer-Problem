import java.util.*;

public class Producer implements Runnable{
        Buffer bufferObj;
        int N;
        
        public Producer(Buffer b, int n) {
            this. bufferObj = b;
            N = n;
        }
       boolean isPrime(int x){
    	   for(long i=2;i*i<=x;i++){
    		   if(x%i==0)return false;
    	   }
    	   return true;
       }
	public void run() {
	    for(int i=2;i<=N;i++){
	    	if(isPrime(i)){
	    		bufferObj.produce(i);
	    	}
	    }
	    bufferObj.setTerminate(true);
	}
}