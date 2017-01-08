Multi-Threaded File Server README
Object Oriented Programming 2016
G00320698 Rebecca Kane

This Multi-Threaded File Server allows a user to:
	- Connect to the server
	- Display a list of files available for download
	- Download a specified file
	- Exit the program 

---------- STEP 1 ------------
In order for the application to work, the user must first run the Server.java file.
If a connection is correctly established, "Server running" will appear on the screen.

Upon first run sometimes the menu will be displayed, if this happens just cancel the run and re-run the server, this should solve the problem!

---------- STEP 2 ------------
The user must then run the Runner.java file - this file will handle all input/output to the screen.

---------- STEP 3 ------------
The following menu will appear on screen -

	1: Connect to Server
	2: Print File Listing
	3: Download File
	4: Quit
	Select an option [1 - 4]

The user must first set up the connection, otherwise the rest of the options will return errors. 
Simply enter 1 on the console - "Server connected" will display if a connection was established, if not an error will be shown.

Option 2: Print File Listing
This option allows the user to see all available files for download. This list includes files and directories - labelled as such. The program will recognise most popular file types, including .txt and .jpg.
** If you enter a file name that doesn't exist, no error will show up - just enter a file name from the list if this happens!



Option 3: Download File			*not working yet*
This option allows the user to download a particular file. The user will be promted to enter a file name - please make sure the file name is the same as it appears on the list above, including the correct extension! Press enter to start the download.

Option 4: Quit
This option will end the program - it will also close any connection to the server. 
If you would like to re-run the program, you will have to start from STEP 1 and also select option 1 on the menu before selecting any other option.