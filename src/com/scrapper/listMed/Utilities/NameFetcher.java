package com.scrapper.listMed.Utilities;

import java.io.IOException;

import com.scrapper.listMed.Entity.Medecine;
import com.scrapper.listMed.Entity.MedecineGroup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class NameFetcher {

	public NameFetcher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void fetchNames(MedecineGroup group) {
		try {	
			int i = 0;
			Document doc = Jsoup.connect(group.getUrl()).userAgent("Mozilla/17.0").get();
			Elements elements = doc.select("tr");
			for (Element e:elements) {
				if(e.hasAttr("itemscope")) {
					Medecine medecine = new Medecine();
					Elements temp = e.getElementsByTag("td");
					for(Element a:temp) {
						if(a.attr("class").equals("text-right")) {
							//Name in Arabic
							System.out.print(a.getElementsByTag("a").first().getElementsByTag("span").text()+" / ");
							medecine.setArName(a.getElementsByTag("a").first().getElementsByTag("span").text());
						}
						
						else if(a.getElementsByTag("span").attr("itemprop").equals("alternateName")) {
							//Name in English
							System.out.println(a.getElementsByTag("span").text());
							medecine.setEngName(a.getElementsByTag("span").text());
						}
					}
					group.addMedecine(medecine);
					i++;
				}
			}
			System.out.println("Number of added elements: "+i);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
