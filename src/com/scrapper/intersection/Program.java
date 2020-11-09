package com.scrapper.intersection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Builder builder = new Builder();
        List<String[]> meds = builder.buildDictionary("data.csv","//");
        List<String[]> medMas = builder.buildDictionary("data2.csv","-");

        List<String[]> medicaments = new ArrayList<String[]>();
        int i=0;
        for(String[] med:meds){
            String[] medSplit = med[0].split(" ");
            for(String[] medMa:medMas){
                if(medMa[0].contains(medSplit[0])){
                    System.out.println(medSplit[0]+"  --  "+medMa[0]);
                    i++;
                    String[] tmp = {medMa[0],med[0],med[1]};
                    medicaments.add(tmp);
                    break;
                }
            }
        }
        System.out.println("Nombre de correspondance: "+i);
        i =0;
        for(int k=0;k<medicaments.size();k++){
            int d = 0;
            for(int j=k;j<medicaments.size();j++){
                if(medicaments.get(k)[0].equals(medicaments.get(j)[0])){
                    if(d>0){

                    }
                    System.out.println(medicaments.get(k)[1]+" -- "+medicaments.get(j)[1]);
                    i++;
                    medicaments.remove(j);
                    d++;
                }

            }
        }
        System.out.println("Nombre de ligne repetee: "+i);
        FileCreator creator = new FileCreator();
        try {
            creator.writeIntoFile(medicaments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
