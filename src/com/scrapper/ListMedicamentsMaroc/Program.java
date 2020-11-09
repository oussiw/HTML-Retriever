package com.scrapper.ListMedicamentsMaroc;

import com.scrapper.ListMedicamentsMaroc.Entity.MedecineGroup;
import com.scrapper.ListMedicamentsMaroc.Utilities.FileWritter;
import com.scrapper.ListMedicamentsMaroc.Utilities.GroupFiller;
import com.scrapper.ListMedicamentsMaroc.Utilities.NameFetcher;
import com.scrapper.ListMedicamentsMaroc.Utilities.UrlFetcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Program {

    public static void main(String[] args) throws IOException {

        UrlFetcher urlFetcher = new UrlFetcher("https://medicament.ma/listing-des-medicaments/");
        List<MedecineGroup> result = urlFetcher.fetchUrls();
        GroupFiller filler = new GroupFiller();
        NameFetcher nameFetcher = new NameFetcher();
        FileWritter writter = new FileWritter();

        filler.fillWithUrls(result);
        nameFetcher.fetchNames(result);
        writter.writeIntoFile(result);
        writter.closeFile();
        System.out.println("\n\n============= Here is the result: =============\n");
        for(MedecineGroup group:result) {
            //System.out.println("\n========= Beginning fetching =========\n");
            System.out.println(group);
            System.out.println("\n================ Fin du groupe ================\n");

        }
    }
}
