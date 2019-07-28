package com.jiak.app;

public class Main {
    private String name;
    private String filePath;

    public Main(String name, String filePath){
        this.name = name;
        this.filePath = filePath;
    }

    public String  getImageFilePath() {return filePath ;}

    public String getName() {
        return name;
    }

    public void setName(String names) {
        this.name = names;
    }
}
