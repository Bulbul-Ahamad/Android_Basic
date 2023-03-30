package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ProductList> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recycler View
        RecyclerView recycler = findViewById(R.id.recycler);
        //calling Layout Manager
        recycler.setLayoutManager(new GridLayoutManager(this,2));

//        ProductList pL = new ProductList()
        arrayList.add(new ProductList(R.drawable.a,"A","100"));
        arrayList.add(new ProductList(R.drawable.b,"B","160"));
        arrayList.add(new ProductList(R.drawable.c,"C","170"));
        arrayList.add(new ProductList(R.drawable.d,"D","100"));
        arrayList.add(new ProductList(R.drawable.e,"E","100"));
        arrayList.add(new ProductList(R.drawable.f,"F","100"));
        arrayList.add(new ProductList(R.drawable.g,"G","160"));
        arrayList.add(new ProductList(R.drawable.h,"H","100"));
        arrayList.add(new ProductList(R.drawable.i,"I","130"));
        arrayList.add(new ProductList(R.drawable.j,"J","120"));
        arrayList.add(new ProductList(R.drawable.k,"K","100"));
        arrayList.add(new ProductList(R.drawable.l,"L","110"));
        arrayList.add(new ProductList(R.drawable.m,"M","140"));
        arrayList.add(new ProductList(R.drawable.n,"N","180"));
        arrayList.add(new ProductList(R.drawable.o,"O","189"));

        RecyclerProductAdapter ad = new RecyclerProductAdapter(this,arrayList);
        recycler.setAdapter(ad);

    }
}