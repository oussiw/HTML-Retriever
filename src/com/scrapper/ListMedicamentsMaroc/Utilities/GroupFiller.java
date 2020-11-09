package com.scrapper.ListMedicamentsMaroc.Utilities;

import com.scrapper.ListMedicamentsMaroc.Entity.MedecineGroup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GroupFiller {
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public GroupFiller() {
	}

	public void fillWithUrls(List<MedecineGroup> groups){
		System.out.println("============= Begin Url creation: =============\n");
		for (MedecineGroup group:groups){
			try {
				Document doc = Jsoup.connect(group.getUrl()).userAgent("Mozilla/17.0").get();
				//System.out.println(doc.body());
				Elements elements = doc.select("a");
				for (Element e:elements) {
					if(e.getElementsByTag("span").text().equals("»")){
//						System.out.println(e.attr("href"));
						if(e.attr("href").indexOf('?') == 53){
//							System.out.println(e.attr("href").substring(51,52));
							int nbPages = Integer.parseInt(e.attr("href").substring(51,52));
							group.setNbPages(nbPages);
						}
						else if(e.attr("href").indexOf('?') == 54){
//							System.out.println(e.attr("href").substring(51,53));
							int nbPages = Integer.parseInt(e.attr("href").substring(51,53));
							group.setNbPages(nbPages);
						}

					}
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			if(group.getNbPages()!=0){
				List<String> urls = new ArrayList<String>();
				for(int i=1;i<=group.getNbPages();i++){
					urls.add("https://medicament.ma/listing-des-medicaments/page/"+i+"/?lettre="+group.getCaractere());
				}
				group.setUrls(urls);
			}
			else {
				List<String> urls = new ArrayList<String>();
				urls.add(group.getUrl());
				group.setUrls(urls);
			}
		}
	}
}
