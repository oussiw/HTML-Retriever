package com.scrapper.listMed;

import com.scrapper.listMed.Utilities.FileCreator;
import com.scrapper.listMed.Utilities.NameFetcher;
import com.scrapper.listMed.Utilities.UrlFetcher;
import com.scrapper.listMed.Entity.MedecineGroup;

import java.io.IOException;
import java.util.List;

public class Program {

	public static void main(String[] args) throws IOException {
		
		UrlFetcher urlFetcher = new UrlFetcher("https://www.webteb.com/drug");
		List<MedecineGroup> result = urlFetcher.fetchUrls();
		NameFetcher fetcher = new NameFetcher();
		FileCreator creator = new FileCreator();
		int i=0;
		for(MedecineGroup group:result) {
			System.out.println("\n========= Beginning fetching =========\n");
			fetcher.fetchNames(group);
			System.out.println("\n================ Fin du groupe ================\n");
			i++;
		}
		System.out.println("\n========= Beginning writting =========\n");
		creator.writeIntoFile(result);
		System.out.println("Number of groups: "+i);
		creator.closeFile();
	}

}
