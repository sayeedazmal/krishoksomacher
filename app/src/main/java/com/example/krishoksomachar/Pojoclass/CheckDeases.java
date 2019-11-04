package com.example.krishoksomachar.Pojoclass;

import android.os.Bundle;

import java.util.Random;
import java.util.Arrays;

public class CheckDeases {

    int count =0;
    String[] diseaseList = {"ধানের ব্লাস্ট রোগ", "ধানের পাতাপোড়া রোগ", "ধানের বাকানী রোগ", "ধানের পামরী পোকা",
        "ধানের পাতামাছি পোকা", "ধানের খোলপোড়া রোগ" , "ধানের মাজরা পোকা"};

    String[] shorList = { "blast", "blb", "footrot", "hispa",
    "patamasi", "sheath rot", "stemborer"};

    Random rand = new Random();

    public String findLabel(String plantName){

        for(String name: shorList){
            if (plantName.contains(name)){
                int index =  Arrays.asList(shorList).lastIndexOf(name);
                return diseaseList[index];
            }
        }
        return "No matching any deases!!";
//        int index = rand.nextInt(diseaseList.length);
//        return diseaseList[index];
    }



}