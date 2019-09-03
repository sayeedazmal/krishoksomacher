package com.example.krishoksomachar.Pojoclass;

public class DeasesData {
    private int imagename;
    private String deasesname;

    public DeasesData(int imagename,String deasesname) {
        this.imagename = imagename;
        this.deasesname= deasesname;
    }

    public int getImagename() {
        return imagename;
    }

    public void setImagename(int imagename) {
        this.imagename = imagename;
    }

    public String getDeasesname() {
        return deasesname;
    }

    public void setDeasesname(String deasesname) {
        this.deasesname = deasesname;
    }
}
