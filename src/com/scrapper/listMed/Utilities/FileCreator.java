package com.scrapper.listMed.Utilities;

import com.scrapper.listMed.Entity.Medecine;
import com.scrapper.listMed.Entity.MedecineGroup;

import java.io.*;
import java.util.List;

public class FileCreator {
	
	private FileWriter f;
	private PrintWriter pw;
	
	public void openFile() throws IOException {

	}
	
	public void writeIntoFile(List<MedecineGroup> list) throws IOException {
		try {
			f= new FileWriter("data.csv");
			for(MedecineGroup group:list) {
				for(Medecine m:group.getMedocs()) f.write(m.getEngName().toUpperCase()+"//"+m.getArName()+"\n");
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
