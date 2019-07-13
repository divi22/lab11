package exercise;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise1 {

	public static void main(String[] args) throws IOException {
		
		FileReader inputStream = null;
		FileWriter outputStream = null;
		
		inputStream = new FileReader("source.txt");
		outputStream = new FileWriter("target.txt");
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		CopyDataThread thread = new CopyDataThread(inputStream,outputStream);
		service.execute(thread);
		service.shutdown();
		
	}

}

class CopyDataThread extends Thread {
	
	FileReader inputStream = null;
	FileWriter outputStream = null;
	
	
	public CopyDataThread(FileReader inputStream,FileWriter outputStream) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
	}
	
	public void run() {
		
		try {
			
			int count=0;
			int c ;
			while((c = inputStream.read())!=-1) {
				count++;
				if(count%10==0) {
					System.out.println("10 characters are copied");
					Thread.sleep(5000);
				}
				outputStream.write(c);
								
			}
			System.out.println("Character Count is:" +count);
			
			if(inputStream!=null) {
				inputStream.close();
			}
			if(outputStream!=null) {
				outputStream.close();
			}
			
		}
		catch(IOException | InterruptedException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Program End.");		
	}

}
