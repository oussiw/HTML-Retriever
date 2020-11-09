package com.scrapper.ListMedicamentsMaroc.Utilities;

import com.scrapper.ListMedicamentsMaroc.Entity.MedecineGroup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
		System.out.println("============= Begin group creation: =============\n");
		List<MedecineGroup> medUrls = new ArrayList<MedecineGroup>();
		int i = 0;
		try {	
			Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
			//System.out.println(doc.body());
			Elements elements = doc.select("a");
			for (Element e:elements) {
				if(e.attr("class").equals("btn btn-default btn-sm ") || e.attr("class").equals("btn btn-default btn-sm active"))	{
//					System.out.println(e.text());
					for(char letter = 'A';letter<='Z';letter++) {
						if(letter==e.text().charAt(0)) {
//							System.out.print(e.text().charAt(0)+" -> ");
//							System.out.println(e.attr("href"));
							medUrls.add(new MedecineGroup(e.text().charAt(0),e.attr("href")));
							i++;
						}
					}
				}
//				else if(e.getElementsByTag("span").text().equals("»")){
//					System.out.println(e.attr("href"));
//				}
			}
			System.out.println("Number of groups created: "+i);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return medUrls;
	}
}
