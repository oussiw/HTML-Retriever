package com.scrapper.intersection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Builder {

    public List<String[]> buildDictionary (String path,String splitter) {
        List<String[]> dictionary = new ArrayList<>();
        String csvFilePath = path;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = splitter;
        try {
            br = new BufferedReader(new FileReader(csvFilePath));
            while ((line = br.readLine()) != null) {
                String[] term = line.split(cvsSplitBy);
                dictionary.add(term);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return dictionary;
    }

//    public void getTable(){
//        int i = 0;
//        for(i=0;i<dictionary.size();i++){
//            for(String term:dictionary.get(i)){
//                System.out.print(term+',');
//            }
//            System.out.println("\n");
//        }
//    }

//    public void search(String term){
//        int i = 0,j=0;
//        for(i=0;i<dictionary.size();i++){
//            for(String buffer:dictionary.get(i)){
//                if(buffer.equals(term)){
//                    System.out.println("Line: "+ (i+1) +"/ Column: "+(j+1));
//                }
//                j++;
//            }
//            j=0;
//        }
//    }

}
