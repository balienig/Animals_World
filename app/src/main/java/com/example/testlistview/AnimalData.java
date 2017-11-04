package com.example.testlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testlistview.model.Animal;

import java.util.ArrayList;

public class AnimalData  {
    private static AnimalData sInstance;

    public ArrayList<Animal> animalList;


    public static AnimalData getsInstance(){
        if(sInstance == null){
            sInstance = new AnimalData();
        }
        return sInstance;
    }

}
