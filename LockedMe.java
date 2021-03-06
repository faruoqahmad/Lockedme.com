package com.lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe
{
	static final String path = "C:\\File Directory";
	static final String errorMessage= "Some error occured. Please contact admin or sent an E-mail at abc@lockedme.com";
	
	public static void display() 
	{
		System.out.println("1- Check all the files");
		System.out.println("2- Create a new file");
		System.out.println("3- Delete a file");
		System.out.println("4- Search a file");
		System.out.println("5- Exit from the application");
	}
	
	//This method will show all the files in the directory.
	public static void fileDetails() 
	{
		try {
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			if (listOfFiles.length==0)
		System.out.println("No Files exist in the Folder");
			else
			{
				System.out.println("All the files are listed below in Ascending order:\n");
				for(var l:listOfFiles)
				{
					System.out.println(l.getName());
				}
			}
		}
		catch (Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	
	//This method will create a new file in the directory.
	public static void addFile() 
	{
		Scanner sc = new Scanner(System.in);
		try {
			
			String fileName;
			
			System.out.println("Enter the name of the desired a File: ");  
			fileName = sc.nextLine();
			String fl=fileName.toUpperCase();
			
			int linesCount;
			System.out.println("Enter how many lines you have to write in the File: ");
			linesCount=Integer.parseInt(sc.nextLine());
			
			FileWriter wr = new FileWriter(path+ "\\"+fl);
			
			for(int i=1;i<=linesCount;i++)
			{
				System.out.println("Enter the Line: ");
				wr.write(sc.nextLine()+"\n");
			}
			System.out.println(fl +" File has been created successfully");
			wr.close();
		}
		catch (Exception Ex) 
		{
			System.out.println(errorMessage);
		}
	}
	
	//This method will delete the file in a directory.
	public static void deleteFile()
	{
		Scanner sc= new Scanner(System.in);
		try 
		{
			String fileName;
			System.out.println("Enter the name of file to be deleted: ");
			fileName=sc.nextLine();
			String fl=fileName.toUpperCase();
			
			File file = new File(path+"\\"+fl);
			if(file.exists())
			{
				file.delete();
				System.out.println(fl +" File deleted successfully: ");
			}
			else
			{
				System.out.println("File is not present");
			}
		}
		catch (Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	
	//This method will search a file in a directory.
	public static void searchFile() 
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			String fileName;
			System.out.println("Enter the same name of a file to be searched: ");
			fileName=sc.nextLine();
			String fl=fileName.toUpperCase();
			
			File folder = new File(path);
			File[] listOfFiles = folder.listFiles();
			
			LinkedList<String> fileNames = new LinkedList<String>();
			
			for(var l:listOfFiles)
				fileNames.add(l.getName());
			
			if(fileNames.contains(fileName))
				System.out.println(fileName + " File is available.");
			else
				System.out.println(fileName+" File is not available");
		}
		catch(Exception Ex)
		{
			System.out.println(errorMessage);
		}
	}
	
	//This method will exit from the application.
	public static void exit() 
	{
		System.out.println("");
		System.out.println("****************************************************************************************************");
		System.out.println("Thanks for using the application");
	}
	
	public static void main(String[]args) 
	{
		System.out.println("****************************************************************************************************");
		System.out.println("\t\t\t\t WELCOME TO LOCKEDME.COM");
		System.out.println("****************************************************************************************************");
		Scanner sc = new Scanner(System.in);	
		int num=0;
		try {
			do {
				display();
				System.out.println("");
				System.out.println("Enter a number to select the operation above:");
				num =Integer.parseInt(sc.nextLine());
				
				switch(num) {
				case 1:
					fileDetails();
					System.out.println("----------------------------------------------------------------------------------------");
				    break;
				case 2:
				    addFile();
				    System.out.println("----------------------------------------------------------------------------------------");
				    break;
				case 3:
				    deleteFile();
				    System.out.println("----------------------------------------------------------------------------------------");
				    break;
				case 4:
				    searchFile();
				    System.out.println("----------------------------------------------------------------------------------------");
				    break;
				case 5:
				    exit();
				    System.out.println("****************************************************************************************************");
				    System.exit(0);
				    break;
				default:
					System.out.println("You are entering a wrong number");
					System.out.println("");
					}

				}
			while (num>0);
				sc.close();
			}
			catch (InputMismatchException e) {
				System.out.println("InputMismatchException Error");
			}
			catch (Exception e) {
				System.out.println(errorMessage);
			}
		}
	}
