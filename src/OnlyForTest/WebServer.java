package OnlyForTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	private static final int port = 8888;
	private static final String uri = System.clearProperty("user.dir")+File.separator+"webroot"+File.separator;
	
	public WebServer() {
		System.out.println("Webserver()---start");
		System.out.println("url-----------uri");
		System.out.println("File----------"+File.separator);
		
		try{
			//1
			ServerSocket listener = new ServerSocket(port);
			//2
			while(true){
				//2.1
				Socket socket = listener.accept();
				
				//2.2
				PrintStream out = new PrintStream(socket.getOutputStream(),true);
				
				//2.3
				File fileuri = new File(uri+"index.html");
				
				//2.4
				String status = "";
				String contentType = null;
				contentType =status+ "text/html";
				
				//2.5
				if(!fileuri.exists()){
					System.out.println("no file");
				}else{
					System.out.println("fileuri OK");
					out.println("HTTP/1.0 200 OK"); 
					out.println(contentType); 
					out.println();  
				}
				
				//2.6
				FileInputStream fis = null;
				fis = new FileInputStream(fileuri);
				
				//2.7
				byte data[];
				data = new byte[fis.available()];
				
				//2.8
				fis.read(data);
				
				out.write(data);
				out.close();
				
				//2.9
				if(fis!=null){
					fis.close();
				}
				socket.close();
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args){
		new WebServer();
	}

}
