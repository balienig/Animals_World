package com.example.testlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testlistview.adapter.AnimalListAdapter;
import com.example.testlistview.model.Animal;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // komsan somwong 07570473
    private ListView mListView;
    private ArrayList<Animal> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AnimalData animalData = AnimalData.getsInstance();
        mListView = (ListView) findViewById(R.id.list_view);
        animalData.animalList = new ArrayList<>();
        animalData.animalList.add(new Animal("แมว (Cat)",R.drawable.cat,getString(R.string.details_cat)));
        animalData.animalList.add(new Animal("หมา (Dog)",R.drawable.dog,getString(R.string.details_dog)));
        animalData.animalList.add(new Animal("โลมา (Dolphin)",R.drawable.dolphin,getString(R.string.details_dolphin)));
        animalData.animalList.add(new Animal("กอริล่า (Koala)",R.drawable.koala,getString(R.string.details_koala)));
        animalData.animalList.add(new Animal("สิงโต (Lion)",R.drawable.lion,getString(R.string.details_lion)));
        animalData.animalList.add(new Animal("นกฮูก (Owl)",R.drawable.owl,getString(R.string.details_owl)));
        animalData.animalList.add(new Animal("เพนกวิน (Penguin)",R.drawable.penguin,getString(R.string.details_penguin)));
        animalData.animalList.add(new Animal("หมู (Pig)",R.drawable.pig,getString(R.string.details_pig)));
        animalData.animalList.add(new Animal("กระต่าย (Rabbit)",R.drawable.rabbit,getString(R.string.details_rabbit)));
        animalData.animalList.add(new Animal("เสือ (Tiger)",R.drawable.tiger,getString(R.string.details_tiger)));


        ArrayAdapter adapter = new AnimalListAdapter(
                this,
                R.layout.item,
                animalData.animalList
        );

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animal animal = animalData.animalList.get(position);
                Toast.makeText(MainActivity.this, animal.name, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this,AnimalDetailsActivity.class);
                intent.putExtra("name",animal.name);
                intent.putExtra("picture",animal.picture);
                intent.putExtra("komsan",animal.detail);
                startActivity(intent);
            }
        });
    }
}
// komsan somwong 07570473