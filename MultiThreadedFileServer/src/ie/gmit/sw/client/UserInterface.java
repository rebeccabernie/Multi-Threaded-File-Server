package ie.gmit.sw.client;

import java.util.Scanner;

public class UserInterface {

	Scanner console = new Scanner(System.in);
	public int choice; // User's choice on menu
	
	public UserInterface(){
		super();
	}
	
	public int getChoice() {
		return choice;
	}
	
	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	// Menu
	@Override
	public String toString() {
		return "1: Connect to Server\n2: Print File Listing\n3: Download File\n4: Quit\nSelect an option [1 - 4]";
	}
	
	// 
	public int menu(){
		choice = console.nextInt();
		return choice;
	}
	
}
