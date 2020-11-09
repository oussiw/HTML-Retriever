package com.scrapper.ListMedicamentsMaroc.Utilities;

import com.scrapper.ListMedicamentsMaroc.Entity.MedecineGroup;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWritter {
	
	private FileWriter f;
	private PrintWriter pw;

	public void writeIntoFile(List<MedecineGroup> list) throws IOException {
		try {
			f= new FileWriter("data3.txt");
			for(MedecineGroup group:list) {
				for(String m:group.getMedNames()) f.write(m.toUpperCase()+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		f.close();
	}
	public void closeFile() {
		System.out.println("Ecriture terminee.");
	}
}
