// G00320698 - Rebecca Kane
// Server class - server side functionality
package ie.gmit.sw.server;

import java.io.*;
import java.net.*;

// Basic Web Server code from "WebServer Source Code" (Lecturer John Healy) on moodle
// - using this for now

public class Server {

	private ServerSocket serverSock; 
	private static final int PORT = 7777;  
	private volatile boolean keepRunning = true;
	
	public Server()
	{
		try 
		{ 
			serverSock = new ServerSocket(PORT);
			Thread serverThread = new Thread(new Listener(), "Web Server Listener");
			serverThread.setPriority(Thread.MAX_PRIORITY); 
			serverThread.start();
			
			System.out.println("Server started and listening on port " + PORT);
			
		} catch (IOException e) 
		{
			System.out.println("Error - " + e.getMessage());
		}
	} // end private Server method
	
	
	//A main method is required to start a standard Java application
	public static void main(String[] args) {
		//new Server(); //Create an instance of a WebServer. This fires the constructor of WebServer() above on the main stack
		System.out.println("Server running...");
	}
	
	private class Listener implements Runnable { // Listener "IS-A" Runnable
		
		public void run() { // run() must be implemented
			
			int count = 0; // Amount of requests
			
			while (keepRunning){ 
				try { 
					Socket socket = serverSock.accept();
					new Thread(new HTTPRequest(socket), "T-" + count).start(); 
					count++; // Add to request count
				} catch (IOException e) { 
					System.out.println("Error - " + e.getMessage());
				}
			} // End while
			
		} // End run()
		
	}// End Listener class
	
	private class HTTPRequest implements Runnable{
		private Socket sock; //A specific socket connection - different to socket or serverSock

		private HTTPRequest(Socket request) { 
			this.sock = request; // Value for request is assigned to this instance of sock
		}

		public void run() { // Again, run() must be implemented
            try{
            	/*
            	//Read in the request from the remote computer to this program (Deserialization / Unmarshalling)
            	ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
                Object command = in.readObject(); // Deserialise request into an Object
                System.out.println(command);

                //Write out a response back to the client (Serialization / Marshalling)
                String message = "Response";
            	ObjectOutputStream out = new ObjectOutputStream(sock.getOutputStream());
                out.writeObject(message);
                out.flush();
                out.close(); // Good practice to close after use
*/
            	//System.out.println("Server connected."); - displays after the prompt to the user, just commented out to avoid any confusion
            	System.out.print("");
            } catch (Exception e) { 
            	System.out.println("Error processing request from " + sock.getRemoteSocketAddress());
            	e.printStackTrace();
            }
        } // End run()
		
	} // End HTTPRequest class
	
} // End Server class
