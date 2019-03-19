package com.offer.chapter2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveAndReadForSingleton {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Singleton3 singleton3 = Singleton3.getInstance();
		File file = new File("Singleton3.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(singleton3);
			fos.close();
			oos.close();
			System.out.println(singleton3.hashCode());
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Singleton3 s3 = (Singleton3) ois.readObject();
			fis.close();
			ois.close();
			System.out.println(s3.hashCode());
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
