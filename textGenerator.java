import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;
import java.util.Random;
import java.util.Scanner;

public class textGenerator {
	
	private String[] collection = new String[20];
	private static final String location = "..writeTo.txt"; // filepath to writeTo file
	
	public textGenerator() throws IOException {
		readfile("..readThis.txt"); // filepath to readThis file
		writeFile();
	}
	
	public String getFileLocation() {
		String finish = textGenerator.location;
		return finish;
	}
	
	private void readfile(String nameofFile) {
		for(int i = 0; i < this.collection.length; i++) {
			this.collection[i] = "";
		}
		Scanner sc;
		try
	    {
	      sc = new Scanner(new File(nameofFile));
	      System.out.println("file was found");
	      for(int i = 0; i < this.collection.length && sc.hasNextLine(); i++) {
				this.collection[i] = sc.nextLine();
			}
	      sc.close();
	    }
	    catch(FileNotFoundException s)
	    {
	      System.out.println("File does Not Exist Please Try Again: ");
	    }
	}
	
	private void writeFile() throws IOException {
		try {
		String input = "";
		Random rand = new Random();
		BufferedWriter writer = new BufferedWriter(new FileWriter(textGenerator.location));
		for(int i = 0; i < 100; i++) {
			int n = rand.nextInt(this.collection.length);
			input = this.collection[n];
			if (input == "") {
				continue;
			}
			input += "\n";
		    writer.write(input);
		}
	    writer.close();
	    }
		catch(IOException e ) {
			System.out.println("failed to write");
		}
	}
}
