// G00320698 - Rebecca Kane
package ie.gmit.sw.server;

import java.io.*;
import java.net.*;

// Basic Web Server code from "WebServer Source Code" (Lecturer John Healy) on moodle
// - using this for now

public class Server {

	private ServerSocket serverSock; 
	private static final int PORT = 7777;  
	private volatile boolean keepRunning = true;
	
	private Server() // private because 
	{
		try 
		{ 
			serverSock = new ServerSocket(PORT);
			Thread serverThread = new Thread(new Listener(), "Web Server Listener");
			serverThread.setPriority(Thread.MAX_PRIORITY); 
			serverThread.start();			
			System.out.println("Server started and listening on port " + PORT);
			
		} 
		catch (IOException e) 
		{
			System.out.println("Error - " + e.getMessage());
		}
	} // end private Server method
	
	// Main method required to start the program
	public static void main(String[] args) {
		new Server(); // Create instance of a Server
	}
	
	private class Listener implements Runnable{ //A Listener IS-A Runnable
		
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

            } catch (Exception e) { 
            	System.out.println("Error processing request from " + sock.getRemoteSocketAddress());
            	e.printStackTrace();
            }
        } // End run()
		
	} // End HTTPRequest class
	
} // End Server class
