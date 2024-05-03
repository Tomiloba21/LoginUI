package com.example.judepast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.judepast.Adapter.TrendsAdapter;
import com.example.judepast.Domain.TrendsDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTrendsList;
    private RecyclerView recyclerViewTrends;



//    EditText fName, lName, mail;
//    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecylerView();

        BottomNavigation();


//        fName = findViewById(R.id.edit_fName);
//        lName = findViewById(R.id.edit_lName);
//        mail = findViewById(R.id.edit_mail);
//
//
//        //GETTING VALUES FROM THE EDITTEXT
//
//        String first_Name = String.valueOf(fName);
//        String last_Name = String.valueOf(lName);
//        String email = String.valueOf(mail);

    }

    private void BottomNavigation() {

        LinearLayout profileBtn = findViewById(R.id.profileBtn);

        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
    }

    private void initRecylerView() {
        ArrayList<TrendsDomain> items = new ArrayList<>();


        items.add(new TrendsDomain("Future in AI what will Tomorrow be like","The National","trends"));
        items.add(new TrendsDomain("Important points in concluding a work contract","Reuters","trends2"));
        items.add(new TrendsDomain("Future in AI what will\n Tomorrow be like","The National","trends"));

        recyclerViewTrends = findViewById(R.id.view1);

        recyclerViewTrends.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapterTrendsList = new TrendsAdapter(items);

        recyclerViewTrends.setAdapter(adapterTrendsList);


    }

}