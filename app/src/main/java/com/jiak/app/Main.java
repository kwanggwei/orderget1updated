package com.jiak.app;

public class Main {
    private String name;
    private int cost;
    private String filePath;

    public Main(String name, int cost, String filePath){
        this.name = name;
        this.cost = cost;
        this.filePath = filePath;
    }

    public String  getImageFilePath() {return filePath ;}

    public String getName() {
        return name;
    }

    public void setName(String names) {
        this.name = names;
    }

    public int getCost(){
        return cost;
    }

    public void setCost(int cost){
        this.cost = cost;
    }
}
