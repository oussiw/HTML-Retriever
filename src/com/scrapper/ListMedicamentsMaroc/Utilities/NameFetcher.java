package com.scrapper.ListMedicamentsMaroc.Utilities;

import com.scrapper.ListMedicamentsMaroc.Entity.MedecineGroup;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NameFetcher {
    public NameFetcher() {
    }

    public void fetchNames(List<MedecineGroup> groups){
        System.out.println("============= Begin Name searching: =============\n");
        for(MedecineGroup group:groups){
            List<String> names = new ArrayList<>();
            for(String url:group.getUrls()){
                try {
                    Document doc = Jsoup.connect(url).userAgent("Mozilla/17.0").get();
                    Elements elements = doc.select("span.details");
                    for (Element e:elements) {
                        System.out.println(e.text());
                        names.add(e.text());
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            group.setMedNames(names);
        }
    }
}
