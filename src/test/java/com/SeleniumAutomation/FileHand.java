package com.SeleniumAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileHand {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File fi=new File("C:\\Users\\sai krishna\\Documents\\Sateesh Projects\\File.txt");
		
		
		Scanner sc= new Scanner(fi);
		System.out.println( fi.getName());
		while(sc.hasNext()) {
			System.out.println(sc.next());
		}
		sc.close();
		
	}

}
