package com.example.krishoksomachar.Pojoclass;

public class CropchdetailsData {
    private  String name;
    private  int childImage;

    public CropchdetailsData(String name, int childImage) {
        this.name = name;
        this.childImage = childImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildImage() {
        return childImage;
    }

    public void setChildImage(int childImage) {
        this.childImage = childImage;
    }
}
