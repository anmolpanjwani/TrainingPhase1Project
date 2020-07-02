package com.lockerapp.main;

import java.util.Scanner;

import com.lockerapp.exception.BusinessException;
import com.lockerapp.bo.FileLockerBO;
import com.lockerapp.bo.impl.FileLockerBOImpl;
import com.lockerapp.model.FileLocker;
import java.lang.Integer;
public class FileLockerMain {

	public static void main(String[] args) {
		System.out.println("Hello! Welcome to the LockedMe App!");
		System.out.println("This application is a prototype version developed by Ms. Anmol Panjwani.");
		System.out.println("Check out the cool features below to organize your files better.");	
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		FileLockerBO flockbo = new FileLockerBOImpl();
		int ch = 0;
		do {
			System.out.println("---------The Main Menu--------");
			System.out.println("\n");
			System.out.println("1. View the files in Ascendingly Sorted Order");
			System.out.println("2. Perform Business-Level Operations on Files");
			System.out.println("3. Close the App");	
			System.out.println("Enter your choice as 1, 2 or 3");
			try {
				ch = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid number please");
			}
			
			switch(ch) {
			case 1: flockbo.getAllCurrentFiles();
				break;
			case 2: int inch = 0;
			do {
				System.out.println("---------The Inner Menu--------");
				System.out.println("\n");
				System.out.println("1. Add a file by specifying name.");
				System.out.println("2. Delete a file by specifying name.");
				System.out.println("3. Search a file by specifying name.");	
				System.out.println("4. Navigate to Main Menu.");
				inch = Integer.parseInt(scanner.nextLine());
//				if(Integer.toString(inch).isEmpty()) {
//					throw new BusinessException("Nothing entered.Please input a valid choice.");
//				}
				
				switch(inch) {
				case 1: System.out.println("Enter the filename:");
				String filename = scanner.nextLine();
				FileLocker fileobj = new FileLocker(filename);
				try {
					fileobj = flockbo.addFile(fileobj);
					if (fileobj != null && fileobj.getFilename() != null) {
						System.out.println("File with name "+fileobj.getFilename()+" is created.");
					}
				} catch (BusinessException e1) {
					System.out.println(e1.getMessage());
				}
				
					break;
					
				case 2: System.out.println("Enter the filename:");
						String file = scanner.nextLine();
						FileLocker fileob = new FileLocker(file);
						flockbo.deleteFileByName(fileob.getFilename());
							break;
				case 3:
						System.out.println("Enter the filename:");
						String file1 = scanner.nextLine();
						try {
							if(file1.isEmpty()) {
								System.out.println("Nothing entered.Please input a valid choice.");
							}
							if(file1==" ") {
								System.out.println("Nothing entered.Please input a valid choice.");
							}
						}
						catch (BusinessException e) {
							// TODO: handle exception
						}
						FileLocker fileobjj = new FileLocker(file1);
						fileobjj = flockbo.searchFileByName(file1);
						if(fileobjj==null) {
							System.out.println("File doesn't exist");
						}
						else {
							System.out.println("File "+fileobjj+" found");
						}
						break;
						
				case 4: System.out.println("Redirecting you to Main Menu.");
					break;
				default: System.out.println("Invalid option. Please try again.");
				}
				
				
			}while(inch!=4);
				break;
			case 3: System.out.println("Thank you for using our App!");
				break;
			default: System.out.println("Invalid option. Please try again.");
				break;
			}
		}while(ch!=3);
		
	}

}
