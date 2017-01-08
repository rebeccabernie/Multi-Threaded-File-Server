// G00320698 - Rebecca Kane
// Runner class - brings everything together

package ie.gmit.sw.client;

import java.util.Scanner;

import ie.gmit.sw.client.config.*;
import ie.gmit.sw.server.Server;


public class Runner {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) throws Throwable {
		
		Parsetor p = new Parsetor();
		XMLParser xmlp = new XMLParser(p);
		xmlp.init();
		
		System.out.println(p);
		
		UserInterface u = new UserInterface();
		Connector c = new Connector();
		Fileator f = new Fileator(); // Create instance of Fileator class

		u.menu(); // thought outputting the menu once at the start looked less cluttered
		
		
		// While loop specified in project spec
		while(u.choice != 4){
			
			System.out.println("\nSelect an option [1 - 4]");
			u.choice = console.nextInt();
			
			if(u.choice == 1){
				// Connect to server
				Server server = new Server();
				c.openConnection();
			} // End choice 1
			
			
			else if(u.choice == 2){
				// List of Files available to download
				System.out.println("Files Available for Download:");				
				Fileator.listDownloadableFiles();
				
			} // End choice 2
			
			else if(u.choice == 3){
				f.downloadFile(); // run download file method...
				
			} // End choice 3
			
			else if(u.choice == 4) {
				// End program 					closeConnection should be accessed statically? hence Connector and not c
				Connector.closeConnection(); // Close connection, good practice
				System.out.println("Connection closed...\nProgram terminated.");
			} // End choice 4
			
			else { // just in case user tries an invalid option
				System.out.println("Please enter a valid option...");
				u.choice = console.nextInt(); // Allow user to enter an option again
			}
			
		} // End while
		
	} // End run()

} // End class
