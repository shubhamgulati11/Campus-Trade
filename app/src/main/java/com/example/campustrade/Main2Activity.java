package com.example.campustrade;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    RecyclerView rv;
    ArrayList<product> pro = new ArrayList<>();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference rootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseDatabase = FirebaseDatabase.getInstance();
        rootReference = firebaseDatabase.getReference();

        rootReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> dataSnapshots = dataSnapshot.getChildren();

                pro = new ArrayList<>();

                for(DataSnapshot ds : dataSnapshots){
//                    Task currentTask = ds.getValue(Task.class);
//                    Log.e("TAG",""+currentTask.title);
                    product recipe = ds.getValue(product.class);
                    pro.add(recipe);
                }
                Adapter adapter = new Adapter(pro, Main2Activity.this);
                rv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(i);
            }
        });

//        Bitmap bm1 = BitmapFactory.decodeResource(getResources(), R.drawable.laptop);
//        Bitmap bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.phone);
//        Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.watch);
//        Bitmap bm4 = BitmapFactory.decodeResource(getResources(), R.drawable.calculator);

//        pro.add(new product("Laptop", "123", "Dell", bm1));
//        pro.add(new product("Phone", "234", "Oppo", bm2));
//        pro.add(new product("Watch", "456", "Casio", bm3));
//        pro.add(new product("Calculator", "896", "F991Ex", bm4));

        rv=findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }


}
