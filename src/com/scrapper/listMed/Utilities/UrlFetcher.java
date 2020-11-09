package com.scrapper.listMed.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import com.scrapper.listMed.Entity.MedecineGroup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class UrlFetcher {
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public UrlFetcher(String url) {
		super();
		this.url = url;
	}

	public List<MedecineGroup> fetchUrls(){
		System.out.println("============= Begin urls fetching: =============\n");
		List<MedecineGroup> medUrls = new ArrayList<MedecineGroup>();
		int i = 0;
		try {	
			Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
			Elements elements = doc.select("li");
			for (Element e:elements) {
				for(char letter = 'A';letter<='Z';letter++) {
					if(letter==e.getElementsByTag("a").first().text().charAt(0)) {
						System.out.print(e.getElementsByTag("a").first().text()+" -> ");
						System.out.println(e.getElementsByTag("a").attr("href"));
						medUrls.add(new MedecineGroup(e.getElementsByTag("a").first().text().charAt(0),e.getElementsByTag("a").attr("href")));
						i++;
					}
				}
			}
			System.out.println("Number of groups: "+i);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return medUrls;
	}
}
