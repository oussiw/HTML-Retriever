package com.scrapper.ListMedicamentsMaroc.Entity;

import java.util.List;

public class MedecineGroup {
    private char caractere;
    private int nbPages;
    private String url;

    public MedecineGroup(char caractere, String url) {
        this.caractere = caractere;
        this.url = url;
    }

    private List<String> urls;
    private List<String> MedNames;

    public List<String> getMedNames() {
        return MedNames;
    }

    public void setMedNames(List<String> medNames) {
        MedNames = medNames;
    }

    public char getCaractere() {
        return caractere;
    }

    public void setCaractere(char caractere) {
        this.caractere = caractere;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public MedecineGroup(){

    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "MedecineGroup{" +
                "caractere=" + caractere +
                ", nbPages=" + nbPages +
                ", url='" + url + '\'' +
                ", urls=" + urls +
                ", MedNames=" + MedNames +
                '}';
    }
}
