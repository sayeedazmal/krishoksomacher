package com.example.krishoksomachar.Pojoclass;

public class Cropdetailsdata {
    private String name;
    private int cropImage;

    public Cropdetailsdata(String name, int cropImage) {
        this.name = name;
        this.cropImage = cropImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCropImage() {
        return cropImage;
    }

    public void setCropImage(int cropImage) {
        this.cropImage = cropImage;
    }
}
