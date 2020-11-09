package com.scrapper.intersection;

import com.scrapper.listMed.Entity.Medecine;
import com.scrapper.listMed.Entity.MedecineGroup;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileCreator {
	
	private FileWriter f;
	private PrintWriter pw;
	
	public void openFile() throws IOException {

	}
	
	public void writeIntoFile(List<String[]> list) throws IOException {
		try {
			f= new FileWriter("list_medicaments_marocains.csv");
			for(String[] subList:list) {
				f.write(subList[0]+" -- "+subList[1]+";"+subList[2]+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.close();
	}

	public void closeFile() throws IOException {
		System.out.println("Ecriture terminee.");
	}
}
