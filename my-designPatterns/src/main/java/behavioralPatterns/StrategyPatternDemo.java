package behavioralPatterns;


import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Properties;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import structuralPatterns.ProxyPatternClient;  
  
public class StrategyPatternDemo {  
	static PrintStream myout = new PrintStream(new FileOutputStream(FileDescriptor.out));
	private static final Logger logger = LogManager.getLogger(ProxyPatternClient.class);
	static Properties props = new Properties();
    public static void main(String[] args) throws NumberFormatException, IOException {  
    	  BasicConfigurator.configure();
    	  logger.debug("Debugging started in StrategyPatternDemo");
    	  
          BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
          logger.warn("Please enter two values(in float)");
          myout.print("Enter the first value: ");  
          float value1=Float.parseFloat(br.readLine());  
          myout.print("Enter the second value: ");  
          float value2=Float.parseFloat(br.readLine()); 
          logger.info("Addition class started....");
          Context context = new Context(new Addition());          
          myout.println("Addition = " + context.executeStrategy(value1, value2));  
          logger.info("Subtraction class started");
          context = new Context(new Subtraction());       
          myout.println("Subtraction = " + context.executeStrategy(value1, value2));  
          logger.info("Multiplication class started");
          context = new Context(new Multiplication());        
          myout.println("Multiplication = " + context.executeStrategy(value1, value2));  
       }  
  
}