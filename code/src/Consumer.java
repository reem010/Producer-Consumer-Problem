import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Consumer implements Runnable{
	
    Buffer bufferObj;
    static int numberOfPrimesConsumed =0;
    static int largestPrime;
    String fileName;
    static long startTime;
    static long timeTaken;
    

    public Consumer(Buffer b, String f,long _startTime) {
       this.bufferObj = b;
       fileName=f;
       startTime=_startTime;
    }
    
    public void run() {
    	 FileWriter fileWriter=null;
      try {
        fileWriter= new FileWriter(fileName);
       
        while(true)
        {
            if(bufferObj.elements==0 && bufferObj.terminate==true){ // no elements in the qu and the producer is done producing
            timeTaken = (System.currentTimeMillis()- startTime);
             break; 
         }
         else{
               int tmp= bufferObj.consume();
               numberOfPrimesConsumed++;
               largestPrime=tmp;
               fileWriter.write("'"+Integer.toString(tmp)+ "', ");
               fileWriter.flush();
            }
        }
        
        
    } catch (IOException ex) {}
      
      try {
		fileWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}