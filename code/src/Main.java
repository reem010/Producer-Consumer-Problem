import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Main {
	public static void main(String[] args) throws IOException {
           
 		 final JFrame f=new JFrame();
 		 f.setVisible(true);
 		 f.setSize(800,400);
 		 f.setMinimumSize(new Dimension(300,200));
 		// f.setLayout(new FlowLayout());

 		 Font font=new Font("Ariel",Font.BOLD,18);
 		 final JTextField l1=new JTextField(20);
 		// f.add(l1);
 		 JLabel l2=new JLabel("N");
 		 l2.setFont(font);
 		// f.add(l2);
 		 
 		 final JTextField l3=new JTextField(20);
 		// f.add(l3);
 		 JLabel l4=new JLabel("Buffer Size");
 		 l4.setFont(font);
 		// f.add(l4);
 		 
 		 final JTextField l5=new JTextField(20);
 		// f.add(l5);
 		 JLabel l6=new JLabel("Output File");
 		 l6.setFont(font);
 		// f.add(l6);
 		 
		 JLabel l7=new JLabel("The largest prime number");
   		 l7.setFont(font);
   		 l7.setForeground(Color.DARK_GRAY);
   		 final JLabel largestP=new JLabel();
   		 largestP.setFont(font);

   		 
   		 JLabel l8=new JLabel("# of elements (prime numbers) generated");
  		 l8.setFont(font);
  		 l8.setForeground(Color.DARK_GRAY);
  		 final JLabel numofE=new JLabel();
  		 numofE.setFont(font);

   		 //System.out.println(Consumer.numberOfPrimesConsumed);
  		 
   		 
  		 JLabel l9=new JLabel("time elasped since the start of processing");
  		 l9.setFont(font);
  		 l9.setForeground(Color.DARK_GRAY);
  		 final JLabel timeElapsed= new JLabel();
  		 timeElapsed.setFont(font);

  		// System.out.println(Consumer.timeTaken);
  		
 		 JButton b=new JButton("Start Procuder");
 		 b.setFont(font);
 		 b.addActionListener(new ActionListener(){  
              public void actionPerformed(ActionEvent e){ 
            	  
            	  Buffer buffer=new Buffer(Integer.parseInt(l3.getText())); 
                  long startTime = System.currentTimeMillis();
                     Thread producerThread = new Thread(new Producer(buffer,Integer.parseInt(l1.getText())));
                     Thread consumerThread = new Thread(new Consumer(buffer,l5.getText(),startTime));
                     producerThread.start();
                     consumerThread.start();
                     try {
						producerThread.join();
						consumerThread .join();
         			} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
               		largestP.setText(String.valueOf(Consumer.largestPrime));
              		numofE.setText(String.valueOf(Consumer.numberOfPrimesConsumed));
               		timeElapsed.setText(String.valueOf(Consumer.timeTaken));
             		 SwingUtilities.updateComponentTreeUI(f);
                     //System.out.print(startTime);   
             		Consumer.numberOfPrimesConsumed=0;
              }  
 		    });
 		// f.add(b);
 		 
 	//	 f.setLayout(new GridLayout(2,8,5,5));    
 		 
 		 JPanel p=new JPanel();
 		 p.setLayout(new GridLayout(6,2,10,10));
 		 p.setOpaque(false);
 		 p.add(l1);
 		 p.add(l2);
 		 p.add(l3);
 		 p.add(l4);
 		 p.add(l5);
 		 p.add(l6);
 		 p.add(b);
 	   //  p.setBackground(Color.gray);
 	  //   p.setSize(100,100);

 	     
 		
 	//	 JLabel largestNumber=new JLabel(String.valueOf());
 		// largestNumber.setFont(font);
// 		 l7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 		 

   		 //System.out.println(Consumer.largestPrime);
   		 


 		 
 		 JPanel p2=new JPanel();
 		 p2.setLayout(new GridLayout(4,2,10,10));
 		 p2.setOpaque(false);
 		 p2.add(l7);
 		 p2.add(largestP);
 		 p2.add(l8);
 		 p2.add(numofE);
 		 p2.add(l9);
 		 p2.add(timeElapsed);
 		 
 	//	 p2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
 	   //  p2.setBackground(Color.red);
 	//     p.setSize(100,100);
 			
 	     
 		 JPanel mainp=new JPanel();
 		 mainp.setLayout(new BorderLayout());
 		 mainp.setBackground(Color.lightGray);
 	     mainp.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
 		 mainp.add(p,BorderLayout.NORTH);
 		 mainp.add(p2,BorderLayout.SOUTH);
 		 f.add(mainp);
	}

}
