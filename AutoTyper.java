import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*; 
import java.util.Scanner;
import java.lang.String;
import java.util.Random;

public class AutoTyper {
	
	private Robot robot;
	private Scanner sc;
	private Runtime runtime;
	
	
    public AutoTyper() throws AWTException {
        this.robot = new Robot();
        this.sc = null;
        this.runtime = null;
    }
    
    public void reader(String nameOfFile) {
    	 try
    	    {
    	      sc = new Scanner(new File(nameOfFile));
    	      System.out.println("file was found");
    	    }
    	    catch(FileNotFoundException s)
    	    {
    	      System.out.println("File does Not Exist Please Try Again: ");
    	    }
    	 try {
 			System.out.println("Opening Discord");
 			String execute = "..Discord.exe"; // This would have the filepath to Discord.exe
 			this.runtime = Runtime.getRuntime();
 			runtime.exec(execute);
 			runtime.exec(execute);
 			
 			try {
 				Thread.sleep(5000);
 	 			 while (sc.hasNextLine()) {
 	 	 			String recieve = sc.nextLine();
 	 	 			System.out.println("Sending string " + recieve + " to type");
 	 	 			writeString(recieve);
 	 	 			runtime.exec(execute);
 	 	 			runtime.exec(execute);
 	 	 			Thread.sleep(3000);
 	 	    	 }
 	 			System.out.println("End of code");
 	 			sc.close();
 			} catch (InterruptedException e) {
 				e.printStackTrace();
 			}
 	
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
	}

    private void writeString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ':') {
            	robot.keyPress(KeyEvent.VK_SHIFT);
            	robot.keyPress(KeyEvent.VK_SEMICOLON);
            	robot.keyRelease(KeyEvent.VK_SEMICOLON);
            	robot.keyRelease(KeyEvent.VK_SHIFT);
            } else {
            	boolean upper = Character.isUpperCase(c);
	            if (upper) {
	                robot.keyPress(KeyEvent.VK_SHIFT);
	                robot.keyPress(Character.toUpperCase(c));
		            robot.keyRelease(Character.toUpperCase(c));
	                robot.keyRelease(KeyEvent.VK_SHIFT);
	            }
	            else {
	            robot.keyPress(Character.toUpperCase(c));
	            robot.keyRelease(Character.toUpperCase(c));
	            }
            }
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Random rand = new Random();
        int n = rand.nextInt(3)+ 5;
        //n=1; //used for testing
        System.out.println("the next string will appear in " + n + " mins");
        for(int i = 0; i < n; i++) {
        	System.out.println((n-i) + " mins remaining");
        	robot.delay(60000);
        }
    }
    
    public static void main(String... args) throws Exception {
    	textGenerator fill = new textGenerator();
        AutoTyper autotyper = new AutoTyper();
        autotyper.reader(fill.getFileLocation());
    }
}
